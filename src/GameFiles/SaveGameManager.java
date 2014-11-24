// Ross Byrne 2014
// Second Year Java Project

package gamefiles;

import java.io.*;
import java.util.Scanner;

/* Class to manage the saving and loading of the game */

public class SaveGameManager {
	
	/*===================== saveGame() =====================================================================================*/
	
	// Saves The Player's Game
	public void saveGame(Player player, Business business, GameManager gameManager) throws IOException
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
		outSavedGame.printf("%d%n", business.getEquipmentUpgrades());
		
		// Saving Employees (NO of employees and their names)
		outSavedGame.printf("%d%n", business.employees.size());
		
		for(int i = 0; i < business.employees.size(); i++)
		{
			outSavedGame.printf("%s%n", business.employees.get(i));
		} // for
		
		// Saving Dealers (NO of dealers and their names)
		outSavedGame.printf("%d%n", business.dealers.size());
		
		for(int i = 0; i < business.dealers.size(); i++)
		{
			outSavedGame.printf("%s%n", business.dealers.get(i));
		} // for
		
		// Saving Game Info
		outSavedGame.printf("%s%n", gameManager.getGameDifficulty());
		outSavedGame.printf("%s%n", gameManager.getCanStartSellingDrugs());
		outSavedGame.printf("%s%n", gameManager.getCanStartMakingDrugs());
			
		outSavedGame.close();
	} // saveGame()
	
	/*===================== loadGame() =====================================================================================*/
	
	// Loads The Player's Game
	public void loadGame(Player player, Business business, GameManager gameManager) throws IOException
	{	
		gameManager.setIsGameLoaded(false);
		Scanner inSavedGame = new Scanner(new FileReader("SavedGame.txt"));
		
		// before loading a save file, the current values for employees and dealers must be cleared
		business.employees.clear();
		business.dealers.clear();
		
		// setting other values to default
		gameManager.setAppliedForGrant(false);
		gameManager.setCanStartSellingDrugs(false);
		
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
			business.setEquipmentUpgrades(inSavedGame.nextInt());

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
					business.employees.add(employee);
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
					business.dealers.add(dealer);
				} // for
			} // while
			
			// Loading Game Info
			gameManager.setGameDifficulty(inSavedGame.next());
			gameManager.setCanStartSellingDrugs(inSavedGame.nextBoolean());
			gameManager.setCanStartMakingDrugs(inSavedGame.nextBoolean());

			// saying the game loaded
			gameManager.setIsGameLoaded(true);
			System.out.println("Loading Game!");
	
			inSavedGame.close();
		}
		catch(Exception e) // if loading fails, say so and set everything to default
		{
			inSavedGame.close();
			
			// saying game didn't load
			gameManager.setIsGameLoaded(false);
			
			System.out.println("A Saved Game Couldn't Be Loaded!");
			
			// set all the values being loaded back to default
			
			// Set default business states
			business.setGoodReputation(25);
			business.setBadReputation(25);
			business.setBuildingSize(3);
			business.setEmployeeSalary(800);
			business.setTotalEmployeeSalary(0);
			business.setBuildingMaintenance(1000);
			business.setBusinessAge(0);
			business.setEquipmentUpgrades(0);
			business.employees.clear();
			business.dealers.clear();
		} // try catch
	} // loadGame()

} // Class
