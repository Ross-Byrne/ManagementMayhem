package GameFiles;

/* This class is to manage the game
 * this includes the menus, certain variables, etc*/

public class GameManager {
	
	public String gameDifficulty = "Normal";
	public boolean isCharacterCreated=false;
	
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
	
	// Other Methods
	
	public void displayStartMessage()
	{
		System.out.println("Welcome to Management Mayhem!\n"
				+ "As the sole owner and manager of your business,\n"
				+ "it is your duty to keep it running at all costs.\n");
	} // displayStartMessage()
	
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
		System.out.println("\nAll Fields Must Be Complete!\n");
		System.out.println("\n1.) Name Your Character.");
		System.out.println("\n2.) Select 5 Character Traits.");
		System.out.println("\n3.) Choose Game Difficulty.");	
		System.out.println("\n4.) Back To Main Menu.");
	} // printCharacterCreateMenu()
	
	
	

} // Class GameManager
