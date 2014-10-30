package GameFiles;

/* This is the class that handles the characters details 
 * such as Name, traits, money, etc... */

public class Character {
	
	// Member Variables
	/*==============================================================================================================*/
	String playerName;
	int playerAge;
	float playerMoney;
	String[] playerTraits = {"", "", "", "", ""}; // string array to store 5 player traits
	
	// Constructors
	/*==============================================================================================================*/
	Character()
	{
		setPlayerName("Player");
		playerAge = 25;
		playerMoney = 100000;
	}
	
	// Methods 
	/*==============================================================================================================*/
	public void setPlayerName(String name)
	{
		playerName = name;
	} // setPlayerName()
	
	public String getPlayerName()
	{
		return playerName;
	} // getPlayerName()

} // Class Character
