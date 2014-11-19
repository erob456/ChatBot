package chatbot.model;

import java.util.ArrayList;

import javax.swing.JScrollPane;

/**
 * The chatbot model class. Used for checking and manipulating Strings.
 * 
 * @author erob7388
 * @version 1.2 10/09/14
 */
public class Chatbot
{
	/**
	 * The programmer supplied list of memes.
	 */
	private ArrayList<String> memeList;
	/**
	 * The name of the Chatbot.
	 */
	private String name;
	/**
	 * The programmer specified content area for the contentChecker method.
	 */
	private String contentArea;
	/**
	 * The amount of chats that have occurred, with the exception of blank
	 * entries.
	 */
	private int chatCount;
	/**
	 * The current user of the Chatbot object
	 */
	private ChatbotUser myUser;
	/**
	 * The list of user input for the Chatbot.
	 */
	private ArrayList<String> userInputList;

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
		userInputList = new ArrayList<String>();
		this.name = name;
		contentArea = "";
		chatCount = 0;
		getContentArea();
		fillTheMemeList();

	}

	/**
	 * Retrieves the name of the Chatbot object.
	 * 
	 * @return name The set name for the Chatbot.
	 */
	public String getName()
	{
		return name;
	}

	public ChatbotUser getMyUser()
	{
		return myUser;
	}

	public void setMyUser(ChatbotUser myUser)
	{
		this.myUser = myUser;
	}

	public JScrollPane getContentArea()
	{
		return contentArea;
	}

	public void setContentArea(JScrollPane userInput)
	{
		this.contentArea = userInput;
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

		if (getChatCount() < 5)
		{
			myUser.setUserName(currentInput);
			result = "You have a cool name" + myUser.getUserName() + "So... How old are you?";
		}
		else if (currentInput != null && currentInput.length() > 0)
		{
			result = randomChatConversation(currentInput);
		}
		else
		{
			result = "Plz use words";
			chatCount--;
	}
		updateChatCount();
		return result;
	private String introduceUser(String input)
	{
		if (currentInput.contains("add:"))
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
		return result;

	}
			}

	private String introduceUser(String input)
	{
		String userQuestion = "";

		return userQuestion;
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
