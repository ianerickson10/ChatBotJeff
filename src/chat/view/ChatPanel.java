package chat.view;

import javax.swing.*;
import chat.controller.ChatController;
import chat.controller.IOController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private SpringLayout appLayout;
	private JButton chatButton;
	private JButton checkerButton;
	private JButton loadButton;
	private JButton saveButton;
	private JTextField chatField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private JButton resetButton;
	private JButton tweetButton;
	private JButton searchTwitterButton;
	
	public ChatPanel(ChatController appController)
	{
		super();
		
		this.appController = appController;
		appLayout = new SpringLayout();
		
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 6, SpringLayout.EAST, saveButton);
		chatButton =  new JButton("Chat");
		checkerButton = new JButton("Check Text");
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 66, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, checkerButton);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerBumemetton, -10, SpringLayout.SOUTH, this);
		resetButton = new JButton("Reset");
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 21, SpringLayout.EAST, resetButton);
		appLayout.putConstraint(SpringLayout.NORTH, resetButton, 0, SpringLayout.NORTH, checkerButton);
		appLayout.putConstraint(SpringLayout.WEST, resetButton, 18, SpringLayout.EAST, checkerButton);
		
		chatField = new JTextField("Talk to the bot here", 50);
		appLayout.putConstraint(SpringLayout.EAST, chatField, -6, SpringLayout.WEST, chatButton);
		chatArea = new JTextArea("", 40, 50);
		chatPane = new JScrollPane();
		appLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 12, SpringLayout.SOUTH, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 12, SpringLayout.SOUTH, chatPane);
		tweetButton = new JButton("Tweet");
		searchTwitterButton = new JButton("Search Twitter");
				
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	//------------------------------------------------------------------------------\\

	private void setupScrollPane()
	{
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		
		chatPane.setViewportView(chatArea);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(1024, 768));
		this.setBackground(Color.LIGHT_GRAY);
		this.add(chatPane);
		this.add(chatButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(checkerButton);
		this.add(chatField);
		this.add(resetButton);
		this.add(tweetButton);
		this.add(searchTwitterButton);
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatPane, -50, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatPane, 25, SpringLayout.NORTH, this);
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String input = chatField.getText();
				String output = "";
				output = appController.interactWithChatbot(input);
				chatArea.append(output);
				chatField.setText("");
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String chatText = chatArea.getText();
				String path = getPath("Save");
				IOController.savetext(appController, path, chatText);
				chatArea.setText("ChatSaved!\n");
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String path = getPath("load");
				String chatText = IOController.loadFile(appController, path);
				chatArea.setText(chatText);
			}
		});
		
		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//code
			}
		});
		
		resetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				chatArea.setText("");
				chatField.setText("");
			}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformmed(ActionEvent tweetClick)
			{
				String textToTweet = chatField.getText().trim();
				appController.tweet(textToTweet);
			}
		});
		
		searchTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformmed(ActionEvent tweetClick)
			{
				String username = chatField.getText().trim();
				String display = appController.findWords(username);
				chatArea.append("\n\n" + display);
			}
		});
	}
	
	private String getPath(String choice)
	{
		String path = ".";
		int result = -99;
		JFileChooser fileChooser = new JFileChooser();
		if(choice.equals("save"))
		{
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			result = fileChooser.showSaveDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getCurrentDirectory().getAbsolutePath();
			}
		}
		else
		{
			result = fileChooser.showOpenDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getSelectedFile().getAbsolutePath();
			}
		}
		return path;
	}
}
