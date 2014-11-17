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
		
		System.out.println("\t\t\tWelcome To Management Mayhem!");
		
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
				
				startNewGame(player, business, gameManager, menuManager, console);
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
				playGame(player, business, gameManager, menuManager, console);
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
		//inSavedGame.close();
		
	} // main()
	
	// Methods
	
	public static void startNewGame(Player player, Business business, GameManager gameManager, MenuManager menuManager, Scanner console)
	{
		// Starting a new Game Stuff
		// Creating A Character
		createCharacter(player, business, gameManager, menuManager, console);
		
		// Setup Business if character is created
		if(gameManager.getIsCharacterCreated() == true)
		{
			setUpBusiness(player, business, gameManager, menuManager, console);
		}
		
		// If the business has been setup, Set Game Difficulty
		if(gameManager.getIsBusinessSetup() == true)
		{
			setGameDifficulty(business, gameManager, console);
		}
		
	} // startNewGame()
	
	public static void createCharacter(Player player, Business business, GameManager gameManager, MenuManager menuManager, Scanner console)
	{
		int menuChoice = 0;
		boolean createStage1, createStage2;
		
		gameManager.setIsCharacterCreated(false);
		createStage1 = createStage2 = false;
		
		while(menuChoice != 99)
		{
			menuManager.printCharacterCreateMenu();
			
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
				System.out.print("\n\t\t\tChoose Five Traits For Your Character!\n");
				
				for(int i = 0; i < gameManager.playerTraitsSelection.length; i++)
				{
					System.out.printf("\n\t\t\t%d.) %s", i+1, gameManager.getPlayerTraitsSelection(i));

				} // for
				System.out.println();
				
				int choice;
				String tempTrait;
				int[] choiceRecord = {0,0,0,0,0};
				
				for(int i = 0; i < 5; i++)
				{
					// to make sure the choice entered is in the right range
					do
					{
						System.out.printf("%nChoose Character Trait %d: ", i+1);
					
						while(!console.hasNextInt()) 
						{
							System.out.printf("%nChoose Character Trait %d: ", i+1);
							console.next(); // to advance Scanner past input
						} // while
						
						choice = console.nextInt();
						
						// to make sure only one of each trait is picked...
						if(choice > 0 && choice < 11)
						{
							for(int j = 0; j < 5; j++)
							{
								if(choiceRecord[j] == choice) 	// the trait picked is checked against other traits picked
								{							  	// if the triat has alreadly been picked,
									System.out.printf("'%s' has Already been Chosen, Pick a Different Trait.%n", gameManager.getPlayerTraitsSelection(choice-1)); 
									choice = 99; // exit
								} // if
							} // for
						} // if
						
						
					}while(choice < 1 || choice > 10); // do..while
					
					
					
					
					// to make sure only one of each trait is picked
					// choice is put into choiceRecord
					choiceRecord[i] = choice;
					
					tempTrait = gameManager.getPlayerTraitsSelection(choice-1);
					
					if(choice < 6) // if a good trait
					{
						business.setGoodReputation(business.getGoodReputation() + 5);
					}
					else // if a bad trait
					{
						business.setBadReputation(business.getBadReputation() + 5);
					}
						
					player.setTraits(i, tempTrait);
					System.out.println("\nTrait Chosen: " + tempTrait);
				} // for
				
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
	
	public static void setUpBusiness(Player player, Business business, GameManager gameManager, MenuManager menuManager, Scanner console)
	{
		int menuChoice = 0;
		boolean createStage1 = false;
		
		gameManager.setIsBusinessSetup(false);
				
		while(menuChoice != 99)
		{
			menuManager.printBusinessSetupMenu();
			
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
		System.out.print("\n\t\t\tChoose Game Difficulty:\n"); 
		System.out.print("\n\t\t\t1.) Easy.\n\t\t\t2.) Normal.\n\t\t\t3.) Hard.\n");
		
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
	
	public static void playGame(Player player, Business business, GameManager gameManager, MenuManager menuManager, Scanner console)
	{
		// Playing the Game
		int menuChoice = 0;
		
		while(menuChoice != 99)
		{
			menuManager.printGameOptionsMenu();
			
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
				continuePlaying(player, business, gameManager, menuManager, console);
				break;
			case 2:
				// Show Player Status
				System.out.println("\nPlayer Status:");
				System.out.println(player.displayPlayerInfo());
				break;
			case 3:
				// Show Business Status
				System.out.println("\nBusiness Status:");
				System.out.println(business.displayBusinessInfo());
				System.out.printf("%d Out Of %d Employees.\n", business.employees.size(), business.getMaxEmployees());
				break;
			case 4:
				// Manage The Business
				manageBusiness(player, gameManager, menuManager, business, console);
				break;
			case 5:
				// Back to Game Menu
				System.out.println("Heading Back To Main Game Menu");
				menuChoice=99;
				break;
			} // switch
			
		} // while
		
	} // playGame
	
	public static void continuePlaying(Player player, Business business, GameManager gameManager, MenuManager menuManager, Scanner console)
	{
		int menuChoice = 0;
		float monthlyIncome = 0;
		float monthlyCosts = 0;
		
		if(business.getBankAccount() <= -10000) // if the business is -10,000 or more in debt
		{
			menuManager.printGameOverMessage(); // prints GAME OVER Message
			
			return; // to exit
		} // if
		
		// The Business Monthly Incomes - producing products etc.
		System.out.printf("\n\t\t\t********** The Business Monthly Incomes **********\n");
		
		business.produceProducts();
		
		monthlyIncome += business.getMoneyEarned();
		
		System.out.printf("\n\t\t\tThe Business Products Generate A Total Of €%.2f This Month.\n", monthlyIncome);
			
		// Business monthly costs - paying employees, maintenance etc
		System.out.printf("\n\n\t\t\t********** The Business Monthly Costs **********\n");
		try 
		{
			business.payMaintenance();
			business.payEmployees();
			
			System.out.printf("\n\t\t\tThe Building's Maintenance Bill Of €%.2f Has Been Paid For The Month.", business.getBuildingMaintenance());
			System.out.printf("\n\t\t\t%d Employees Have Been Paid A Total Of €%.2f For The Month.\n", 
					business.employees.size(), business.getTotalEmployeeSalary());
			
			monthlyCosts = business.getBuildingMaintenance() + business.getTotalEmployeeSalary();
			
			System.out.printf("\n\t\t\tThe Business Pays A Total Cost Of €%.2f This Month.\n", monthlyCosts);
			
			System.out.printf("\n\n\t\t\t********** The Business Account Balance **********\n");
			System.out.printf("\n\t\t\tThe Business Bank Account Balance Is Now €%.2f.\n", business.getBankAccount());
		}
		catch(Exception e)
		{
			monthlyCosts = business.getBuildingMaintenance() + business.getTotalEmployeeSalary(); // get monthly cost
			
			System.out.printf("\n\t\t\tThe Business Bank Account Balance is: €%.2f.", business.getBankAccount());
			System.out.printf("\n\t\t\tThe Monthly Costs Are €%.2f.", monthlyCosts);
			// Message saying the money cannot be paid
			System.out.println(e.getMessage());
			
			System.out.println("\n\t\t\tIf You Want To Avoid Becoming In Debt To The Bank");
			System.out.println("\t\t\tYou Will Have To Fire Some Employees Or Reduce Building's Maintenance Level.");
			System.out.println("\t\t\tThe Bank Will Only Tolerate €10,000 Of Debt.");
			
			System.out.println("\n\t\t\t1.) Fire Some Employees Or Reduce Building's Maintenance Level.");
			System.out.println("\t\t\t2.) Continue On And Become In Debt.");
			
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
			
			if(menuChoice == 1)
			{
				System.out.println("\n\t\t\tTo Continue Playing, Go to 'Manage The Business'.");
				System.out.println("\t\t\tThen Go To 'Manage Employees' And Fire Some Employees.");
				System.out.println("\t\t\tOr Go To 'Manage Building' And Change Building Maintenance Level.");
				return; // exit to menu, do not progress a month.
			}
			else
			{
				business.payEmployeesAnyway();
				
				if(business.getBankAccount() <= -10000) // if the business is -10,000 or more in debt
				{
					menuManager.printGameOverMessage();
					
					return;
				}
				else
				{
					System.out.println("\n\t\t\tYou Are Now In Debt. The Bank Will Only Tolerate €10,000 of Debt.");
					System.out.println("\n\t\t\tBecause Your In Debt, You Cannot Afford To Pay For Building Maintenance.");
					System.out.println("\t\t\tYour Building's Maintenance Level Has Been Reduced To 'None'.");
					business.setBuildingMaintenanceLevel(1); // set to none
					
					System.out.printf("\n\t\t\t%d Employees Have Been Paid A Total Of €%.2f For The Month.\n", 
							business.employees.size(), business.getTotalEmployeeSalary());
					
					System.out.printf("\n\n\t\t\t********** The Business Account Balance **********\n");
					System.out.println("\t\t\tYour Business Bank Account Balance Is Now: €" + business.getBankAccount());
				} // if
			} // if
		} // try catch
		
		business.setBusinessAge(business.getBusinessAge() + 1); // business age in months +1
		System.out.println("\n\t\t\tBusiness Age: " + business.getBusinessAge() + " Months.");
	} // continuePlaying()
	
	public static void manageBusiness(Player player, GameManager gameManager, MenuManager menuManager, Business business, Scanner console)
	{
		int menuChoice = 0;
		
		while(menuChoice != 99)
		{
			menuManager.printManageBusinessMenu();
			
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
				// Manage Employees
				manageEmployees(gameManager, menuManager, business, console);
				break;
			case 2:
				// Manage The Building
				manageBuilding(business, menuManager, console);
				break;
			case 3:
				// Manage Operations
				manageOperations(gameManager, business, menuManager, console);
				break;
			case 4:
				// Show Profits/Expenses
				System.out.println("Show Profits/Expenses");
				break;
			case 5:
				// Back to Game Menu
				System.out.println("Heading Back To Game Menu");
				menuChoice=99;
				break;
			} // switch
			
		} // while
	} // manageBusiness()
	
	public static void manageEmployees(GameManager gameManager, MenuManager menuManager, Business business, Scanner console)
	{
		int menuChoice = 0;
		
		while(menuChoice != 99)
		{	
			int noOfEmployeesAllowed = (business.getMaxEmployees() - business.employees.size()); // the no. of employees you can hire
			
			System.out.printf("%n\t\t\tYou Have %d Out Of The %d Employees You Can Hire.", business.employees.size(), business.getMaxEmployees());
			System.out.printf("%n\t\t\tExpanding Your Building Will Increase The Number Of Employees You Can Have.%n");
			
			menuManager.printManageEmployeesMenu();
			
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
			case 1: // hire Employees
				int amount=0;
				System.out.println("Hire Employees");
				
				// to make sure the choice entered is in the right range
				do
				{					
					System.out.print("\nEnter the amount of Employees you want to hire: ");
				
					while(!console.hasNextInt()) 
					{
						System.out.print("\nEnter the amount of Employees you want to hire: ");
						console.next(); // to advance Scanner past input
					} // while
					
					amount = console.nextInt();
					
					if(noOfEmployeesAllowed == 0)
					{
						System.out.printf("\n\t\t\tYou Have %d Out Of %d Employees!", business.employees.size(), business.getMaxEmployees());
						System.out.println("\n\t\t\tIncrease Size Of Building To Hire More!");
						amount = 0;
					}
					 
					if(amount > noOfEmployeesAllowed)
					{
						System.out.printf("\n\t\t\tYou Can Only Hire %d More Employees!", (business.getMaxEmployees() - business.employees.size()));
						System.out.println("\n\t\t\tIncrease Size Of Building To Hire More!");
					} // if
					
					if(amount == 0) // if don't want to hire anyone
					{
						break;
					}
					
					
				}while( amount < 1 || amount > noOfEmployeesAllowed); // do..while
				
				business.hireEmployees(gameManager, amount);
				break;
			case 2: // fire Employees
				amount=0;
				
				// to make sure the choice entered is in the right range
				do
				{
					System.out.print("\nEnter the amount of Employees you want to Fire: ");
				
					while(!console.hasNextInt()) 
					{
						System.out.print("\nEnter the amount of Employees you want to Fire: ");
						console.next(); // to advance Scanner past input
					} // while
					
					amount = console.nextInt();
					
					if(amount > business.employees.size())
					{
						System.out.printf("\n\t\t\tYou Cannot Fire %d Employees!", amount);
						System.out.printf("\n\t\t\tYou Only Have %d Employees!\n", business.employees.size());
					} // if
					
					if(amount == 0)
					{
						break;
					} // if
					
					
				}while(amount < 1 || amount > business.employees.size()); // do..while
		
				business.fireEmployees(gameManager, amount);
				
				break;
			case 3: // View List of Employees
				System.out.printf("\nYou Have %d Employees.\n", business.employees.size());
				business.printListOfEmployees();
				break;
			case 4: // set employee Salary
				int choice = 0;
				
				System.out.println("\n\t\t\tThe Salary Your Employees Get Paid Effects Your Reputation");
				System.out.printf("\t\t\tYour Employees Current Salary Is €%.2f A Month Each.", business.getEmployeeSalary());
				
				menuManager.printSetEmployeeSalaryMenu();
				
				// to make sure the choice entered is in the right range
				do
				{
					System.out.print("\nEnter Option Choice: ");
				
					while(!console.hasNextInt()) 
					{
						System.out.print("\nEnter Option Choice: ");
						console.next(); // to advance Scanner past input
					} // while
					
					choice = console.nextInt();
				}while(choice < 1 || choice > 5); // do..while
				
				if(choice != 5)
				{
					// set the Salary level
					business.setEmployeeSalaryLevel(choice);
				} // if
				// if 5, its exits
				break;
			case 5: // go back
				System.out.println("Going Back.");
				menuChoice = 99;
				break;
			} // switch
		} // while
	} // manageEmployees()
	
	public static void manageBuilding(Business business, MenuManager menuManager, Scanner console)
	{
		System.out.println("Manage The Building");
		
		int menuChoice = 0;
		
		while(menuChoice != 99)
		{	
			System.out.printf("%n\t\t\tYour Building Has %d Rooms In It And A Maintenance Bill Of €%.2f A Month.", 
					business.getBuildingSize(), business.getBuildingMaintenance());
			System.out.printf("%n\t\t\tExpanding Your Building Will Increase The Number Of Employees You Can Have.%n");
			
			menuManager.printManageTheBuildingMenu();
			
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
			case 1: // Add rooms
				int upgrade = 0;
				
				System.out.println("\n\t\t\tWould You Like To Upgrade The Building By 1 Room?");
				System.out.printf("\t\t\tThe Upgrade Will Cost €%.2f", business.getBuildingUpgradeCost());
				System.out.printf("\n\t\t\tBusiness Account Balance is: €%.2f\n", business.getBankAccount());
				
				System.out.println("\n\t\t\t1.) Yes.");
				System.out.println("\t\t\t2.) No.");
				
				// to make sure the choice entered is in the right range
				do
				{
					System.out.print("\nEnter Option Choice: ");
				
					while(!console.hasNextInt()) 
					{
						System.out.print("\nEnter Option Choice: ");
						console.next(); // to advance Scanner past input
					} // while
					
					upgrade = console.nextInt();
				}while(upgrade < 1 || upgrade > 2); // do..while
				
				if(upgrade == 1) // if upgrading
				{
					try
					{
						business.upgradeBuilding();
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					} // try catch
				}
				else // exit
				{
					break;
				}
				break;
			case 2: // set Maintenance Level
				int choice=0;
				
				System.out.println("\n\t\t\tThe Level Of Maintenance Your Building Gets Effects Your Reputation");
				System.out.printf("\t\t\tYour Current Maintenance Bill Is €%.2f A Month.", business.getBuildingMaintenance());
				
				menuManager.printSetMaintenanceLevelMenu();
				
				// to make sure the choice entered is in the right range
				do
				{
					System.out.print("\nEnter Option Choice: ");
				
					while(!console.hasNextInt()) 
					{
						System.out.print("\nEnter Option Choice: ");
						console.next(); // to advance Scanner past input
					} // while
					
					choice = console.nextInt();
				}while(choice < 1 || choice > 5); // do..while
				
				if(choice != 5)
				{
					// set the maintenance level
					business.setBuildingMaintenanceLevel(choice);
				} // if
				// if 5, its exits
				break;
			case 3: // go back
				System.out.println("Going Back.");
				menuChoice = 99;
				break;
			} // switch
		} // while
	} // manageBuilding
	
	public static void manageOperations(GameManager gameManager, Business business, MenuManager menuManager, Scanner console)
	{
		System.out.println("Manage Operations");
		
		int menuChoice = 0;
		int menusAllowed = 3;
		
		while(menuChoice != 99)
		{	
			System.out.printf("\n\t\t\tUpgrading Your Equipment Will Increase Productivity.");
			System.out.printf("\n\t\t\tYou Can Only Apply For A Business Grant Every 12 Months.\n");
			
			menuManager.printManageOperationsMenu();
			
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
			}while(menuChoice < 1 || menuChoice > menusAllowed); // do..while
			
			switch(menuChoice)
			{
			case 1: // Upgrade Equipment
				int upgrade = 0;
				
				System.out.println("\n\t\t\tWould You Like To Upgrade The Business Equipment?");
				System.out.println("\t\t\tEach Upgrade Will Increase The Businesses Productivity Bonus By 10%\n");
				System.out.printf("\t\t\tThe Upgrade Will Cost €%.2f", business.getEquipmentUpgradeCost());
				System.out.printf("\n\t\t\tBusiness Account Balance is: €%.2f\n", business.getBankAccount());
				
				System.out.println("\n\t\t\t1.) Yes.");
				System.out.println("\t\t\t2.) No.");
				
				// to make sure the choice entered is in the right range
				do
				{
					System.out.print("\nEnter Option Choice: ");
				
					while(!console.hasNextInt()) 
					{
						System.out.print("\nEnter Option Choice: ");
						console.next(); // to advance Scanner past input
					} // while
					
					upgrade = console.nextInt();
				}while(upgrade < 1 || upgrade > 2); // do..while
				
				if(upgrade == 1) // if upgrading
				{
					try
					{
						business.upgradeEquipment();
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					} // try catch
				}
				else // exit
				{
					break;
				}
				break;
			case 2: // Apply For Grant
				int choice=0;
				
				System.out.println("\n\t\t\tThe Level Of Maintenance Your Building Gets Effects Your Reputation");
				System.out.printf("\t\t\tYour Current Maintenance Bill Is €%.2f A Month.", business.getBuildingMaintenance());
				
				menuManager.printSetMaintenanceLevelMenu();
				
				// to make sure the choice entered is in the right range
				do
				{
					System.out.print("\nEnter Option Choice: ");
				
					while(!console.hasNextInt()) 
					{
						System.out.print("\nEnter Option Choice: ");
						console.next(); // to advance Scanner past input
					} // while
					
					choice = console.nextInt();
				}while(choice < 1 || choice > 5); // do..while
				
				if(choice != 5)
				{
					// set the maintenance level
					business.setBuildingMaintenanceLevel(choice);
				} // if
				// if 5, its exits
				break;
			case 3: // go back
				System.out.println("Going Back.");
				menuChoice = 99;
				break;
			case 4: // Start Selling Drugs
				System.out.println("\t\t\t3.) Start Selling Drugs.");
				System.out.println("\t\t\t4.) Build A Drugs Lab.");
				break;
			case 5: // Build Drug Lab
				break;

			} // switch
		} // while
		
	} // manageOperations()

} // Class MainClass
