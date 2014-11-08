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
		GameManager gameManager = new GameManager();
		Player player = new Player();
		Business business = new Business();
		List<Employee> employees = new ArrayList<Employee>();
		
		// Variables
		int menuChoice = 0, endGame = 0;
		
		System.out.println("\t\tWelcome To Management Mayhem!");
		
		while(endGame != 99) //type 5 to exit
		{
			gameManager.printMainMenu(); // to print main menu
			
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
			}while(menuChoice < 1 || menuChoice > 5); // do..while
			
			switch(menuChoice)
			{
			case 1:
				// Start New Game
				System.out.println("Starting new Game!");
				
				startNewGame(player, business, gameManager, console);
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
				gameManager.printGameInfo();
				break;
			case 5:
				// Exit
				endGame = 99;
				break;
			} // switch
			
			// If a New Game has been created, break out of while loop
			// to continue on to play.
			if(gameManager.getIsNewGameCreated() == true)
			{
				endGame = 99;
			} // if
		} // while
		
		// Print player info
		System.out.println("\nThe Player's Info: " + player.displayPlayerInfo());
		System.out.println("\nBusiness Info: " + "\nBusiness Name: " + business.getName());
		System.out.println("\nBusiness Bank Account: " + business.getBankAccount());
		
		// If the game is ready to be played because
		// a New Game was made or a Game Was Loaded,
		// endGame is set to 0.
		// This makes you enter the Main Game Loop.
		// If the game isn't ready to be played, endGame stays 99 
		// and the Main Game Loop is Skipped.
		if(gameManager.getIsNewGameCreated() == true)
		{
			endGame = 0;
		} // if
		
		// This is the Main Game Loop where the game runs
		while(endGame != 99)
		{
			System.out.println("\nEntering Main Game Loop\n");
			
			// Game stuff!!
			
			// hire 10 employees
			hireEmployees(employees, 10);
			
			System.out.println(employees.size());
			
			System.out.println("\nExiting Main Game Loop\n");
			endGame=99;
		} // while
		
		
		// Gives a message to user.
		System.out.println("\n\nProgram Ended\n\n");
	} // main()
	
	// Methods
	
	public static void startNewGame(Player player, Business business, GameManager gameManager, Scanner console)
	{
		// Starting a new Game Stuff
		// Creating A Character
		createCharacter(player, business, gameManager, console);
		
		// Setup Business if character is created
		if(gameManager.getIsCharacterCreated() == true)
		{
			setUpBusiness(player, business, gameManager, console);
		}
		
		// If the business has been setup, Set Game Difficulty
		if(gameManager.getIsBusinessSetup() == true)
		{
			setGameDifficulty(business, gameManager, console);
		}
		
	} // startNewGame()
	
	public static void createCharacter(Player player, Business business, GameManager gameManager, Scanner console)
	{
		int menuChoice = 0;
		boolean createStage1, createStage2;
		
		gameManager.setIsCharacterCreated(false);
		createStage1 = createStage2 = false;
		
		while(menuChoice != 99)
		{
			gameManager.printCharacterCreateMenu();
			
			// to make sure the choice entered is in the right range
			do
			{
				System.out.print("\nEnter Option Choice: ");
			
				while(!console.hasNextInt()) 
				{
					System.out.print("\nEnter Option Choice: ");
					console.next(); // to advance Scanner past input
				} // while
				
				menuChoice = console.nextInt();
			}while(menuChoice < 1 || menuChoice > 3); // do..while
			
			switch(menuChoice)
			{
			case 1:
				console.nextLine(); // flush the buffer
				System.out.print("\nPlease Enter your new Character's Name: ");
				player.setName(console.nextLine());
				
				System.out.println("\nYour Character's Name is: "+player.getName()+".");
				
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
				menuChoice=99;
				gameManager.setIsCharacterCreated(false);
				break;
			} // switch
			
			// if the Character is fully created, break out of while loop
			// to continue on to setup the business.
			if(createStage1 == true && createStage2 == true)
			{
				gameManager.setIsCharacterCreated(true);
				menuChoice = 99;
			} // if
			
		} // while
		
	} // createCharacter()
	
	public static void setUpBusiness(Player player, Business business, GameManager gameManager, Scanner console)
	{
		int menuChoice = 0;
		boolean createStage1 = false;
		
		gameManager.setIsBusinessSetup(false);
				
		while(menuChoice != 99)
		{
			gameManager.printBusinessSetupMenu();
			
			// to make sure the choice entered is in the right range
			do
			{
				System.out.print("\nEnter Option Choice: ");
			
				while(!console.hasNextInt()) 
				{
					System.out.print("\nEnter Option Choice: ");
					console.next(); // to advance Scanner past input
				} // while
				
				menuChoice = console.nextInt();
			}while(menuChoice < 1 || menuChoice > 2); // do..while
			
			switch(menuChoice)
			{
			case 1:
				console.nextLine(); // flush the buffer
				System.out.print("\nPlease Enter The Name of Your Business: ");
				business.setName(console.nextLine());
				
				System.out.println("\nYour Business is Called: "+business.getName()+".");
				
				createStage1 = true; // to show stage is completed 
				break;
			case 2:
				menuChoice=99;
				gameManager.setIsBusinessSetup(false);
				break;
			} // switch
			
			// if the Business is fully setup, break out of while loop
			// to continue on to set the game difficulty.
			if(createStage1 == true)
			{
				gameManager.setIsBusinessSetup(true);
				menuChoice = 99;
			} // if

		} // while
		
	} // setUpBusiness()
	
	public static void setGameDifficulty(Business business, GameManager gameManager, Scanner console)
	{
		int difChoice=0;
		
		// choosing game difficulty
		System.out.print("\nChoose Game Difficulty:\n"); 
		System.out.print("\n1.) Easy.\n2.) Normal.\n3.) Hard.\n");
		
		
		
		// to make sure the choice entered is in the right range
		do
		{
			System.out.print("\nEnter Option Choice: ");
		
			while(!console.hasNextInt()) 
			{
				System.out.print("\nEnter Option Choice: ");
				console.next(); // to advance Scanner past input
			} // while
			
			difChoice = console.nextInt();
		}while(difChoice < 1 || difChoice > 3); // do..while
		
		if(difChoice == 1) // if easy, business starts with €100,000
		{
			gameManager.setGameDifficulty("Easy");
			business.setBankAccount(100000f);
		}
		else if (difChoice == 2) // if normal, business starts with €50,000
		{
			gameManager.setGameDifficulty("Normal");
			business.setBankAccount(50000);
		}
		else // if hard, business starts with €10,000
		{
			gameManager.setGameDifficulty("Hard");
			business.setBankAccount(10000);
		} // if else
		
		System.out.println("\nYour Game Difficulty is: " + gameManager.getGameDifficulty());
		
		gameManager.setIsNewGameCreated(true);
		
	} // setGameDifficulty
	
	public static void hireEmployees(List<Employee> employees, int theAmount)
	{
		for(int i = 0; i < theAmount; i++)
		{
			Employee employee = new Employee();
			employees.add(employee);
		}
	} // hireEmployees()
	
	
	

} // Class MainClass
