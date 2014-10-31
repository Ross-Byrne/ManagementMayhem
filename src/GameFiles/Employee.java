package GameFiles;

public class Employee extends Person {

	// Constructors
	public Employee()
	{	
	} // default Constructor
	
	public Employee(String theName) 
	{
		super(theName);
	}
	
	// Methods
	public void setName(String theName)
	{
		super.setName(theName);
	} // setName()
	
	public String getName()
	{
		return super.getName();
	} // getName()
	
	public String toString()
	{
		return getName();
	} // toString()

} // Class Employee
