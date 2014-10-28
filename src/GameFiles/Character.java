package GameFiles;

/* This is the class that handles the characters details 
 * such as Name, traits, money, etc... */

public class Character {
	
	String playerName;
	int playerAge;
	float playerMoney;
	String[] playerTraits = {"", "", "", "", ""}; // string array to store 5 player traits
	
	Character()
	{
		playerName = "Player";
		playerAge = 25;
		playerMoney = 100000;
	}

} // Class Character
