package chatbot.model;

import java.util.ArrayList;

/**
 * The chatbot model class.  Used for checking and manipulating Strings.
 * @author erob7388
 * @version 1.1 9/26/14
 */
public class Chatbot
{
	private ArrayList<String> memeList;
	private String name;
	private int chatCount;
	
	/**
	 * Creates a ChatBot object with the supplied name and initializes the current number of chats to zero.
	 * @param name The supplied name for the Chatbot.
	 */
	public Chatbot(String name)
	{
		this.name = name;
		chatCount = 0;
	}
	
	/** Processes input for the user against the checker methods.  Returns the next output for the view.
	 * 
	 * @param currentInput The supplied text.
	 * @return The processed text based on checker or other methods.
	 */
	public String processText(String currentInput)
	{
		String result = "";
		
		
		return result;
	}
	
	
	
	/**
	 * Retrieves the name of the Chatbot object.
	 * @return name The set name for the Chatbot.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gives you back the number of chats.
	 * @return chatCount The number of times the chat is used.
	 */
	public int getChatCount()
	{
		return chatCount;
	}
	
	/**
	 * Sets the name that was retrieved in the getName method above.
	 * @param name  Sets the name 
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Updates the number of chats by adding one with the ++ operation.
	 */
	private void updateChatCount()
	{
		chatCount++;
	}
	
	/**
	 * Tells the program to quit only if the text box result = 'sayonara' (Case insensitive)
	 * @param input  If input not equals 'sayonara' then will not quit.
	 * @return  If input = sayonara, then it will quit the program.
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input != null && input.equalsIgnoreCase("sayonara"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}
}
