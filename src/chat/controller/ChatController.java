package chat.controller;

import javax.swing.JOptionPane;

import chat.model.Chatbot;

import java.util.ArrayList;


public class ChatController
{
	Chatbot simpleBot  = new Chatbot();
	
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
		String input = JOptionPane.showInputDialog(null, "Hi whats up?");
		String output = simpleBot.processText(input);
		return output;
	}
	
	public Chatbot getChatbot()
	{
		return simpleBot;
	}
	
}




