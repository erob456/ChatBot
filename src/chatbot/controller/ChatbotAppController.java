package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotView;

/**
 * Runs the Chatbot Project. Owns the model and associated views.
 * @author Eric Roberts
 * @version 1.2 10/2/14 - cleaned the quit method.
 */
public class ChatbotAppController
{
	private ChatbotView applicationView;
	private Chatbot mySillyChatbot;
	private String startMessage;
	private String quitMessage;
	
	private ChatbotFrame appFrame;
	
	
	public ChatbotAppController()
	{
		applicationView = new ChatbotView(this);
		appFrame = new ChatbotFrame(this);
		mySillyChatbot = new Chatbot("Derp");
		startMessage = "Welcome to the " + mySillyChatbot.getName() + " chatbot.  What is your favorite meme?";
		quitMessage = "Goodbye cruel user :(";
		
	}
	
	public Chatbot getMySillyChatbot()
	{
		return mySillyChatbot;
	}
	
	public void start()
	{
		String result = applicationView.showChatbotDialog(startMessage);
		
		
//		while(!mySillyChatbot.quitChecker(result))
//		{
//			result = mySillyChatbot.processText(result);
//			result = applicationView.showChatbotDialog(result);
//		}
//		
//		quit();
	}
	
	private void quit()
	{
		applicationView.showChatbotMessage(quitMessage);
		System.exit(0);
	}
}
