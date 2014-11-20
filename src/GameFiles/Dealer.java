// Ross Byrne 2014
// Second Year Java Project

package gamefiles;

public class Dealer extends Employee {

	// Constructors
	public Dealer()
	{	
	} // default Constructor
	
	public Dealer(String theName) 
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
	
	public String toString() // used when saving dealers
	{
		return getName();
	} // toString()

} // Class 
