package chat.controller;

import javax.swing.JOptionPane;

import chat.model.ChatModel;

import java.util.ArrayList;


public class ChatController
{
	simpleBot = new ChatModel();
	
	public void start()
	{
		JOptionPane.showMessageDialog(null, "Yo, I'm jeff. I'm gonna try to be smart but be prepared for me to fail miserably. If you would like to stop at any time type 'quit''");
		String response = JOptionPane.showInputDialog(null, "What would you like to say to me?");
		while(!response.equalsIgnoreCase("quit"))
		{
			response = interactwithChatbot(response);
		}
		
	}
	
	public String interactwithChatbot(String text)
	{
		String output = "";
		String input = JOptionPane.showInputDialog(null, "Hi whats up?");
		output = simpleBot.processtext(input);
		return output;
	}
	
	public ChatModel getChatbot()
	{
		return simpleBot;
	}
	
}




