package GameFiles;

/* This is the class that handles the characters details 
 * such as traits, money, etc... */

public class Player extends Person {

	// Variables
	float bankAccount;
	String[] traits = {"", "", "", "", ""}; // string array to store 5 player traits
	
	// Constructors
	public Player()
	{	
	} // default Constructor
	
	public Player(String theName) 
	{
		super(theName);
	}
	
	// Methods
	public void setName(String theName)
	{
		super.setName(theName);
	} // setName()
	
	public String getName()
	{
		return super.getName();
	} // getName()
	
	public String toString()
	{
		return getName();
	} // toString()

}
