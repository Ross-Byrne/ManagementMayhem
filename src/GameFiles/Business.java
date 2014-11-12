package GameFiles;

/* This class handles all the info about the player's business. */

public class Business {
	
	// Member Variables
	public String name;
	public float bankAccount;
	public int goodReputation;
	public int badReputation;
	public int buildingSize; // no. of rooms
	public int maxEmployees;
	public float employeeSalary; // Per Month
	public float totalEmployeeSalary;
	
	public Business()
	{
		setName("");
		setBankAccount(0);
		setGoodReputation(0);
		setBadReputation(0);
		setBuildingSize(3);
		setMaxEmployees(0);
		setEmployeeSalary(800);
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
	
	// Other Methods
	
	// The number of employees the business has in entered
	// the total salary is calculated
	// using employeeSalary * the number of employees
	public void payEmployees(int noEmployees) throws Exception
	{
		setTotalEmployeeSalary((noEmployees * getEmployeeSalary()));
		if(getTotalEmployeeSalary() > getBankAccount())
		{
			throw new Exception("Cannot Pay Total Salary of " + getTotalEmployeeSalary() + ". Not Enough Funds.");
		}
		// takes the total salary out of the business bank account
		setBankAccount((getBankAccount() - getTotalEmployeeSalary()));
	} // payEmployees()
	
	public String displayBusinessInfo()
	{
		String str="";
		
		str += "\nName: " + getName() +
				"\nBank Account: " + getBankAccount() +
				"\nGood Reputation: " + getGoodReputation() +
				"\nBad Reputation: " + getBadReputation() +
				"\nRooms In The Building: " + getBuildingSize() +
				"\nEmployee Salary Per Month: " + getEmployeeSalary();
		
		return str;
	} // displayBusinessInfo()

}
