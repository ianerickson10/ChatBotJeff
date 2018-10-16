package model;

import java.util.ArrayList;

public class ChatModel
{
	private ArrayList<String> spookyList;
	private ArrayList<String> responseList;
	
	private String content;
	private String joke;
	private String currentUser;
	
	
	public void Chatbot()
	{
		this.joke = "What's the difference between a dirty bus station and a crab with breast implants?";
		
		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();
		
		buildLists();
	}
	
	
	private void buildLists()
	{
		responseList.add("Hi, How can I help you?");
		responseList.add("I don't understand");
		responseList.add("Thank you");
		responseList.add("You're welcome");
		responseList.add("goodbye");
	}
}
