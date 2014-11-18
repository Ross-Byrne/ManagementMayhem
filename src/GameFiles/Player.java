package gamefiles;

/* This is the class that handles the characters details */

public class Player extends Person implements Embezzle {

	// Variables
	float bankAccount;
	String[] traits = {"", "", "", "", ""}; // string array to store 5 player traits
	
	// Constructors
	public Player()
	{	
	} // default Constructor
	
	public Player(String theName) 
	{
		setName(theName);
	}
	
	// Get Set Methods
	public void setName(String theName)
	{
		name = theName;
	} // setName()
	
	public String getName()
	{
		return name;
	} // getName()
	
	public void setBankAccount(float theAccount)
	{
		bankAccount = theAccount;
	} // setBankAccount()
	
	public float getBankAccount()
	{
		return bankAccount;
	}
	
	public void setTraits(int index, String trait)
	{
		traits[index] = trait;
	} // setTraits()
	
	// getTraits() is overloaded
	public String getTraits(int index)
	{
		String trait="";
		
		trait = traits[index];
	
		return trait;
	} // getTraits()
	
	// if no number is entered, all traits are returned
	public String getTraits()
	{
		String tempTraits="";
		int i=0;
		
		for(i=0; i<5; ++i)
			tempTraits += traits[i] + "\n\t";
		
		return tempTraits;
	} // getTraits()
	
	// Other Methods
	
	// this is from Embezzle Interface
	public void embezzleGrant(float amount)
	{
		// adds the amount of money the player wants to embezzle to their account
		setBankAccount(getBankAccount() + amount);
	} // embezzleGrant()
	
	public String displayPlayerInfo()
	{
		String str="";
		
		str += "\nName: " + getName() +
				"\nPersonal Bank Account: €" + getBankAccount() +
				"\nTraits: " + getTraits();
		
		return str;
	} // displayePlayerInfo()

} // Class
