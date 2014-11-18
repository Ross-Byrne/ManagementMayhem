package gamefiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* This class handles all the info about the player's business. */

public class Business {
	
	// Member Variables
	public String name;
	public float bankAccount;
	public int goodReputation;
	public int badReputation;
	public int buildingSize; // no. of rooms
	public float buildingUpgradeCost;
	public float buildingMaintenance;
	public int maxEmployees;
	public int maxDealers;
	public float employeeSalary; // Per Month
	public float totalEmployeeSalary;
	public int businessAge; // in months
	public int productivityBonus;
	public int equipmentUpgrades; // + 10% productivity bonus per upgrade
	public float equipmentUpgradeCost;
	public float moneyEarned;
	
	// Employees
	List<Employee> employees = new ArrayList<Employee>();
	// Polymorphism
	List<Employee> dealers = new ArrayList<Employee>();
	
	public Business()
	{
		setName("");
		setBankAccount(0);
		setGoodReputation(25); // 25 because of 1000 for maintenance
		setBadReputation(25); // because salary is 800
		setBuildingSize(3);
		setBuildingUpgradeCost(getBuildingSize() *1000);
		setBuildingMaintenance(1000); // medium maintenance level
		setMaxEmployees(0);
		setEmployeeSalary(800);
		setBusinessAge(0);
		setProductivityBonus(0);
		setEquipmentUpgrades(0);
	} // default constructor
	
	// Get and Set Methods
	public void setName(String theName)
	{
		name = theName;
	} // setName()
	
	public String getName()
	{
		return name;
	} // getName()
	
	public void setBankAccount(float theAccount)
	{
		bankAccount = theAccount;
	} // setBankAccount()
	
	public float getBankAccount()
	{
		return bankAccount;
	} // getBankAccount()
	
	public void setGoodReputation(int goodRep)
	{
		goodReputation = goodRep;
	} // setGoodReputation()
	
	public int getGoodReputation()
	{
		return goodReputation;
	} // getGoodReputation()
	
	public void setBadReputation(int badRep)
	{
		badReputation = badRep;
	} // setBadReputation()
	
	public int getBadReputation()
	{
		return badReputation;
	} // getBadReputation()
	
	public void setBuildingSize(int theSize)
	{
		buildingSize = theSize;
	} // setBuildingSize()
	
	public int getBuildingSize()
	{
		return buildingSize;
	} // getBuildingSize()
	
	public void setBuildingUpgradeCost(float theCost)
	{
		buildingUpgradeCost = theCost;
	} // setBuildingUpgradeCost()
	
	public float getBuildingUpgradeCost()
	{
		setBuildingUpgradeCost(getBuildingSize() * 1000);
		return buildingUpgradeCost;
	} // getBuildingUpgradeCost()
	
	public void setBuildingMaintenanceLevel(int theLevel)
	{
		float oldMaintenanceCost=0;
		oldMaintenanceCost = getBuildingMaintenance(); // to make sure player doesn't keep changing 
														// maintenance to endless get reputation
		if(oldMaintenanceCost == 0)
		{
			setBadReputation(getBadReputation() - 50);
		}
		else if(oldMaintenanceCost == 500)
		{
			setBadReputation(getBadReputation() - 25);
		}
		else if(oldMaintenanceCost == 1000)
		{
			setGoodReputation(getGoodReputation() - 25);
		}
		else if(oldMaintenanceCost == 1500)
		{
			setGoodReputation(getGoodReputation() - 50);
		} // if
		
		switch(theLevel)
		{
		case 1: // no maintenance
			setBuildingMaintenance(0); // sets maintenance cost
			setBadReputation(getBadReputation() + 50); // get +50 bad rep
			break;
		case 2: // low maintenance
			setBuildingMaintenance(500); // sets maintenance cost
			setBadReputation(getBadReputation() + 25); // get +25 bad rep
			break;
		case 3: // medium maintenance
			setBuildingMaintenance(1000); // sets maintenance cost
			setGoodReputation(getGoodReputation() + 25); // get +25 good rep
			break;
		case 4: // high maintenance
			setBuildingMaintenance(1500); // sets maintenance cost
			setGoodReputation(getGoodReputation() + 50); // get +50 good rep
			break;
		} // switch
	} // setBuildingMaintenanceLevel()
	
	public void setBuildingMaintenance(float theCost)
	{
		buildingMaintenance = theCost;
	} // setBuildingMaintenance()
	
	public float getBuildingMaintenance()
	{
		return buildingMaintenance;
	} // getBuildingMaintenance()
	
	public void setMaxEmployees(int theAmount)
	{
		maxEmployees = theAmount;
	} // setMaxEmployees()
	
