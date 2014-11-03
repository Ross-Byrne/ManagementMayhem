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
		gameManager.printMainMenu();
		
		while(endGame != 99) //type 5 to exit
		{
			System.out.print("\nPlease Enter your Choice: ");
			menuChoice = console.nextInt();
			
			switch(menuChoice)
			{
			case 1:
				// Start New Game
				System.out.println("Starting new Game!");
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
		
		// closes console
		console.close();
		System.out.println("\n\nProgram Ended\n\n");
	} // main()
	
	
	

} // Class MainClass
