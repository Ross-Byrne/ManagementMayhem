package GameFiles;

import java.util.*;
import java.io.*;

/* This is a game about managing your business.
 * Keep you're business running at all costs. */

public class MainClass {
	
	// Main Method
	
	public static void main(String[] args) throws IOException
	{
		// Creating Objects
		Scanner console = new Scanner(System.in);
		GameManager gameManager = new GameManager();
		Player player = new Player();
		Business business = new Business();
		List<Employee> employees = new ArrayList<Employee>();
		
		// Checks if the save file exists, creates it if it doesn't
		File gameSave = new File("SavedGame.txt");
		if(!gameSave.exists()) {
			gameSave.createNewFile();
		} 
		
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
				loadGame(player, business, gameManager,  employees);
				
				// if a game is loaded successfully, break out of loop to enter game loop
				if(gameManager.getIsGameLoaded() == true)
				{
					endGame = 99;
				}
				else
				{
					System.out.println("A Saved Game Couldn't Be Loaded!");
				}
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
		System.out.println("Business Bank Account: " + business.getBankAccount());
		System.out.println("\nGame Info: \nGame Difficulty: " + gameManager.getGameDifficulty());
		
		// If the game is ready to be played because
		// a New Game was made or a Game Was Loaded,
		// endGame is set to 0.
		// This makes you enter the Main Game Loop.
		// If the game isn't ready to be played, endGame stays 99 
		// and the Main Game Loop is Skipped.
		if(gameManager.getIsNewGameCreated() == true) // if new game is created
		{
			endGame = 0;
		} // if
		
		if(gameManager.getIsGameLoaded() == true) // if a game is loaded
		{
			endGame = 0;
		} // if
		
		// This is the Main Game Loop where the game runs
		while(endGame != 99) // type 5 to exit
		{
			gameManager.printMainGameMenu();			
			
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
				// Play the Game
				System.out.println("Game Is Starting!");
				playGame(player, business, gameManager, console);
				break;
			case 2:
				// Save Game
				saveGame(player, business, gameManager, employees);
				break;
			case 3:
				// Load a Game
				loadGame(player, business, gameManager,  employees);
				
				if(gameManager.getIsGameLoaded() == false)
					System.out.println("A Saved Game Couldn't Be Loaded!");
				break;
			case 4:
				// Delete a Saved Game
				System.out.println("Deleting a Saved Game!");
				break;
			
			case 5:
				// Exit
				System.out.println("\nAre you sure you want to quit?\nAny Unsaved progress will be lost!");
				System.out.println("\nQuit Game?\n1.) Yes.\n2.) No.");
				
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
		//inSavedGame.close();
		
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
	
	public static void hireEmployees(GameManager gameManager, List<Employee> employees, int theAmount)
	{
		Random rnd = new Random();
		int rndValue=0;
		String tempName="";
		
		for(int i = 0; i < theAmount; i++)
		{
			Employee employee = new Employee(); // create employee
			
			rndValue = rnd.nextInt(14); // get a random value 
			tempName = gameManager.randomEmployeeFName[rndValue]; // use value to get random first name
			
			rndValue = rnd.nextInt(14); // get another random value
			tempName += gameManager.randomEmployeeLName[rndValue]; // choose a random last name and add it on to the first name
			
			employee.setName(tempName); // name the employee
			employees.add(employee); // add employee to employees list
		} // for
	} // hireEmployees()
	
	public static void printListOfEmployees(List<Employee> employees)
	{
		String tempNames = "";
		System.out.println("Number of Employees: " + employees.size() + ".");
		
		for(int i = 0; i < employees.size()-1; i++)
			tempNames += "\n\t" + employees.get(i);
		
		System.out.println("List of Employees: \n" + tempNames);
	} // printListOfEmployees()
	
	public static void playGame(Player player, Business business, GameManager gameManager, Scanner console)
	{
		// Playing the Game
		int menuChoice = 0;
		
		while(menuChoice != 99)
		{
			gameManager.printGameOptionsMenu();
			
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
			}while(menuChoice < 1 || menuChoice > 5); // do..while
			
			switch(menuChoice)
			{
			case 1:
				// Keep Playing
				System.out.println("Continue Playing");
				break;
			case 2:
				// Show Player Status
				System.out.println("Player Status");
				
				break;
			case 3:
				// Show Business Status
				System.out.println("Business Status");
				break;
			case 4:
				// Manage The Business
				System.out.println("Managing The Business");
				break;
			case 5:
				// Back to Game Menu
				System.out.println("Heading Back To Main Game Menu");
				menuChoice=99;
				break;
			} // switch
			
		} // while
		
	} // playGame
	
	public static void saveGame(Player player, Business business, GameManager gameManager, 
			List<Employee> employees) throws IOException
	{
		System.out.println("Saving Game!");
		
		PrintWriter outSavedGame = new PrintWriter("SavedGame.txt");
		
		// Saving players state to save file
		outSavedGame.printf("%s%n", player.getName());
		outSavedGame.printf("%f%n", player.getBankAccount());
		outSavedGame.printf("%s%n", player.getTraits(1));
		outSavedGame.printf("%s%n", player.getTraits(2));
		outSavedGame.printf("%s%n", player.getTraits(3));
		outSavedGame.printf("%s%n", player.getTraits(4));
		outSavedGame.printf("%s%n", player.getTraits(5));
		
		// Saving business' state to save file
		outSavedGame.printf("%s%n", business.getName());
		outSavedGame.printf("%f%n", business.getBankAccount());
		outSavedGame.printf("%d%n", business.getGoodReputation());
		outSavedGame.printf("%d%n", business.getBadReputation());
		outSavedGame.printf("%d%n", business.getBuildingSize());
		outSavedGame.printf("%f%n", business.getEmployeeSalary());
		outSavedGame.printf("%f%n", business.getTotalEmployeeSalary());
			
		outSavedGame.close();
	} // saveGame()
	
	public static void loadGame(Player player, Business business, GameManager gameManager, 
			List<Employee> employees) throws IOException
	{	
		gameManager.setIsGameLoaded(false);
		Scanner inSavedGame = new Scanner(new FileReader("SavedGame.txt"));
		
		
		// to make sure the file loads the right values (in case file was edited)	
		// Using ifs for each value
		// inSavedGame.next(); is to advance Scanner past input
		
		// Loading players state from save file
		if(inSavedGame.hasNextLine()) { player.setName(inSavedGame.nextLine()); } // player.setName()
		else{ inSavedGame.close(); return; }	
		if(inSavedGame.hasNextFloat()) { player.setBankAccount(inSavedGame.nextFloat()); } // player.setBankAccount()
		else{ inSavedGame.close(); return; }	
		if(inSavedGame.hasNext()) { player.setTraits(1, inSavedGame.next()); } // player.setTraits(1)
		else{ inSavedGame.close(); return; }
		if(inSavedGame.hasNext()) { player.setTraits(2, inSavedGame.next()); } // player.setTraits(2)
		else{ inSavedGame.close(); return; }
		if(inSavedGame.hasNext()) { player.setTraits(3, inSavedGame.next()); } // player.setTraits(3)
		else{ inSavedGame.close(); return; }
		if(inSavedGame.hasNext()) { player.setTraits(4, inSavedGame.next()); } // player.setTraits(4)
		else{ inSavedGame.close(); return; }
		if(inSavedGame.hasNext()) { player.setTraits(5, inSavedGame.next()); } // player.setTraits(5)
		else{ inSavedGame.close(); return; }
		
		// Loading business' state from save file
		inSavedGame.nextLine(); // flush the buffer
		if(inSavedGame.hasNextLine()) { business.setName(inSavedGame.nextLine()); } // business.setName()
		else{ inSavedGame.close(); return; }
		if(inSavedGame.hasNextFloat()) { business.setBankAccount(inSavedGame.nextFloat()); } // business.setBankAccount
		else{ inSavedGame.close(); return; }
		if(inSavedGame.hasNextInt()) { business.setGoodReputation(inSavedGame.nextInt()); } // business.setGoodReputation()
		else{ inSavedGame.close(); return; }
		if(inSavedGame.hasNextInt()) { business.setBadReputation(inSavedGame.nextInt()); } // business.setBadReputation()
		else{ inSavedGame.close(); return; }
		if(inSavedGame.hasNextInt()) { business.setBuildingSize(inSavedGame.nextInt()); } // business.setBuildingSize()
		else{ inSavedGame.close(); return; }
		if(inSavedGame.hasNextFloat()) { business.setEmployeeSalary(inSavedGame.nextFloat()); } // business.setEmployeeSalary()
		else{ inSavedGame.close(); return; }
		if(inSavedGame.hasNextFloat()) { business.setTotalEmployeeSalary(inSavedGame.nextFloat()); } // business.setTotalEmployeeSalary()
		else{ inSavedGame.close(); return; }
		
		// saying the game loaded
		gameManager.setIsGameLoaded(true);
		System.out.println("Loading Game!");

		inSavedGame.close();
	} // loadGame()
	
	
	

} // Class MainClass
