package GameFiles;

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
	public float employeeSalary; // Per Month
	public float totalEmployeeSalary;
	public int businessAge; // in months
	
	public Business()
	{
		setName("");
		setBankAccount(0);
		setGoodReputation(25); // 25 because of 1000 for maintenance
		setBadReputation(0);
		setBuildingSize(3);
		setBuildingUpgradeCost(getBuildingSize() *1000);
		setBuildingMaintenance(1000); // medium maintenance level
		setMaxEmployees(0);
		setEmployeeSalary(800);
		setBusinessAge(0);
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
	
	public float getTotalEmployeeSalary()
	{
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
	
	// Other Methods
	
	// The number of employees the business has in entered
	// the total salary is calculated
	// using employeeSalary * the number of employees
	public void payEmployees(int noEmployees) throws BankAccountBalanceException
	{
		setTotalEmployeeSalary((noEmployees * getEmployeeSalary()));
		if(getTotalEmployeeSalary() > getBankAccount())
		{
			throw new BankAccountBalanceException("\nInsufficient Bank Account Funds.");
		}
		// takes the total salary out of the business bank account
		setBankAccount((getBankAccount() - getTotalEmployeeSalary()));
	} // payEmployees()
	
	public void payEmployeesAnyway(int noEmployees)
	{
		setTotalEmployeeSalary((noEmployees * getEmployeeSalary()));
		
		// takes the total salary out of the business bank account
		setBankAccount((getBankAccount() - getTotalEmployeeSalary()));
	} // payEmployeesAnyway()
	
	// to pay the buildings monthly maintenance bill
	public void payMaintenance() throws BankAccountBalanceException
	{
		if(getBuildingMaintenance() > getBankAccount())
		{
			throw new  BankAccountBalanceException("\nInsufficient Bank Account Funds.");
		}
		// takes the Maintenance out of the business bank account
		setBankAccount((getBankAccount() - getBuildingMaintenance()));
	} // payMaintenance()
	
	public void upgradeBuilding() throws BankAccountBalanceException
	{
		if(getBuildingUpgradeCost() > getBankAccount())
		{
			throw new BankAccountBalanceException("\nInsufficient Bank Account Funds.");
		} // if
		
		setBuildingSize(getBuildingSize() + 1); // increase building size by 1
	
		setBankAccount(getBankAccount() - getBuildingUpgradeCost());
	} // upgradeBuilding()
	
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
				"\nEmployee Salary Per Month: €" + getEmployeeSalary();
		
		return str;
	} // displayBusinessInfo()

}
