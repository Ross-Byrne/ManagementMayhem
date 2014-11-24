// Ross Byrne 2014
// Second Year Java Project

package gamefiles;

public class Dealer extends Employee { // extends Employee Class

	/*===================== Constructors =====================================================================================*/
	
	public Dealer()
	{	
	} // default Constructor
	
	public Dealer(String theName) 
	{
		setName(theName);
	}
	
	/*===================== Get and Set Methods =====================================================================================*/
	
	/*===================== get/setName() =====================================================================================*/
	
	public void setName(String theName)
	{
		name = theName;
	} // setName()
	
	public String getName()
	{
		return name;
	} // getName()
	
	/*===================== Other Methods =====================================================================================*/
	
	/*===================== toString() =====================================================================================*/
	
	public String toString() // used when saving dealers
	{
		return getName();
	} // toString()

} // Class 
