package GameFiles;

/* This class handles all the info about the player's business. */

public class Business {
	
	// Member Variables
	public String name;
	public float bankAccount;
	public int goodReputation;
	public int badReputation;
	public int buildingSize; // no. of rooms
	public float employeeSalary; // Per Month
	public float totalEmployeeSalary;
	
	public Business()
	{
		setName("");
		setBankAccount(0);
		setGoodReputation(0);
		setBadReputation(0);
		setBuildingSize(5);
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
	public void payEmployees(int noEmployees)
	{
		setTotalEmployeeSalary((noEmployees * getEmployeeSalary()));
		
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
				"\nEmployee Salary Per Month: " + getEmployeeSalary() +
				"\nTotal Salary Paid Per Month: " + getTotalEmployeeSalary();
		
		return str;
	} // displayBusinessInfo()

}
