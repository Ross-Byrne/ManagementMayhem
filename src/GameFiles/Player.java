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
	
	public void setbankAccount(float theAccount)
	{
		bankAccount = theAccount;
	} // setBankAccount()
	
	public float getBankAccount()
	{
		return bankAccount;
	}
	
	public void setTraits(int index, String trait)
	{
		// user enters trait number (1 - 5), -1 to convert it to 0 indexing
		traits[index - 1] = trait;
	} // setTraits()
	
	// getTraits() is overloaded
	// if a number is entered, that number trait is returned
	public String getTraits(int index)
	{
		String trait="";
		
		if (index > 0 || index < 5)
			trait = traits[index - 1];
		else
			System.out.println("Error - traits are 1 - 5");
	
		return trait;
	} // getTraits()
	
	// if no number is entered, all traits are returned
	public String getTraits()
	{
		String tempTraits="";
		int i=0;
		
		for(i=0; i<5; ++i)
			tempTraits += traits[i] + "\n";
		
		return tempTraits;
	} // getTraits()
	
	// toString Method
	public String toString()
	{
		String str;
		
		str = getName();
		
		return str;
	} // toString()

} // Class Person
