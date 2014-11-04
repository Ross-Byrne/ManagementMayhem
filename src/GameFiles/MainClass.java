package GameFiles;

import java.util.*;

/* This is a game about managing your business.
 * Keep you're business running at all costs. */

public class MainClass {
	
	public static void main(String[] args) 
	{
		// Creating Objects
		Scanner console = new Scanner(System.in);
		Player player = new Player();
		GameManager gameManager = new GameManager();
		
		// Variables
		int menuChoice = 0, endGame = 0;
		
		// Some start up stuff
		gameManager.displayStartMessage();
		
		while(endGame != 99) //type 5 to exit
		{
			gameManager.printMainMenu(); // to print main menu
			
			System.out.print("\nPlease Enter your Choice: ");
			menuChoice = console.nextInt();
			
			switch(menuChoice)
			{
			case 1:
				// Start New Game
				System.out.println("\nStarting new Game!\n");
				createCharacter(player, gameManager, console);
				break;
			case 2:
				// Load Game
				System.out.println("Loading Game!");
				break;
			case 3:
				// Delete Game Save
				System.out.println("Deleting Saved Game!");
				break;
			case 4:
				// About Game
				System.out.println("Stuff about the Game!");
				break;
			case 5:
				// Exit
				System.out.println("Exiting Game!");
				endGame = 99;
				break;
			} // switch
			
			
		} // while
		
		// For then the program ends - closes console
		// and gives a message to user.
		console.close();
		System.out.println("\n\nProgram Ended\n\n");
	} // main()
	
	public static void startNewGame()
	{
		// Starting a new Game Stuff
		
	} // startNewGame()
	
	public static void createCharacter(Player player, GameManager gameManager, Scanner console)
	{
		int menuChoice=0;
		
		while(menuChoice != 99)
		{
			gameManager.printCharacterCreateMenu();
			
			System.out.print("\nEnter Option Choice: ");
			menuChoice = console.nextInt();
			
			switch(menuChoice)
			{
			case 1:
				console.nextLine(); // flush the buffer
				System.out.print("\nPlease Enter your new Character's Name: ");
				player.setName(console.nextLine());
				
				System.out.println("\nYour Character's Name is "+player.getName()+".");
				break;
			case 2:
				System.out.print("\nSelect Characters traits!\n");
				break;
			case 3:
				System.out.print("\nChoose Game Difficulty!\n");
				break;
			case 4:
				menuChoice=99;
				break;
			} // switch
			
		} // while
		
	} // createCharacter()
	

	
	
	

} // Class MainClass
