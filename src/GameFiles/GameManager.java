package GameFiles;

/* This class is to manage the game
 * this includes the menus, certain variables, etc*/

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
	
	public void printGameInfo()
	{
		System.out.println("\nWelcome to Management Mayhem!\n"
				+ "As the sole owner and manager of your business,\n"
				+ "it is your duty to keep it running at all costs.\n");
	} // printGameInfo()
	
	public void printMainMenu()
	{
		System.out.println("\n\t\t\tMain Menu\n");
		System.out.println("\t\t\t1.) Start New Game.");
		System.out.println("\t\t\t2.) Load Game.");
		System.out.println("\t\t\t3.) Delete Game Save.");
		System.out.println("\t\t\t4.) About Game.");
		System.out.println("\t\t\t5.) Exit.\n");
	} // printMainMenu()
	
	public void printCharacterCreateMenu()
	{
		System.out.println("\nBoth Fields Must Be Complete!");
		System.out.println("\n1.) Name Your Character.");
		System.out.println("\n2.) Select 5 Character Traits.");	
		System.out.println("\n3.) Back To Main Menu.");
	} // printCharacterCreateMenu()
	
	public void printBusinessSetupMenu()
	{
		System.out.println("\nAll Fields Must Be Complete!");
		System.out.println("\n1.) Name Your Business.");	
		System.out.println("\n2.) Back To Main Menu.");
	} // printBusinessSetupMenu()
	
	public void printMainGameMenu()
	{
		System.out.println("\n\t\t\tMain Game Menu\n");
		System.out.println("\t\t\t1.) Play Game.");
		System.out.println("\t\t\t2.) Save Game");
		System.out.println("\t\t\t3.) Load Game.");
		System.out.println("\t\t\t4.) Delete Game.");
		System.out.println("\t\t\t5.) Exit Game.\n");
	} // printMainGameMenu()
	
	public void printGameOptionsMenu()
	{
		System.out.println("\n\t\t\tOptions\n");
		System.out.println("\t\t\t1.) Keep Playing.");
		System.out.println("\t\t\t2.) Show Player Status.");
		System.out.println("\t\t\t3.) Show Business Status.");
		System.out.println("\t\t\t4.) Manage The Business.");
		System.out.println("\t\t\t5.) Back To Main Game Menu.\n");
	} // printGameMenu()

} // Class GameManager
