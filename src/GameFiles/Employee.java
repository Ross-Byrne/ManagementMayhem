// Ross Byrne 2014
// Second Year Java Project

package gameFiles;

public class Employee extends Person { // extends Person Class

	/*===================== Constructors =====================================================================================*/
	
	public Employee()
	{	
	} // default Constructor
	
	public Employee(String theName) 
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
	
	public String toString() // used when saving employees
	{
		return getName();
	} // toString()

} // Class
