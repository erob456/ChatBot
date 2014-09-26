package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotView;

public class ChatbotAppController
{
	private ChatbotView applicationView;
	private Chatbot mySillyChatbot;
	
	
	public ChatbotAppController()
	{
		applicationView = new ChatbotView(this);
		mySillyChatbot = new Chatbot("Derp");
		
	}
	
	public void start()
	{
		String result = applicationView.showChatbot("Eric");
		
		if(result.equalsIgnoreCase("yes"))		
		{
			quit();
		}
	}
	
	private void quit()
	{
		JOptionPane.showMessageDialog(null, "Good Bye Cruel World!!");
		System.exit(0);
	}
}