	public int getMaxEmployees()
	{
		// the maximum number of employees the business can have
		// is 5 employees per room
		setMaxEmployees(getBuildingSize() * 5);
		return maxEmployees;
	} // getMaxEmployees()
	
	public void setMaxDealers(int theAmount)
	{
		maxDealers = theAmount;
	} // setMaxDealers()
	
	public int getMaxDealers()
	{
		// the maximum number of dealers the business can have
		// is 1 dealer per room
		setMaxDealers(getBuildingSize());
		return maxDealers;
	} // getMaxDealers()
	
	public void setEmployeeSalaryLevel(int theLevel)
	{
		float oldSalary=0;
		oldSalary = getEmployeeSalary(); // to make sure player doesn't keep changing 
										// Salary to endless get reputation
		if(oldSalary == 400)
		{
			setBadReputation(getBadReputation() - 50);
		}
		else if(oldSalary == 800)
		{
			setBadReputation(getBadReputation() - 25);
		}
		else if(oldSalary == 1000)
		{
			setGoodReputation(getGoodReputation() - 25);
		}
		else if(oldSalary == 1200)
		{
			setGoodReputation(getGoodReputation() - 50);
		} // if
		
		switch(theLevel)
		{
		case 1: // Low
			setEmployeeSalary(400); // sets Salary
			setBadReputation(getBadReputation() + 50); // get +50 bad rep
			break;
		case 2: // medium
			setEmployeeSalary(800);
			setBadReputation(getBadReputation() + 25); // get +25 bad rep
			break;
		case 3: // good
			setEmployeeSalary(1000);
			setGoodReputation(getGoodReputation() + 25); // get +25 good rep
			break;
		case 4: // Great
			setEmployeeSalary(1200);
			setGoodReputation(getGoodReputation() + 50); // get +50 good rep
			break;
		} // switch
	} // setEmployeeSalaryLevel()
	
	// to set Salary Directly
	public void setEmployeeSalary(float theSalary)
	{
		employeeSalary = theSalary;
	} // setEmployeeSalary()
	
	public float getEmployeeSalary()
	{
		return employeeSalary;
	} // getEmployeeSalary()
	
	public void setTotalEmployeeSalary(float totalSalary)
	{
		totalEmployeeSalary = totalSalary;
	} // setTotalEmployeeSalary()
	
	// the total salary is calculated
	// using employeeSalary * the number of employees
	public float getTotalEmployeeSalary()
	{
		setTotalEmployeeSalary((employees.size() * getEmployeeSalary()));
		
		return totalEmployeeSalary;
	} // getTotalEmployeeSalary()
	
	public void setBusinessAge(int theAge)
	{
		businessAge = theAge;
	} // setBusinessAge()
	
	public int getBusinessAge()
	{
		return businessAge;
	} // getBusinessAge()
	
	public void setProductivityBonus(int theBonus)
	{
		productivityBonus = theBonus;
	} // setProductivityBonus()
	
	public int getProductivityBonus()
	{
		int bonus = 0;
		
		bonus += employees.size() * (getGoodReputation() / 5); // adds 1% bonus for each 5 good rep, per employee
		
		bonus -= employees.size() * (getBadReputation() / 5); // adds -1% bonus for each 5 Bad Rep, per employee

		bonus += (getEquipmentUpgrades() * 10); // Adds 10% bonus for each equipment upgrade
		
		setProductivityBonus(bonus);
		
		return productivityBonus;
	} // getProductivityBonus()
	
	public void setEquipmentUpgrades(int theNumber)
	{
		equipmentUpgrades = theNumber;
	} // setEquipmentUpgrades()
	
	public int getEquipmentUpgrades()
	{
		return equipmentUpgrades;
	} // getEquipmentUpgrades()
	
	public void setEquipmentUpgradeCost(float theAmount)
	{
		equipmentUpgradeCost = theAmount;
	} // setEquipmentUpgradeCost()
	
	public float getEquipmentUpgradeCost()
	{
		// the equipment upgrades +1 is to get the cost of the next upgrade, not the number 
		// of upgrades the business already has.
		setEquipmentUpgradeCost((getEquipmentUpgrades() + 1) * 20000); // each upgrade cost 20000 more then the last
		return equipmentUpgradeCost;
	} // getEquipmentUpgradeCost()
	
	public void setMoneyEarned(float theAmount)
	{
		moneyEarned = theAmount;
	} // setMoneyEarned()
	
	public float getMoneyEarned()
	{
		return moneyEarned;
	} // getMoneyEarned()
	
	// Other Methods
	
