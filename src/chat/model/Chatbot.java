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
		this.content = "hi";
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
	
	public boolean legitimacyChecker(String text)
	{
		boolean isValid = false;
		
		if(text!= null && text.length() > 1)
		{
			isValid = true;
		}
		return isValid;
	}
	
	public String getCurrentUser()
	{
		String userName = JOptionPane.showInputDialog(null, "What is your name?");
		return userName;
	}
	
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
	
	public String processText(String userText)
	{
		String answer = "";
		
		if(!legitimacyChecker(userText))
		{
			answer += "You really sould not send null\n";
		}
		else
		{
			answer += "You: " + userText + "\n";
			
			if(contentChecker(userText))
			{
				answer += "\n";
			}
			int randomIndex = (int) (responseList.size() * Math.random());
			answer += "Chatbot: " + responseList.get(randomIndex) + "\n";
			answer += "\n";
			
		}
		return answer;
	}
	
	public boolean contentChecker(String content)
	{
		boolean truth = true;
		if(content.equals("text" + getContent() + "text"))
		{
			truth = false;
		}
		else if(content.equals("text" + getContent()))
		{
			truth = false;
		}
		else if(content.equals(getContent() + "text"))
		{
			truth = false;
		}
		else if(content.equals(getContent()))
		{
			truth = true;
			JOptionPane.showMessageDialog(null, "You said the special words");
		}
		
		return truth;
	}
		
	//--------------------------- Get ------------------------------\\
	
	public String getContent()
	{
		return content;
	}
	
	public ArrayList<String> getResponseList()
	{
		return responseList;
	}

	public ArrayList<String> getSpookyList()
	{
		return spookyList;
	}
	
	//public Chatbot getChatbot()
	//{
	//	return Chatbot;
	//}
}