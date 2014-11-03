package GameFiles;

/* This class is to manage the game
 * this includes the menus, etc*/

public class GameManager {
	
	// Methods
	public void displayStartMessage()
	{
		System.out.println("Welcome to Management Mayhem!\n"
				+ "As the sole owner and manager of your business,\n"
				+ "it is your duty to keep it running at all costs.\n");
	} // displayStartMessage()
	
	public void printMainMenu()
	{
		System.out.println("\n1.) Start New Game.");
		System.out.println("2.) Load Game.");
		System.out.println("3.) Delete Game Save.");
		System.out.println("4.) About Game.");
		System.out.println("5.) Exit.\n");
	} // printMainMenu()
	
	
	
	

} // Class GameManager
