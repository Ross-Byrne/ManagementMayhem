package GameFiles;

public class Employee extends Person {

	// Constructors
	public Employee()
	{	
	} // default Constructor
	
	public Employee(String theName) 
	{
		setName(theName);
	}
	
	// Methods
	public void setName(String theName)
	{
		name = theName;
	} // setName()
	
	public String getName()
	{
		return name;
	} // getName()
	
	public String toString()
	{
		return getName();
	} // toString()

} // Class Employee
