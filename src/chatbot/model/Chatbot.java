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
		fillTheMemeList();
		myUser = new ChatbotUser();
		
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

	public String getContentArea()
	{
		return contentArea;
	}

	public void setContentArea(String userInput)
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
	 * @param input The supplied text.
	 * @return The processed text based on checker or other methods.
	 */
	public String processText(String input)
	{
		String result = "";

		if (getChatCount() < 5)
		{
			result = introduceUser(input);
		}
		else if (input != null && getChatCount() >= 5)
		{
			result = randomChatConversation(input);
		}
		else
		{
			result = "Plz use words";
			chatCount--;
		}
		updateChatCount();
		return result;
	}

	/**
	 * This part asks the user questions that it will store as info about the user.
	 * @param input This is the text that the user enters into the text box.
	 * @return Returns the next question.
	 */
	private String introduceUser(String input)
	{
		String userQuestion = "";

		if (getChatCount() == 0)
		{
			myUser.setUserName(input);
			userQuestion = "Cool name " + myUser.getUserName() + ". How old are you?";
		}
		else if (getChatCount() == 1)
		{
			int userAge = Integer.parseInt(input);
			myUser.setAge(userAge);
			userQuestion = "Dude, you're like way old " + myUser.getUserName() + ". How much do you weigh?";
		}
		else if (getChatCount() == 2)
		{
			double userWeight = Double.parseDouble(input);
			myUser.setWeight(userWeight);
			userQuestion = "Yikes that is almost as much as my car " + myUser.getUserName() + ". Would you happen to have a mustache?";
		}
		else if (getChatCount() == 3)
		{
			boolean userStache = Boolean.parseBoolean(input);
			myUser.setHasMustache(userStache);
			userQuestion = "That's cool. I think mustaches are creepy, " + myUser.getUserName() + ". Do you wear glasses or contacts?";
		}
		else
		{
			boolean userLenses = Boolean.parseBoolean(input);
			myUser.setNeedsGlasses(userLenses);
			// userQuestion = "I love my glasses :D " + myUserName() +
			// " What do you want to discuss??";
		}

		return userQuestion;
	}

	/**
	 * Random conversation asks random questions depending on the random number chosen.
	 * @param input Will check the inputed text and take it into it's parameters.
	 * @return Returns another question.
	 */
	private String randomChatConversation(String input)
	{
		String conversation = "";

		int randomPosition = (int) (Math.random() * 7);
		if (randomPosition == 0)
		{
			if (stringLengthChecker(input))
			{
				conversation = "too long";
			}
			else
			{

				conversation = "What is with you and using short words?";
			}
		}
		else if (randomPosition == 1)
		{
			if (contentChecker(input))
			{
				conversation = "How did you know my secret?";
			}
			else
			{
				conversation = "Try again another time";
			}
		}
		else if (randomPosition == 2)
		{
			if (memeChecker(input))
			{
				conversation = "Cool! " + input + " is on of my favorite memes! Are there any more memes you like?";
			}
			else
			{
				conversation = "I hate to break it to you, but your trend setting skills are not prime. Try again.";

			}
		}
		else if (randomPosition == 3)
		{
			conversation = userTopic(input);

		}
		else if (randomPosition == 4)
		{
			// adding to the list
			userInputList.add(input);
			conversation = "Thank you for the comment";
		}
		else if (randomPosition == 5)
		{
			if(mashChecker(input))
			{
				conversation = mashingDetected(input);
			}
			else
			{
				conversation = noMashingDetected(input);
			}
		}
		else
		{
			if (userInputChecker(input))
			{
				conversation = "That was nice - you removed it from the list";
			}
			else
			{
				conversation = "Thanks for adding this content";
			}

		}
		return conversation;
	}
	/**
	 * Theoretically checks to see if you are just mashing your keyboard.
	 * @param input What it checks for mashing.
	 * @return returns if it is mashed or not.
	 */
	private String mashingDetected(String input)
	{
		String mashed = "";
		
		mashed = input.substring(input.length()/2);
		mashed += input.substring(input.length()/2);		
		return mashed;
	}
	
	/**
	 * If there is no mashing detected, it will thank you for not mashing.
	 * @param input
	 * @return Message for not mashing
	 */
	private String noMashingDetected(String input)
	{
		String noMashing = "Thanks for not mshing you keyboard with";
		if (input.length() > 1)
		{
			noMashing += input.substring(input.length()/3, input.length()/2);
		}
		
		
		
		
		return noMashing;
	}
	/**
	 * Check for keyboard mashing.
	 * @param input The user supplied text
	 * @return True if text is same as in this method.
	 */
	private boolean mashChecker(String input)
	{
		boolean isMashing = false;
		
		if(input.indexOf("ajsdfj") > -1)
		{
			isMashing = true;
		}
		
		return isMashing;
	}
	
	/**
	 * Talks about the topic that the user mentions.
	 * @param userInput What the user enters in the text field for the introduceUser method.
	 * @return Returns an answer including your previous text.
	 */
	private String userTopic(String userInput)
	{
		String userBasedResponse = "";

		int randomUserTopic = (int) (Math.random() * 6);

		switch (randomUserTopic)
		{
			case 1:
				userBasedResponse = myUser.hasMustache() + " is the response to mustaches :D";
				break;
			case 0:
				userBasedResponse = myUser.getUserName() + " is a silly name :P";
				break;
			default:
				userBasedResponse = myUser.getAge() + " is realllly reallllllly old";
				break;
		}

		return userBasedResponse;
	}
	/**
	 * Creates a loop for the questions.
	 * @param userInput
	 * @return If it matches it.
	 */
	private boolean userInputChecker(String userInput)
	{
		boolean matchesInput = false;

		for (int loopCount = 0; loopCount < userInputList.size(); loopCount++)
		{
			if (userInput.equalsIgnoreCase(userInputList.get(loopCount)))
			{
				matchesInput = true;
				userInputList.remove(loopCount);
				loopCount--;
			}
		}

		return matchesInput;
	}

	/**
	 * Checks the length of the input
	 * @param input
	 * @return Returns result of test.
	 */
	private boolean stringLengthChecker(String input)
	{
		boolean isTooShort = false;

		if (input.length() >= 25)
		{
			isTooShort = true;
		}

		return isTooShort;
	}

	/**
	 * If there is input, it will transfer it to chatPane and also update the chatCount.
	 * @param input
	 * @return Returns if it has anything
	 */
	private boolean contentChecker(String input)
	{
		boolean hasContent = false;

		if (input.contains(contentArea))
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
	 * Checks if the input is a meme or not.
	 * @param input
	 * @return True if contains a meme.
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
