// Ross Byrne 2014
// Second Year Java Project

package gamefiles;

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
	
	public String toString() // used when saving employees
	{
		return getName();
	} // toString()

} // Class
