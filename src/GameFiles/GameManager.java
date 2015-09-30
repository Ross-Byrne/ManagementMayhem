// Ross Byrne 2014
// Second Year Java Project

package gameFiles;

/* This class manages certain parts of the game */

public class GameManager {
	
	/*===================== Member Variables =====================================================================================*/
	
	private String gameDifficulty;
	private boolean isCharacterCreated = false;
	private boolean isBusinessSetup = false;
	private boolean isNewGameCreated = false;
	private boolean isGameLoaded = false;
	private boolean canHireDealers = false;
	private boolean canBuildDrugLab = false;
	private boolean canStartSellingDrugs = false;
	private boolean canStartMakingDrugs = false;
	private boolean appliedForGrant = false;
	private String[] playerTraitsSelection = { 	"People Person", "Marketing Master", "Organiser", "Opportunist", "Charming",
												"Greedy", "Spitful", "Alcoholic", "Reckless", "Seedy"};
	
	private String[] randomFName = {		"John", "Mike", "Carl", "Jim", "Conor", "Bob", "Tom",
										"Rachael", "Samantha", "Mary", "Ciara", "Jennifer", "Jane", "Sarah"};
	
	private String[] randomLName = {		" Power", " Sullivan", " Smith", " McCarthy", " White", " Rodrigue", " Jones",
										" Browne", " Butler", " Byrne", " Daly", " Kelly", " Harrington", " Jameson"};
	
	/*===================== Get and Set Methods =====================================================================================*/
	
	/*===================== get/setGameDifficulty() =====================================================================================*/
	
	public void setGameDifficulty(String theDif)
	{
		gameDifficulty = theDif;
	} // setGameDifficulty
	
	public String getGameDifficulty()
	{
		return gameDifficulty;
	} // getGameDifficulty
	
	/*===================== get/setIsCharacterCreated() =====================================================================================*/
	
	public void setIsCharacterCreated(boolean isItCreated)
	{
		isCharacterCreated = isItCreated;
	} // setIsCharacterCreated()
	
	public boolean getIsCharacterCreated()
	{
		return isCharacterCreated;
	} // getIsCharacterCreated()
	
	/*===================== get/setIsBusinessSetup() =====================================================================================*/
	
	public void setIsBusinessSetup(boolean isItSetup)
	{
		isBusinessSetup = isItSetup;
	} // setIsBusinessSetup()
	
	public boolean getIsBusinessSetup()
	{
		return isBusinessSetup;
	} // getIsBusinessSetup()
	
	/*===================== get/setIsNewGameCreated() =====================================================================================*/
	
	public void setIsNewGameCreated(boolean isItCreated)
	{
		isNewGameCreated = isItCreated;
	} // setIsNewGameCreated()
	
	public boolean getIsNewGameCreated()
	{
		return isNewGameCreated;
	} // getIsNewGameCreated()
	
	/*===================== get/setIsGameLoaded() =====================================================================================*/
	
	public void setIsGameLoaded(boolean isItLoaded)
	{
		isGameLoaded = isItLoaded;
	} // setIsGameLoaded()
	
	public boolean getIsGameLoaded()
	{
		return isGameLoaded;
	} // getIsGameLoaded()
	
	/*===================== get/setCanHireDealers() =====================================================================================*/
	
	public void setCanHireDealers(boolean canHire)
	{
		canHireDealers = canHire;
	} // setCanHireDealers()
	
	public boolean getCanHireDealers()
	{
		return canHireDealers;
	} // getCanHireDealers()
	
	/*===================== get/setCanBuildDrugLab() =====================================================================================*/
	
	public void setCanBuildDrugLab(boolean canBuild)
	{
		canBuildDrugLab = canBuild;
	} // setCanBuildDrugLab()
	
	public boolean getCanBuildDrugLab()
	{
		return canBuildDrugLab;
	} // getCanBuildDrugLab()
	
	/*===================== get/setCanStartSellingDrugs() =====================================================================================*/
	
	public void setCanStartSellingDrugs(boolean canSell)
	{
		canStartSellingDrugs = canSell;
	} // setCanStartSellingDrugs()
	
	public boolean getCanStartSellingDrugs()
	{
		return canStartSellingDrugs;
	} // getCanStartSellingDrugs()
	
	/*===================== get/setCanStartMakingDrugs() =====================================================================================*/
	
	public void setCanStartMakingDrugs(boolean canMake)
	{
		canStartMakingDrugs = canMake;
	} // setCanStartMakingDrugs()
	
	public boolean getCanStartMakingDrugs()
	{
		return canStartMakingDrugs;
	} // getCanStartMakingDrugs()
	
	/*===================== get/setAppliedForGrant() =====================================================================================*/
	
	public void setAppliedForGrant(boolean applied)
	{
		appliedForGrant = applied;
	} // setAppliedForGrant()
	
	public boolean getAppliedForGrant()
	{
		return appliedForGrant;
	} // getAppliedForGrant()
	
	/*===================== getPlayerTraitsSelection() =====================================================================================*/
	
	public String getPlayerTraitsSelection(int index)
	{	
		return playerTraitsSelection[index];
	} // getPlayerTraitsSelection()
	
	/*===================== getPlayerTraitsSelectionLength() =====================================================================================*/
	
	public int getPlayerTraitsSelectionLength()
	{	
		int length;
		
		length = playerTraitsSelection.length;
		return length;
	} // getPlayerTraitsSelectionLength()
	
	/*===================== getRandomFName() =====================================================================================*/
	
	public String getRandomFName(int index)
	{	
		return randomFName[index];
	} // getRandomFName()
	
	/*===================== getRandomLName() =====================================================================================*/
	
	public String getRandomLName(int index)
	{	
		return randomLName[index];
	} // getRandomLName()
	
	/*===================== Other Methods =====================================================================================*/
	
	/*===================== CheckBadReputation() =====================================================================================*/
	
	// checks if player can do bad things because of bad rep level
	public void checkBadReputation(Business business)
	{
		if(business.getBadReputation() > 39) // if at least 40 bad rep
		{
			setCanHireDealers(true);
		}
		else
		{
			// if you cant sell, you cant hire and all dealers a fired
			setCanHireDealers(false);
			setCanStartSellingDrugs(false);
			business.dealers.clear();
		} // if
		
		if(business.getBadReputation() > 59) // if at least 60 bad rep
		{
			setCanBuildDrugLab(true);
		}
		else
		{
			setCanBuildDrugLab(false);
		} // if
		
	} // checkBadReputation()
	
} // Class
