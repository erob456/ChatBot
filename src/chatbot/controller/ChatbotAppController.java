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

	/**
	 * Creates the start and quit messages.
	 */
	public ChatbotAppController()
	{
		applicationView = new ChatbotView(this);
		appFrame = new ChatbotFrame(this);
		mySillyChatbot = new Chatbot("Theoretic");
		startMessage = "Welcome to the " + mySillyChatbot.getName() + " chatbot. What is your name?";
		quitMessage = "Goodbye cruel user :(";

	}

	/**
	 * This gives access to the name of the Chatbot.
	 * @return The name of the chatbot
	 */
	public Chatbot getMySillyChatbot()
	{
		return mySillyChatbot;
	}

	/**
	 * Starts the chatbot with an opening message.
	 */
	public void start()
	{
		((ChatbotPanel) appFrame.getContentPane()).showTextMessage(startMessage);

		// ChatbotPanel testPanel = (ChatbotPanel) appFrame.getContentPane();
		// testPanel.showTextMessage(startMessage);
	}

	/**
	 * Reads all input and checks if it equals the quit message. If so, quits.
	 * @param input  Typed into input area
	 * @return What the test result is.
	 */
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

	/** 
	 * The actual quit method.
	 */
	private void quit()
	{
		applicationView.showChatbotMessage(quitMessage);
		System.exit(0);
	}
}
