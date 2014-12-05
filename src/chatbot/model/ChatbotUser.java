package chatbot.model;

public class ChatbotUser
{
	// four data members
	// at least two different types (String, int, booean, double....)
	private String userName;
	private int age;
	private boolean needsGlasses;
	private boolean hasMustache;
	
	/**
	 * Generates info about the user, until otherwise specified.
	 */
	public ChatbotUser()
	{
		this.userName = "";
		this.age = -999;
		this.needsGlasses = false;
		this.hasMustache = false;
	}
	
	/**
	 * Retrieves the username provided in introduceUser.
	 * @return The username is returned.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Gets the age from introduceUser.
	 */
	public int getAge()
	{
		return age;
	}
	
	/**
	 * Checks if the user needs glasses.
	 * @return Returns the boolean true or false for it.
	 */
	public boolean needsGlasses()
	{
		return needsGlasses;
	}
	
	/**
	 * Checks if the user has a mustache.
	 * @return Returns the boolean if there is a mustache or not.
	 */
	public boolean hasMustache()
	{
		return hasMustache;
	}
	
	/**
	 * Gets the user weight and returns it to the introduceUser.
	 * @param userWeight Gets the input of user weight.
	 * @return Returns weight.
	 */
	public double setWeight(double userWeight)
	{
		return userWeight;
	}
	
	/**
	 * Sets the username from the input during that question.
	 * @param userName  The input text from the textArea
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	/**
	 * Sets the age from the input during the question.
	 * @param age  The age as specified by the user.
	 */
	public void setAge(int age)
	{
		this.age = age;
	}
	
	/**
	 * Sets the boolean if the user needs glasses.
	 * @param needsGlasses The true or false as specified by the user.
	 */
	public void setNeedsGlasses(boolean needsGlasses)
	{
		this.needsGlasses = needsGlasses;
	}
	
	/**
	 * Sets the boolean if the user has a mustache
	 * @param hasMustache  The yes or no specified by the user.
	 */
	public void setHasMustache(boolean hasMustache)
	{
		this.hasMustache = hasMustache;
	}
	
	
}
