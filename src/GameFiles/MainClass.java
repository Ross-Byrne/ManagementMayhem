// Ross Byrne 2014
// Second Year Java Project

package gamefiles;

import java.util.Scanner;
import java.io.*;

/* This is a game about managing your business.
 * Keep you're business running at all costs. */

public class MainClass {
	
	// Main Method
	
	public static void main(String[] args) throws IOException
	{
		// Creating Objects
		Scanner console = new Scanner(System.in);
		GameShell gameShell = new GameShell();
		SaveGameManager saveGameManager = new SaveGameManager();
		GameManager gameManager = new GameManager();
		MenuManager menuManager = new MenuManager();
		Player player = new Player();
		Business business = new Business();
		
		// Checks if the save file exists, creates it if it doesn't
		File gameSave = new File("SavedGame.txt");
		if(!gameSave.exists()) {
			gameSave.createNewFile();
		} 
		
		// Variables
		int menuChoice = 0, endGame = 0;
		
		System.out.printf("\t\t\t=======================================================");
		System.out.printf("\n\t\t\t============ Welcome To Management Mayhem! ============");
		System.out.printf("\n\t\t\t=======================================================\n");
		
		while(endGame != 99)
		{
			menuManager.printMainMenu(); // to print main menu
			
			// to make sure the choice entered is in the right range
			do
			{
				System.out.print("\nPlease Enter your Choice: ");
			
				while(!console.hasNextInt()) 
				{
					System.out.print("\nPlease Enter your Choice: ");
					console.next(); // to advance Scanner past input
				} // while
				
				menuChoice = console.nextInt();
			}while(menuChoice < 1 || menuChoice > 4); // do..while
			
			switch(menuChoice)
			{
			case 1:
				// Start New Game
				System.out.println("Starting new Game!");
				
				gameShell.startNewGame(player, business, gameManager, menuManager);
				break;
			case 2:
				// Load Game
				saveGameManager.loadGame(player, business, gameManager);
				
				// if a game is loaded successfully, break out of loop to enter game loop
				if(gameManager.getIsGameLoaded() == true)
				{
					endGame = 99;
				}
				break;
			case 3:
				// About Game
				menuManager.printGameInfo();
				break;
			case 4:
				// Exit
				endGame = 99;
				break;
			} // switch
			
			// If a New Game has been created, break out of while loop
			// to continue on to play.
			if(gameManager.getIsNewGameCreated() == true)
			{
				// Setting up default number of employees to 3
				business.hireEmployees(gameManager, 3);
				
				endGame = 99;
			} // if
		} // while
		
		// If the game is ready to be played because
		// a New Game was made or a Game Was Loaded,
		// endGame is set to 0.
		// This makes you enter the Main Game Loop.
		// If the game isn't ready to be played, endGame stays 99 
		// and the Main Game Loop is Skipped.
		if(gameManager.getIsNewGameCreated() == true || 
				gameManager.getIsGameLoaded() == true) 	// if new game is created or a game is loaded
		{	
			// Print Game info
			System.out.println("\nPlayer Info: \n" + player.displayPlayerInfo());
			System.out.println("\nBusiness Info: \n" + business.displayBusinessInfo());
			System.out.printf("Number Of Employees: %d", business.employees.size());
			System.out.println("\n\nGame Info: \n\nGame Difficulty: " + gameManager.getGameDifficulty());
			endGame = 0;
		} // if
		
		// This is the Main Game Loop where the game runs
		while(endGame != 99) // type 5 to exit
		{
			menuManager.printMainGameMenu();			
			
			// to make sure the choice entered is in the right range
			do
			{
				System.out.print("\nPlease Enter your Choice: ");
			
				while(!console.hasNextInt()) 
				{
					System.out.print("\nPlease Enter your Choice: ");
					console.next(); // to advance Scanner past input
				} // while
				
				menuChoice = console.nextInt();
			}while(menuChoice < 1 || menuChoice > 4); // do..while
			
			switch(menuChoice)
			{
			case 1:
				// Play the Game
				System.out.println("Game Is Starting!");
				
				gameShell.playGame(player, business, gameManager, menuManager);
				break;
			case 2:
				// Save Game
				saveGameManager.saveGame(player, business, gameManager);
				break;
			case 3:
				// Load a Game
				saveGameManager.loadGame(player, business, gameManager);
				break;
			case 4:
				// Exit
				menuManager.printQuitGameMenu();
				
				// to make sure the choice entered is in the right range
				do
				{
					System.out.print("\nPlease Enter your Choice: ");
				
					while(!console.hasNextInt()) 
					{
						System.out.print("\nPlease Enter your Choice: ");
						console.next(); // to advance Scanner past input
					} // while
					
					menuChoice = console.nextInt();
				}while(menuChoice < 1 || menuChoice > 2); // do..while
			
				if(menuChoice == 1)
				{
					System.out.println("Exiting Game");
					endGame = 99; // breaks out of Main Game Loop
				}
				break;
			} // switch
			
		} // while
		
		// Gives a message to user.
		System.out.println("\n\nGame Ended.\n\n");
		console.close();
	} // main()
	
} // Class
