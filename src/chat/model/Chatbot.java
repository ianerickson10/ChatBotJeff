package chat.model;

import java.util.ArrayList;

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
		responseList.add("hello");
		responseList.add("Hi, How can I help you?");
		responseList.add("You need to make sence");
		responseList.add("Thank you");
		responseList.add("You're welcome");
		responseList.add("goodbye");
		responseList.add("wut");
		r
		r
		r
		r
		r
		r
		r
		r
		r
		
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
		
		answer += "You said: " = userText;
		
		return answer;
	}
	
}
