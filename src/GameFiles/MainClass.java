package GameFiles;

import java.util.*;

/* This is a game about managing your business.
 * Keep you're business running at all costs. */

public class MainClass {
	
	// Main Method
	
	public static void main(String[] args) 
	{
		// Creating Objects
		Scanner console = new Scanner(System.in);
		Player player = new Player();
		Business business = new Business();
		GameManager gameManager = new GameManager();
		
		// Variables
		int menuChoice = 0, endGame = 0;
		
		// Some start up stuff
		gameManager.displayStartMessage();
		
		business.setBankAccount(1000f);
		business.setEmployeeSalary(10);
		System.out.println("Business Bank Account: " + business.getBankAccount());
		System.out.println("Employee Salary: " + business.getEmployeeSalary());
		
		business.payEmployees(10);
		System.out.println("Employee Salary Costs: " + business.getTotalEmployeeSalary());
		System.out.println("Business Bank Account: " + business.getBankAccount());
		
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
				createCharacter(player, business, gameManager, console);
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
				endGame = 99;
				break;
			} // switch
			
			// if the Character is fully created, break out of while loop
			// to continue on to play with character.
			if(gameManager.getIsCharacterCreated() == true)
			{
				endGame = 99;
			} // if
		} // while
		
		// Print player info
		System.out.println("The Player's Info: " + player.displayPlayerInfo());
		
		// if the game is ready to be played cause
		// a new game was made or a game was loaded
		// Do game playing stuff here!
		
		if(gameManager.getIsCharacterCreated() == true)
		{
			System.out.println("\nYAY, your Character is Created!\nYou can now start playing once I actually make the game!!!!");
			//if a new game is created, endGame is set to 0
			//this makes you enter the main game loop
			//if character isn't created, endGame stays 99 and 
			//main game loop is skipped.
			
			endGame = 0;
		} // if
		
		// This is the Main Game Loop where the game runs
		while(endGame != 99)
		{
			System.out.println("\nEntering Main Game Loop\n");
			
			// Game stuff!!
			
			System.out.println("\nExiting Main Game Loop\n");
			endGame=99;
		} // while
		
		
		// Gives a message to user.
		System.out.println("\n\nProgram Ended\n\n");
	} // main()
	
	// Methods
	
	public static void startNewGame()
	{
		// Starting a new Game Stuff
		
	} // startNewGame()
	
	public static void createCharacter(Player player, Business business, GameManager gameManager, Scanner console)
	{
		int menuChoice = 0;
		boolean createStage1, createStage2, createStage3;
		
		gameManager.setIsCharacterCreated(false);
		createStage1 = createStage2 = createStage3 = false;
		
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
				
				createStage1 = true; // to show stage is completed
				break;
			case 2:
				System.out.print("\nEnter Characters traits!\n");
				
				System.out.print("\nEnter Characters First Trait: ");
				player.setTraits(1, console.next());
				
				System.out.print("\nEnter Characters Second Trait: ");
				player.setTraits(2, console.next());
				
				System.out.print("\nEnter Characters Third Trait: ");
				player.setTraits(3, console.next());
				
				System.out.print("\nEnter Characters Fourth Trait: ");
				player.setTraits(4, console.next());
				
				System.out.print("\nEnter Characters Fifth Trait: ");
				player.setTraits(5, console.next());
				
				createStage2 = true; // to show stage is completed
				break;
			case 3:
				int difChoice=0;
				System.out.print("\nChoose Game Difficulty:\n1.) Easy.\n2.) Normal.\n3.) Hard.\n");
				difChoice = console.nextInt();
				
				if(difChoice == 1) // if easy
				{
					gameManager.setGameDifficulty("easy");
					business.setBankAccount(100000f);
				}
				else if (difChoice == 2) // if normal
				{
					gameManager.setGameDifficulty("normal");
					business.setBankAccount(50000);
				}
				else // if hard
				{
					gameManager.setGameDifficulty("hard");
					business.setBankAccount(10000);
				} // if else
				
				createStage3 = true; // to show stage is completed
				break;
			case 4:
				menuChoice=99;
				gameManager.setIsCharacterCreated(false);
				break;
			} // switch
			
			// if the Character is fully created, break out of while loop
			// to continue on to play with character.
			if(createStage1 == true && createStage2 == true && createStage3 == true)
			{
				gameManager.setIsCharacterCreated(true);
				menuChoice = 99;
			} // if
			
		} // while
		
	} // createCharacter()
	

	
	
	

} // Class MainClass
