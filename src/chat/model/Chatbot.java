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
		responseList.add("ok");
		responseList.add("No problem");
		responseList.add("Yo");
		responseList.add("Hmm");
		
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
	
	
	//------------------------ Checkers ---------------------------\\
	
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
	
	//public String getCurrentUser()
	//{
	//	String userName = JOptionPane.showInputDialog("What is your name?");
	//	return userName;
	//}
	
	public boolean spookyChecker(String input)
	{
		boolean isSpooky = false;
		
		for(int spookyLocation = 0; spookyLocation <= spookyList.size(); spookyLocation +=1)
		{
			isSpooky = true;
		}
		if(input.contains("Haloween"))
		{
			isSpooky = true;
		}
		else if(input.contains("Easter"))
		{
			isSpooky = false;
		}
		
		return isSpooky;
	}
	
	public String processText(String input)
	{
		input = "";
		input += "You said: ";
		input += "Chatbot says: ";		
		//input = JOptionPane.showInputDialog("I am going to repeat what you say");
		//JOptionPane.showInputDialog("You said: " + input);
		
		
		return input;
	}
	
		
		
	//--------------------------------------------------------------\\
	
	public ArrayList<String> getResponseList()
	{
		return responseList;
	}

	public ArrayList<String> getSpookyList()
	{
		return spookyList;
	}
}