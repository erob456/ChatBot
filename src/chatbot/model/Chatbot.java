package chatbot.model;

import java.util.ArrayList;

/**
 * The chatbot model class. Used for checking and manipulating Strings.
 * 
 * @author erob7388
 * @version 1.2 10/09/14
 */
public class Chatbot
{
	private ArrayList<String> memeList;
	private ArrayList<String> stringList;
	private String name;
	private int chatCount;
	myUser = new ChatbotUser();

	/**
	 * Creates a ChatBot object with the supplied name and initializes the
	 * current number of chats to zero.
	 * 
	 * @param name
	 *            The supplied name for the Chatbot.
	 */
	public Chatbot(String name)
	{
		memeList = new ArrayList<String>();

		this.name = name;
		chatCount = 0;
		contentArea = "";
		fillTheMemeList();
		
		
	}

	public ChatbotUser getMyUser();
	{
		return myUser;
	}
	
	public void setMyUser(ChatbotUser)
	/**
	 * Retrieves the name of the Chatbot object.
	 * 
	 * @return name The set name for the Chatbot.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Gives you back the number of chats.
	 * 
	 * @return chatCount The number of times the chat is used.
	 */
	public int getChatCount()
	{
		return chatCount;
	}

	/**
	 * Sets the name that was retrieved in the getName method above.
	 * 
	 * @param name
	 *            Sets the name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Helper method to fill the list of memes.
	 */
	private void fillTheMemeList()
	{
		memeList.add("kitties");
		memeList.add("doge");
		memeList.add("one does not simply");
		memeList.add("troll face");
		memeList.add("y u no");
		memeList.add("grumpy cat");
	}

	/**
	 * Processes input for the user against the checker methods. Returns the
	 * next output for the view.
	 * 
	 * @param currentInput
	 *            The supplied text.
	 * @return The processed text based on checker or other methods.
	 */
	public String processText(String currentInput)
	{
		String result = "";

		if(getChatCount() < 7)
		{
			
		}
		int randomPosition = (int) (Math.random() * 4);
		if (currentInput != null && currentInput.length() > 0)
		{
			if(currentInput.contains("add:"))
			{
				memeList.add(currentInput.substring(5));
			}
			if (randomPosition == 0)
			{
				if (stringLengthChecker(currentInput))
				{
					result = "too long";
				}
				else
				{
					memeList.add(currentInput);
					result = "What is with you and using short words?";
				}
			}
			else if (randomPosition == 1)
			{
				if (contentChecker(currentInput))
				{
					result = "yup, you know the secret";
				}
				else
				{
					result = "try again another time";
				}
			}
			else if (randomPosition == 2)
			{
				if (memeChecker(currentInput))
				{
					result = "Cool! " + currentInput + " is on of my favorite memes! Are there any more memes you like?";
				}
				else
				{
					result = "I hate to break it to you, but your trend setting skills are not prime. Try again.";
					
				}
			}
			else
			{
				//
			}
		}
		else
		{
			result = "I'm sorry my presence makes you speechless";
		}
		updateChatCount();
		return result;
	}
	
	

	private boolean stringLengthChecker(String input)
	{
		boolean isTooShort = false;

		if (input.length() >= 25)
		{
			isTooShort = true;
		}
		
		return isTooShort;
	}
	
	private boolean contentChecker(String input)
	{
		boolean hasContent = false;
			
		if (input.contains("computers"))
		{
			hasContent = true;
			
		}
		
		return hasContent;
	}

	/**
	 * Updates the number of chats by adding one with the ++ operation.
	 */
	private void updateChatCount()
	{
		chatCount++;
	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	private boolean memeChecker(String input)
	{
		boolean isAMeme = false;

		for (String currentMeme : memeList)
		{
			if (input.equalsIgnoreCase(currentMeme))
			{
				isAMeme = true;
			}
		}

		for (int loopCounter = 0; loopCounter < memeList.size(); loopCounter++)
		{
			if (input.equalsIgnoreCase(memeList.get(loopCounter)))
			{
				isAMeme = true;
			}
		}

		return isAMeme;
	}

	/**
	 * Tells the program to quit only if the text box result = 'sayonara' (Case
	 * insensitive)
	 * 
	 * @param input
	 *            If input not equals 'sayonara' then will not quit.
	 * @return If input = sayonara, then it will quit the program.
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;

		if (input != null && input.equalsIgnoreCase("sayonara"))
		{
			okToQuit = true;
		}

		return okToQuit;
	}
}
