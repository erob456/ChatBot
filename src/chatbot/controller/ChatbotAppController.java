package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotPanel;
import chatbot.view.ChatbotView;

/**
 * Runs the Chatbot Project. Owns the model and associated views.
 * 
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
		((ChatbotPanel) appFrame.getContentPane()).showTextMessage(startMessage);

		// ChatbotPanel testPanel = (ChatbotPanel) appFrame.getContentPane();
		// testPanel.showTextMessage(startMessage);
	}

	public String getChatbotDialog(String input)
	{
		String result = "";

		if (mySillyChatbot.quitChecker(input))
		{
			quit();
		}

		result = mySillyChatbot.processText(input);

		return result;
	}

	private void quit()
	{
		applicationView.showChatbotMessage(quitMessage);
		System.exit(0);
	}
}
