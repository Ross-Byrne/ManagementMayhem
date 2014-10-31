package GameFiles;

public abstract class Person {
	
	// Variables
	String name;
	
	// Constructors
	public Person()
	{
	}
	
	public Person(String theName)
	{
		name = theName;
	}
	
	// Methods
	public void setName(String theName)
	{
		name = theName;
	} // SetName()
	
	public String getName()
	{
		return name;
	} // getName()


} // Class Person
