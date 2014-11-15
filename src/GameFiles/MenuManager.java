package GameFiles;

/* Class To Manage all the Menus in the game */

public class MenuManager {
	
	public void printGameInfo()
	{
		System.out.println("\nWelcome to Management Mayhem!\n"
				+ "As the sole owner and manager of your business,\n"
				+ "it is your duty to keep it running at all costs.\n");
	} // printGameInfo()
	
	public void printMainMenu()
	{
		System.out.println("\n\t\t\tMain Menu\n");
		System.out.println("\t\t\t1.) Start New Game.");
		System.out.println("\t\t\t2.) Load Game.");
		System.out.println("\t\t\t3.) Delete Game Save.");
		System.out.println("\t\t\t4.) About Game.");
		System.out.println("\t\t\t5.) Exit.\n");
	} // printMainMenu()
	
	public void printCharacterCreateMenu()
	{
		System.out.println("\n\t\t\tBoth Fields Must Be Complete!\n");
		System.out.println("\t\t\t1.) Name Your Character.");
		System.out.println("\t\t\t2.) Select 5 Character Traits.");	
		System.out.println("\t\t\t3.) Back To Main Menu.");
	} // printCharacterCreateMenu()
	
	public void printBusinessSetupMenu()
	{
		System.out.println("\n\t\t\tAll Fields Must Be Complete!\n");
		System.out.println("\t\t\t1.) Name Your Business.");	
		System.out.println("\t\t\t2.) Back To Main Menu.");
	} // printBusinessSetupMenu()
	
	public void printMainGameMenu()
	{
		System.out.println("\n\t\t\tMain Game Menu\n");
		System.out.println("\t\t\t1.) Play Game.");
		System.out.println("\t\t\t2.) Save Game");
		System.out.println("\t\t\t3.) Load Game.");
		System.out.println("\t\t\t4.) Delete Game.");
		System.out.println("\t\t\t5.) Exit Game.\n");
	} // printMainGameMenu()
	
	public void printGameOptionsMenu()
	{
		System.out.println("\n\t\t\tOptions\n");
		System.out.println("\t\t\t1.) Continue Playing.");
		System.out.println("\t\t\t2.) Show Player Status.");
		System.out.println("\t\t\t3.) Show Business Status.");
		System.out.println("\t\t\t4.) Manage The Business.");
		System.out.println("\t\t\t5.) Back To Main Game Menu.\n");
	} // printGameMenu()
	
	public void printManageBusinessMenu()
	{
		System.out.println("\n\t\t\tManage The Business\n");
		System.out.println("\t\t\t1.) Manage Employees.");
		System.out.println("\t\t\t2.) Manage The Building.");
		System.out.println("\t\t\t3.) Manage Operations.");
		System.out.println("\t\t\t4.) Show Profits/Expenses.");
		System.out.println("\t\t\t5.) Back To Game Menu.\n");
	} // printManageBusinessMenu()
	
	public void printManageEmployeesMenu()
	{
		System.out.println("\n\t\t\tManage Employees\n");
		System.out.println("\t\t\t1.) Hire Employees.");
		System.out.println("\t\t\t2.) Fire Employees.");
		System.out.println("\t\t\t3.) View List Of your Employees.");
		System.out.println("\t\t\t4.) Back To Manage The Business.");
	} // printManageEmployeesMenu()
	
	public void printManageTheBuildingMenu()
	{
		System.out.println("\n\t\t\tManage The Building\n");
		System.out.println("\t\t\t1.) Upgrade Size Of Building.");
		System.out.println("\t\t\t2.) Set Maintenance Level.");
		System.out.println("\t\t\t3.) Back To Manage The Business.");
	} // printManageTheBuildingMenu()
	
	public void printSetMaintenanceLevelMenu()
	{
		System.out.println("\n\n\t\t\tSet Level Of Maintenance Your Building Gets.");
		System.out.println("\n\t\t\t1.) None - �0.");
		System.out.println("\t\t\t2.) Low - �500.");
		System.out.println("\t\t\t3.) Medium - �1000.");
		System.out.println("\t\t\t4.) High - �1500.");
		System.out.println("\t\t\t5.) Back To Manage The Business.");
	} // printSetMaintenanceLevelMenu()
	
	public void printGameOverMessage()
	{
		System.out.println("\n\n\t\t\tYou Are Now �10,000 In Debt!");
		System.out.println("\t\t\tAs You Have Proven To Be Unable To Pay The Bank Back");
		System.out.println("\t\t\tThe Bank Is Liquidating Your Business!");
		System.out.println("\n\t\t\tI'm Sorry To Tell You This,");
		System.out.println("\t\t\tBut It's: GAME OVER!");
	} // printGameOverMessage()
	
	public void printQuitGameMenu()
	{
		System.out.println("\n\t\t\tAre you sure you want to quit?");
		System.out.println("\t\t\tAny Unsaved progress will be lost!");
		System.out.println("\n\t\t\tQuit Game?");
		System.out.println("\n\t\t\t1.) Yes.");
		System.out.println("\t\t\t2.) No.");
	} // printQuitGameMenu()


}