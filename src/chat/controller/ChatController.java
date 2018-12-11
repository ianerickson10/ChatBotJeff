package chat.controller;

import javax.swing.JOptionPane;

import chat.model.Chatbot;
import chat.view.ChatFrame;

import java.util.ArrayList;

public class ChatController
{
	private Chatbot simpleBot;
	private ChatFrame appFrame;
	
	public ChatController()
	{
		simpleBot = new Chatbot();
		appFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		
	}
	
	public String interactWithChatbot(String text)
	{
		String output = "";
		output += simpleBot.processText(text);
		return output;
	}
	
	public String useChatbotCheckers(String text)
	{
		String testedValues = "the following checkers passed:";
		if(simpleBot.contentChecker(text))
		{
			testedValues += "\nContent Checker";
		}
		if(simpleBot.spookyChecker(text))
		{
			testedValues += "\nSpookyChecker Happy Halloween";
		}
		if (simpleBot.legitimacyChecker(text))
		{
			testedValues += "\nLegitimacy Checker";
		}
		return testedValues;
	}
	
	public Chatbot getChatbot()
	{
		return simpleBot;
	}
	
}




