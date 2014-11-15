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
		// Polymorphism
		List<Employee> dealers = new ArrayList<Employee>();
		
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
				loadGame(player, business, gameManager,  employees, dealers);
				
				// if a game is loaded successfully, break out of loop to enter game loop
				if(gameManager.getIsGameLoaded() == true)
				{
					endGame = 99;
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
				// Setting up default number of employees to 3
				hireEmployees(gameManager, employees, 3);
				
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
			System.out.printf("Number Of Employees: %d", employees.size());
			System.out.println("\n\nGame Info: \n\nGame Difficulty: " + gameManager.getGameDifficulty());
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
				playGame(player, business, gameManager, employees, dealers, console);
				break;
			case 2:
				// Save Game
				saveGame(player, business, gameManager, employees, dealers);
				break;
			case 3:
				// Load a Game
				loadGame(player, business, gameManager,  employees, dealers);
				break;
			case 4:
				// Delete a Saved Game
				System.out.println("Deleting a Saved Game!");
				break;
			
			case 5:
				// Exit
				System.out.println("\n\t\t\tAre you sure you want to quit?\n\t\t\tAny Unsaved progress will be lost!");
				System.out.println("\n\t\t\tQuit Game?\n\n\t\t\t1.) Yes.\n\t\t\t2.) No.");
				
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
						for(int j = 0; j < 5; j++)
						{
							if(choiceRecord[j] == choice) 	// the trait picked is checked against other traits picked
							{							  	// if the triat has alreadly been picked,
								System.out.printf("'%s' has Already been Chosen, Pick a Different Trait.%n", gameManager.getPlayerTraitsSelection(choice-1)); 
								choice = 99;				// choice is set to 99, so your asked to pick a trait again
							} // if						  
						} // for
					}while(choice < 1 || choice > 12); // do..while
					
					// to make sure only one of each trait is picked
					// choice is put into choiceRecord
					choiceRecord[i] = choice;
					
					tempTrait = gameManager.getPlayerTraitsSelection(choice-1);
						
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
	
	public static void hireEmployees(GameManager gameManager, List<Employee> employees, int theAmount)
	{
		Random rnd = new Random();
		int rndValue=0;
		String tempName="";
		
		for(int i = 0; i < theAmount; i++)
		{
			Employee employee = new Employee(); // create employee
			
			rndValue = rnd.nextInt(14); // get a random value 
			tempName = gameManager.randomFName[rndValue]; // use value to get random first name
			
			rndValue = rnd.nextInt(14); // get another random value
			tempName += gameManager.randomLName[rndValue]; // choose a random last name and add it on to the first name
			
			employee.setName(tempName); // name the employee
			employees.add(employee); // add employee to employees list
		} // for
	} // hireEmployees()
	
	public static void fireEmployees(GameManager gameManager, List<Employee> employees, int theAmount)
	{
		if(theAmount == employees.size()) // if the amount is = to all employees, clear list
		{
			employees.clear();
		}
		else // remove the number entered
		{
			while(theAmount > 0)
				employees.remove(theAmount--);
		} // if else
	} // fireEmployees()
	
	public static void printListOfEmployees(List<Employee> employees)
	{
		String tempNames = "";
		
		for(int i = 0; i < employees.size(); i++)
			tempNames += "\n\t" + employees.get(i);
		
		System.out.println("Employees: " + tempNames);
	} // printListOfEmployees()
	
	public static void hireDealers(GameManager gameManager, List<Employee> dealers, int theAmount)
	{
		Random rnd = new Random();
		int rndValue=0;
		String tempName="";
		
		for(int i = 0; i < theAmount; i++)
		{
			Dealer dealer = new Dealer(); // create dealer - Polymorphism
			
			rndValue = rnd.nextInt(14); // get a random value 
			tempName = gameManager.getRandomFName(rndValue); // use value to get random first name
			
			rndValue = rnd.nextInt(14); // get another random value
			tempName += gameManager.getRandomLName(rndValue); // choose a random last name and add it on to the first name
			
			dealer.setName(tempName); // name the employee
			dealers.add(dealer); // add dealer to dealers list
		} // for
	} // hireDealers()
	
	public static void fireDealers(GameManager gameManager, List<Employee> dealers, int theAmount)
	{
		if(theAmount == dealers.size()) // if the amount is = to all dealers, clear list
		{
			dealers.clear();
		}
		else // remove the number entered
		{
			while(theAmount > 0)
				dealers.remove(theAmount--);
		} // if else
	} // fireDealers()
	
	public static void printListOfDealers(List<Employee> dealers)
	{
		String tempNames = "";
		System.out.println("\nNumber of Dealers: " + dealers.size() + ".");
		
		for(int i = 0; i < dealers.size(); i++)
			tempNames += "\n\t" + dealers.get(i);
		
		System.out.println("List of Dealers: \n" + tempNames);
	} // printListOfDealers()
	
	public static void playGame(Player player, Business business, GameManager gameManager,
			List<Employee> employees, List<Employee> dealers, Scanner console)
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
				
				if(business.getBankAccount() <= -10000) // if the business is -10,000 or more in debt
				{
					gameManager.printGameOverMessage(); // prints GAME OVER Message
					
					break; // to exit
				} // if
				
				// The Business Monthly Incomes
					
				// stuff here *********
				
				// Business monthly costs - paying employees, maintenance etc
				try 
				{
					business.payMaintenance();
					business.payEmployees(employees.size());
					
					System.out.printf("\nThe Building's Maintenance Bill Of €%.2f Has Been Paid For The Month.\n", business.getBuildingMaintenance());
					System.out.printf("\n%d Employees Have Been Paid A Total Of €%.2f For The Month.\n", employees.size(), business.getTotalEmployeeSalary());
					
					System.out.printf("The Business Bank Account Balance is €%.2f.\n", business.getBankAccount());
				}
				catch(Exception e)
				{
					System.out.printf("\nThe Business Bank Account Balance is: €%.2f.", business.getBankAccount());
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
						System.out.println("\nTo Continue Playing, Go to 'Manage The Business'.");
						System.out.println("Then Go To 'Manage Employees' And Fire Some Employees.");
						System.out.println("Or Go To 'Manage Building' And Change Building Maintenance Level.");
						break; // exit to menu, do not progress a month.
					}
					else
					{
						business.payEmployeesAnyway(employees.size());
						
						if(business.getBankAccount() <= -10000) // if the business is -10,000 or more in debt
						{
							gameManager.printGameOverMessage();
							
							break;
						}
						else
						{
							System.out.println("\nYou Are Now In Debt. The Bank Will Only Tolerate €10,000 of Debt.");
							System.out.println("Your Business Bank Account Balance Is Now: €" + business.getBankAccount());
						} // if
					} // if
				} // try catch
				
				business.setBusinessAge(business.getBusinessAge() + 1); // business age in months +1
				System.out.println("\nBusiness Age: " + business.getBusinessAge() + " Months.");
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
				System.out.printf("%d Out Of %d Employees.\n", employees.size(), business.getMaxEmployees());
				break;
			case 4:
				// Manage The Business
				manageBusiness(player, gameManager, business, 
						employees, dealers, console);
				break;
			case 5:
				// Back to Game Menu
				System.out.println("Heading Back To Main Game Menu");
				menuChoice=99;
				break;
			} // switch
			
		} // while
		
	} // playGame
	
	public static void manageBusiness(Player player, GameManager gameManager, Business business, 
			List<Employee> employees, List<Employee> dealers, Scanner console)
	{
		int menuChoice = 0;
		
		while(menuChoice != 99)
		{
			gameManager.printManageBusinessMenu();
			
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
				manageEmployees(gameManager, business, employees, dealers, console);
				break;
			case 2:
				// Manage The Building
				manageBuilding(business, console);
				break;
			case 3:
				// Manage Operations
				System.out.println("Manage Operations");
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
	
	public static void manageEmployees(GameManager gameManager, Business business, List<Employee> employees, List<Employee> dealers, Scanner console)
	{
		int menuChoice = 0;
		
		while(menuChoice != 99)
		{	
			int noOfEmployeesAllowed = (business.getMaxEmployees() - employees.size()); // the no. of employees you can hire
			
			System.out.printf("%n\t\t\tYou Have %d Out Of The %d Employees You Can Hire.", employees.size(), business.getMaxEmployees());
			System.out.printf("%n\t\t\tExpanding Your Building Will Increase The Number Of Employees You Can Have.%n");
			
			System.out.println("\n\t\t\tManage Employees\n");
			System.out.println("\t\t\t1.) Hire Employees.");
			System.out.println("\t\t\t2.) Fire Employees.");
			System.out.println("\t\t\t3.) View List Of your Employees.");
			System.out.println("\t\t\t4.) Back To Manage The Business.");
			
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
			}while(menuChoice < 1 || menuChoice > 4); // do..while
			
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
						System.out.printf("\n\t\t\tYou Have %d Out Of %d Employees!", employees.size(), business.getMaxEmployees());
						System.out.println("\n\t\t\tIncrease Size Of Building To Hire More!");
						amount = 0;
					}
					 
					if(amount > noOfEmployeesAllowed)
					{
						System.out.printf("\n\t\t\tYou Can Only Hire %d More Employees!", (business.getMaxEmployees() - employees.size()));
						System.out.println("\n\t\t\tIncrease Size Of Building To Hire More!");
					} // if
					
					if(amount == 0) // if don't want to hire anyone
					{
						break;
					}
					
					
				}while( amount < 1 || amount > noOfEmployeesAllowed); // do..while
				
				hireEmployees(gameManager, employees, amount);
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
					
					if(amount > employees.size())
					{
						System.out.printf("\n\t\t\tYou Cannot Fire %d Employees!", amount);
						System.out.printf("\n\t\t\tYou Only Have %d Employees!\n", employees.size());
					} // if
					
					if(amount == 0)
					{
						break;
					} // if
					
					
				}while(amount < 1 || amount > employees.size()); // do..while
		
				fireEmployees(gameManager, employees, amount);
				
				break;
			case 3: // View List of Employees
				System.out.printf("\nYou Have %d Employees.\n", employees.size());
				printListOfEmployees(employees);
				break;
			case 4: // go back
				System.out.println("Going Back.");
				menuChoice = 99;
				break;
			} // switch
		} // while
	} // manageEmployees()
	
	public static void manageBuilding(Business business, Scanner console)
	{
		System.out.println("Manage The Building");
		
		int menuChoice = 0;
		
		while(menuChoice != 99)
		{	
			System.out.printf("%n\t\t\tYour Building Has %d Rooms In It And A Maintenance Bill Of €%.2f A Month.", business.getBuildingSize(), business.getBuildingMaintenance());
			System.out.printf("%n\t\t\tExpanding Your Building Will Increase The Number Of Employees You Can Have.%n");
			
			System.out.println("\n\t\t\tManage The Building\n");
			System.out.println("\t\t\t1.) Upgrade Size Of Building.");
			System.out.println("\t\t\t2.) Set Maintenance Level.");
			System.out.println("\t\t\t3.) Back To Manage The Business.");
			
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
				
				System.out.println("\n\n\t\t\tSet Level Of Maintenance Your Building Gets.");
				
				System.out.println("\n\t\t\t1.) None - €0.");
				System.out.println("\t\t\t2.) Low - €500.");
				System.out.println("\t\t\t3.) Medium - €1000.");
				System.out.println("\t\t\t4.) High - €1500.");
				System.out.println("\t\t\t5.) Back To Manage The Business.");
				
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
				
				float oldMaintenanceCost=0;
				oldMaintenanceCost = business.getBuildingMaintenance(); // to make sure player doesn't keep changing 
																		// maintenance to endless get reputation
				if(choice != 5) // if exiting, do nothing
				{
					if(oldMaintenanceCost == 0)
					{
						business.setBadReputation(business.getBadReputation() - 50);
					}
					else if(oldMaintenanceCost == 500)
					{
						business.setBadReputation(business.getBadReputation() - 25);
					}
					else if(oldMaintenanceCost == 1000)
					{
						business.setGoodReputation(business.getGoodReputation() - 25);
					}
					else if(oldMaintenanceCost == 1500)
					{
						business.setGoodReputation(business.getGoodReputation() - 50);
					} // if
				} // if
				
				switch(choice)
				{
				case 1: // no maintenance
					business.setBuildingMaintenance(0); // sets maintenance cost
					business.setBadReputation(business.getBadReputation() + 50); // get +50 bad rep
					break;
				case 2: // low maintenance
					business.setBuildingMaintenance(500); // sets maintenance cost
					business.setBadReputation(business.getBadReputation() + 25); // get +25 bad rep
					break;
				case 3: // medium maintenance
					business.setBuildingMaintenance(1000); // sets maintenance cost
					business.setGoodReputation(business.getGoodReputation() + 25); // get +25 good rep
					break;
				case 4: // high maintenance
					business.setBuildingMaintenance(1500); // sets maintenance cost
					business.setGoodReputation(business.getGoodReputation() + 50); // get +50 good rep
					break;
				case 5: // go back
					break;
				} // switch
				break;
			case 3: // go back
				System.out.println("Going Back.");
				menuChoice = 99;
				break;
			} // switch
		} // while
	} // manageBuilding

	public static void saveGame(Player player, Business business, GameManager gameManager, 
			List<Employee> employees, List<Employee> dealers) throws IOException
	{
		System.out.println("Saving Game!");
		
		PrintWriter outSavedGame = new PrintWriter("SavedGame.txt");
		
		// Saving players state to save file
		outSavedGame.printf("%s%n", player.getName());
		outSavedGame.printf("%s%n", player.getTraits(0));
		outSavedGame.printf("%s%n", player.getTraits(1));
		outSavedGame.printf("%s%n", player.getTraits(2));
		outSavedGame.printf("%s%n", player.getTraits(3));
		outSavedGame.printf("%s%n", player.getTraits(4));
		outSavedGame.printf("%f%n", player.getBankAccount());
		
		// Saving business' state to save file
		outSavedGame.printf("%s%n", business.getName());
		outSavedGame.printf("%f%n", business.getBankAccount());
		outSavedGame.printf("%d%n", business.getGoodReputation());
		outSavedGame.printf("%d%n", business.getBadReputation());
		outSavedGame.printf("%d%n", business.getBuildingSize());
		outSavedGame.printf("%f%n", business.getEmployeeSalary());
		outSavedGame.printf("%f%n", business.getTotalEmployeeSalary());
		outSavedGame.printf("%f%n", business.getBuildingMaintenance());
		outSavedGame.printf("%d%n", business.getBusinessAge());
		
		// Saving Employees (NO of employees and their names)
		outSavedGame.printf("%d%n", employees.size());
		
		for(int i = 0; i < employees.size(); i++)
		{
			outSavedGame.printf("%s%n", employees.get(i));
		} // for
		
		// Saving Dealers (NO of dealers and their names)
		outSavedGame.printf("%d%n", dealers.size());
		
		for(int i = 0; i < dealers.size(); i++)
		{
			outSavedGame.printf("%s%n", dealers.get(i));
		} // for
		
		// Saving Game Info
		outSavedGame.printf("%s%n", gameManager.getGameDifficulty());
			
		outSavedGame.close();
	} // saveGame()
	
	public static void loadGame(Player player, Business business, GameManager gameManager, 
			List<Employee> employees, List<Employee> dealers) throws IOException
	{	
		gameManager.setIsGameLoaded(false);
		Scanner inSavedGame = new Scanner(new FileReader("SavedGame.txt"));
		
		// before loading a save file, the current values for employees and dealers must be cleared
		employees.clear();
		dealers.clear();
		
		// to make sure the file loads the right values (in case file was edited)	
		// try to load them, if it fails, set values
		
		try
		{
			// Loading players state from save file
			player.setName(inSavedGame.nextLine());	
			player.setTraits(0, inSavedGame.nextLine());
			player.setTraits(1, inSavedGame.nextLine()); 
			player.setTraits(2, inSavedGame.nextLine()); 
			player.setTraits(3, inSavedGame.nextLine()); 
			player.setTraits(4, inSavedGame.nextLine()); 
			player.setBankAccount(inSavedGame.nextFloat());

			// Loading business' state from save file
			inSavedGame.nextLine(); // Flush the buffer
			business.setName(inSavedGame.nextLine());
			business.setBankAccount(inSavedGame.nextFloat());
			business.setGoodReputation(inSavedGame.nextInt());
			business.setBadReputation(inSavedGame.nextInt());
			business.setBuildingSize(inSavedGame.nextInt());
			business.setEmployeeSalary(inSavedGame.nextFloat());
			business.setTotalEmployeeSalary(inSavedGame.nextFloat());
			business.setBuildingMaintenance(inSavedGame.nextFloat());
			business.setBusinessAge(inSavedGame.nextInt());

			// Loading Employees (NO of employees and their names)
			int eSize=0;
			int i=0;
			
			eSize = inSavedGame.nextInt(); // getting the no of employees
		
			while(inSavedGame.hasNextLine() && i < eSize)
			{
				inSavedGame.nextLine(); // Flush the buffer
				for(i = 0; i < eSize; i++)
				{	
					Employee employee = new Employee(); // create employee
					employee.setName(inSavedGame.nextLine()); // set their name
					employees.add(employee);
				}
			} // while
			
			// Loading Dealers (NO of dealers and their names)
			int dSize=0;
			int j=0;

			dSize = inSavedGame.nextInt(); // getting the no of dealers
	
			while(inSavedGame.hasNextLine() && j < dSize)
			{
				inSavedGame.nextLine(); // Flush the buffer
				for(j = 0; j < dSize; j++)
				{
					Dealer dealer = new Dealer(); // create dealer
					dealer.setName(inSavedGame.nextLine()); // set their name
					dealers.add(dealer);
				} // for
			} // while
			
			// Loading Game Info
			gameManager.setGameDifficulty(inSavedGame.next());

			// saying the game loaded
			gameManager.setIsGameLoaded(true);
			System.out.println("Loading Game!");
	
			inSavedGame.close();
		}
		catch(Exception e)
		{
			inSavedGame.close();
			
			// saying game didn't load
			gameManager.setIsGameLoaded(false);
			
			System.out.println("A Saved Game Couldn't Be Loaded!");
			
			// set all the values being loaded back to default
			
			// Set default business states
			business.setGoodReputation(25);
			business.setBadReputation(0);
			business.setBuildingSize(3);
			business.setEmployeeSalary(800);
			business.setTotalEmployeeSalary(0);
			business.setBuildingMaintenance(1000);
			business.setBusinessAge(0);
			
			// set employees and dealers back to default
			employees.clear();
			dealers.clear();
		} // try catch
	} // loadGame()

} // Class MainClass
