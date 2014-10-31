package GameFiles;

public class Dealer extends Person {

	// Constructors
	public Dealer()
	{	
	} // default Constructor
	
	public Dealer(String theName) 
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


} // Class Dealer
