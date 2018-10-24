package chat.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Chatbot
{
	private ArrayList<String> spookyList;
	private ArrayList<String> responseList;
	
	private String content;
	private String joke;
	private String currentUser;
	
	
	public Chatbot()
	{
		this.joke = "What's the difference between a dirty bus station and a crab with breast implants?";
		
		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();
		
		buildLists();
	}
	
	
	private void buildLists()
	{
		responseList.add("Hello");
		responseList.add("Hi, How can I help you?");
		responseList.add("You need to make sence");
		responseList.add("Thank you");
		responseList.add("You're welcome");
		responseList.add("goodbye");
		responseList.add("wut");
		responseList.add("Sounds good!");
		responseList.add("Umm, ok.");
		responseList.add(".?");
		responseList.add("Yeah alright");
		responseList.add("Woah Sick!");
		//responseList.add("")
		//r
		//r
		//r
		
		spookyList.add("Halloween");
		spookyList.add("SKELETON WAR!!!");
		spookyList.add("snoteleks");
		spookyList.add("spoopy");
		spookyList.add("*doot*");
		spookyList.add("It's frickin bats, I love Halloween");
		spookyList.add("witches");
		spookyList.add("Pumpkin");
		spookyList.add("spooky");
		
		
	}
	
	public String processText(String userText)
	{
		String answer = "";
		userText = JOptionPane.showInputDialog("I am going to repeat what you say");
		answer += "You said: " + userText;
		JOptionPane.showInputDialog("You said: " + userText);
		return answer;
	}
	
	public boolean legitimacyChecker(String input)
	{
		boolean isValid = true;
		
		if(input == null)
		{
			isValid = false;
		}
		
		else if (input.length() < 2)
		{
			isValid = false;
		}
		
		else if (input.contains("sdf") || input.contains("hkl"))
		{
			isValid = false;
		}
		
		return isValid;
		
		
		
		
	}
}
