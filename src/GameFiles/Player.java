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
	
	public void setPlayerTraits(int index, String trait)
	{
		// user enters trait number (1 - 5), -1 to convert it to 0 indexing
		traits[index - 1] = trait;
	} // setPlayerTraits()
	
	public String getPlayerTraits(int index)
	{
		String trait="";
		
		if (index > 0 || index < 5)
			trait = traits[index - 1];
			else
				for(int i=0; i<5; ++i)
					trait += traits[i] + "\n";
		
		return trait;
	} // getPlayerTraits()
	
	// toString Method
	public String toString()
	{
		String str;
		
		str = getName();
		
		return str;
	} // toString()

} // Class Person