	// generates money for business
	// by producing products + selling them
	public void produceProducts()
	{
		float bonus = 0;
		
		setMoneyEarned(employees.size() * 1000); // business makes €1000 per employee a month
		
		bonus = ((float)getProductivityBonus() / 100); // getting the productivity bonus %
		
		setMoneyEarned(getMoneyEarned() + (getMoneyEarned() * bonus)); // Adding the productivity bonus on to money earned
		
		setBankAccount(getBankAccount() + getMoneyEarned()); // adds money earned into bank account
	} // produceProducts()
	
	public void sellDrugs(Player player)
	{
		setMoneyEarned(dealers.size() * 500);
		
		setBankAccount(getBankAccount() + (getMoneyEarned() / 2)); // half goes to business
		player.setBankAccount(player.getBankAccount() + (getMoneyEarned() / 2)); // half goes to the player
	} // sellDrugs()
	
	// pays employees for the month
	public void payEmployees() throws BankAccountBalanceException
	{
		if(getTotalEmployeeSalary() > getBankAccount())
		{
			throw new BankAccountBalanceException("\n\n\t\t\tInsufficient Bank Account Funds!");
		}
		// takes the total salary out of the business bank account
		setBankAccount((getBankAccount() - getTotalEmployeeSalary()));
	} // payEmployees()
	
	public void payEmployeesAnyway()
	{
		// takes the total salary out of the business bank account
		// Even when the business is in debt
		setBankAccount((getBankAccount() - getTotalEmployeeSalary()));
	} // payEmployeesAnyway()
	
	public void hireEmployees(GameManager gameManager, int theAmount)
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
	
	public void fireEmployees(GameManager gameManager, int theAmount)
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
	
	public void printListOfEmployees()
	{
		String tempNames = "";
		
		for(int i = 0; i < employees.size(); i++)
			tempNames += "\n\t" + employees.get(i);
		
		System.out.println("Employees: " + tempNames);
	} // printListOfEmployees()
	
	public void hireDealers(GameManager gameManager, int theAmount)
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
	
	public void fireDealers(GameManager gameManager, int theAmount)
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
	
	public void printListOfDealers()
	{
		String tempNames = "";
		
		for(int i = 0; i < dealers.size(); i++)
			tempNames += "\n\t" + dealers.get(i);
		
		System.out.println("Dealers: " + tempNames);
	} // printListOfDealers()
	
	// to pay the buildings monthly maintenance bill
	public void payMaintenance() throws BankAccountBalanceException
	{
		if(getBuildingMaintenance() > getBankAccount())
		{
			throw new  BankAccountBalanceException("\n\n\t\t\tInsufficient Bank Account Funds!");
		}
		// takes the Maintenance out of the business bank account
		setBankAccount((getBankAccount() - getBuildingMaintenance()));
	} // payMaintenance()
	
	public void upgradeBuilding() throws BankAccountBalanceException
	{
		if(getBuildingUpgradeCost() > getBankAccount())
		{
			throw new BankAccountBalanceException("\n\n\t\t\tInsufficient Bank Account Funds!");
		} // if
		
		setBuildingSize(getBuildingSize() + 1); // increase building size by 1
	
		setBankAccount(getBankAccount() - getBuildingUpgradeCost());
	} // upgradeBuilding()
	
	public void upgradeEquipment() throws BankAccountBalanceException
	{
		if(getEquipmentUpgradeCost() > getBankAccount())
		{
			throw new BankAccountBalanceException("\n\n\t\t\tInsufficient Bank Account Funds!");
		} // if
		
		setEquipmentUpgrades(getEquipmentUpgrades() + 1); // increase equipment upgrades by 1
	
		setBankAccount(getBankAccount() - getEquipmentUpgradeCost());
	} // upgradeEquipment()
	
	public void buildDrugLab() throws BankAccountBalanceException
	{
		if(getBankAccount() < 50000)
		{
			throw new BankAccountBalanceException("\n\n\t\t\tInsufficient Bank Account Funds!");
		} // if
		
		setBankAccount(getBankAccount() - 50000); // cost 50000 to build a lab
		
	} // buildDrugLab()
	
	public String displayBusinessInfo()
	{
		String str="";
		
		str += "\nName: " + getName() +
				"\nBusiness Age: " + getBusinessAge() + " Months" +
				"\nBank Account: €" + getBankAccount() +
				"\nGood Reputation: " + getGoodReputation() +
				"\nBad Reputation: " + getBadReputation() +
				"\nRooms In The Building: " + getBuildingSize() +
				"\nBuilding Maintenance: €" + getBuildingMaintenance() +
				"\nEmployee Salary Per Month: €" + getEmployeeSalary() +
				"\nBusiness Productivity Bonus: " + getProductivityBonus() + "%" +
				"\nBusiness Equipment Upgrades: " + getEquipmentUpgrades();
		
		
		return str;
	} // displayBusinessInfo()

} // Class
