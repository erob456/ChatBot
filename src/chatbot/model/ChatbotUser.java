package chatbot.model;

public class ChatbotUser
{
	// four data members
	// at least two different types (String, int, booean, double....)
	private String userName;
	private int age;
	private boolean needsGlasses;
	private boolean hasMustache;
	
	public ChatbotUser()
	{
		this.userName = "";
		this.age = -999;
		this.needsGlasses = false;
		this.hasMustache = false;
	}
	
	public String getUserName()
	{
		return userName;
	}
	public int getAge()
	{
		return age;
	}
	public boolean needsGlasses()
	{
		return needsGlasses;
	}
	public boolean hasMustache()
	{
		return hasMustache;
	}
	public double setWeight(double userWeight)
	{
		return userWeight;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public void setNeedsGlasses(boolean needsGlasses)
	{
		this.needsGlasses = needsGlasses;
	}
	public void setHasMustache(boolean hasMustache)
	{
		this.hasMustache = hasMustache;
	}
	
	
}
