package GameFiles;

/* This class is to manage the game */

public class GameManager {
	
	public String gameDifficulty;
	public boolean isCharacterCreated = false;
	public boolean isBusinessSetup = false;
	public boolean isNewGameCreated = false;
	public boolean isGameLoaded = false;
	public String[] playerTraitsSelection = { 	"Cheerful", "People Person", "Marketing Master", "Organiser", "Opertunist", "Charming",
												"Greedy", "Spitful", "Alcoholic", "Risk Taker", "Seedy", "Handy Man"};
	
	public String[] randomFName = {		"John", "Mike", "Carl", "Jim", "Conor", "Bob", "Tom",
												"Rachael", "Samantha", "Mary", "Ciara", "Jennifer", "Jane", "Sarah"};
	
	public String[] randomLName = {		" Power", " Sullivan", " Smith", " McCarthy", " White", " Rodrigue", " Jones",
												" Browne", " Butler", " Byrne", " Daly", " Kelly", " Harrington", " Jameson"};
	
	// Get and Set Methods
	
	public void setGameDifficulty(String theDif)
	{
		gameDifficulty = theDif;
	} // setGameDifficulty
	
	public String getGameDifficulty()
	{
		return gameDifficulty;
	} // getGameDifficulty
	
	public void setIsCharacterCreated(boolean isItCreated)
	{
		isCharacterCreated = isItCreated;
	} // setIsCharacterCreated()
	
	public boolean getIsCharacterCreated()
	{
		return isCharacterCreated;
	} // getIsCharacterCreated()
	
	public void setIsBusinessSetup(boolean isItSetup)
	{
		isBusinessSetup = isItSetup;
	} // setIsBusinessSetup()
	
	public boolean getIsBusinessSetup()
	{
		return isBusinessSetup;
	} // getIsBusinessSetup()
	
	public void setIsNewGameCreated(boolean isItCreated)
	{
		isNewGameCreated = isItCreated;
	} // setIsNewGameCreated()
	
	public boolean getIsNewGameCreated()
	{
		return isNewGameCreated;
	} // getIsNewGameCreated()
	
	public void setIsGameLoaded(boolean isItLoaded)
	{
		isGameLoaded = isItLoaded;
	} // setIsGameLoaded()
	
	public boolean getIsGameLoaded()
	{
		return isGameLoaded;
	} // getIsGameLoaded()
	
	public String getPlayerTraitsSelection(int index)
	{	
		return playerTraitsSelection[index];
	} // getPlayerTraitsSelection()
	
	public String getRandomFName(int index)
	{	
		return randomFName[index];
	} // getRandomFName()
	
	public String getRandomLName(int index)
	{	
		return randomLName[index];
	} // getRandomLName()
	
	// Other Methods
	
	
} // Class GameManager
