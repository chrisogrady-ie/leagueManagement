/*
 * Christopher O Grady
 * R00067022
 */


import java.util.Scanner;


public class Menu{
	
	private static League league;
	
	
	/*
	 *----------------------------------- 
	 * shows main menu of the application
	 * -----------------------------------
	 */
	public static String showMainMenu() {
		String out = "Welcome to Chris O Grady's league management system!";
		out += "\n1) League Management";
		out += "\n2) Team Management";
		out += "\n3) Save";
		out += "\n4) Load";
		out += "\n0) Exit";
		return out;
	}
	
	
	/*
	 * ------------------------------------
	 * shows league menu of the application
	 * ------------------------------------
	 */
	public static String showLeagueMenu() {
		String out = "\n\n\n\n\n\n\n\n\n\n\nLeague Management Menu";
		out += "\n1) List teams in league";
		out += "\n2) Add/Create a team to a league";
		out += "\n3) Remove/Delete a team from a league";
		out += "\n0) Return to main menu";
		return out;
	}
	
	
	/*
	 * -----------------------------
	 * lists all teams in the league
	 * -----------------------------
	 */
	public static void listTeams() {
		league.listTeams();
	}
	
	
	/*
	 * ----------------------------------------
	 * creates a new team and adds it to league
	 * ----------------------------------------
	 */
	public static void createTeam(Scanner in) {
		in.nextLine();
		try {
			System.out.println("\nEnter a team Name:\n");
			String name = in.nextLine();
			System.out.println("\nEnter a jersey colour:\n");
			String jersey = in.nextLine();
			
			Team a = new Team(name, jersey);
			league.addTeam(a);
		}catch(Exception e) {
			System.out.println("Error has occured");
			in.nextLine();
		}
	}
	
	
	/*
	 * -------------------------------------
	 * removes a team in the league by index
	 * -------------------------------------
	 */
	public static void removeTeam(Scanner in) {
		int choice;
		listTeams();
		try {
			System.out.println("\nPlease enter a league no to remove:\n");
			choice = in.nextInt();
			league.removeTeam(choice);
		}catch(Exception e){
			System.out.println("Error has occured");
			in.nextLine();
		}
	}
	
	
	/*
	 * --------------------------
	 * shows team management menu
	 * --------------------------
	 */
	public static String showTeamMenu() {
		String out = "\n\n\n\n\n\n\n\n\n\nTeam Management Menu";
		out += "\n1) List a teams details";
		out += "\n2) Add a player to a team";
		out += "\n3) Remove a player from team";
		out += "\n4) Appoint new manager";
		out += "\n5) Remove a manager";
		out += "\n6) Player Search";
		return out;
	}
	
	
	/*
	 * ---------------------------------
	 * displays a teams details by index
	 * ----------------------------------
	 */
	public static void teamDetails(Scanner in) {
		int choice;
		listTeams();
		try {
			System.out.println("\nPlease enter a leage id no to view:\n");
			choice = in.nextInt();
			Team t= league.getTeam(choice);
			if(t != null) {
				System.out.println(t + "\nPlayers:\n");
				t.listPlayers();
			}
		}catch(Exception e) {
			System.out.println("Error has occured");
			in.nextLine();
		}
	}
	
	
	/*
	 * ---------------------------------------------------------------------------
	 * adds a player to a team by taking details and creating a new player object
	 * some details have been auto filled
	 * ----------------------------------------------------------------------------
	 */
	public static void addPlayer(Scanner in) {
		try {
			
			System.out.println("Please select a team to add a player to:");
			listTeams();
			int id = in.nextInt();
			in.nextLine();
			
			System.out.println("First name:");
			String fName = in.nextLine();
			String mName = "";
			System.out.println("Last Name:");
			String lName = in.nextLine();
			String email = "player@cit.ie";
			System.out.println("Phone No.:");
			String phone = in.nextLine();
			int goals = 0;
			System.out.println("Is this player a goalie?(true/false)");
			boolean goalie = in.nextBoolean();
			
			Player a = new Player(fName, mName, lName, email, phone, goals, goalie);
			
			(league.getTeam(id)).addPlayer(a);
		}catch(Exception e) {
			System.out.println("Error has occured");
			in.nextLine();
		}
	}
	
	
	/*
	 * ----------------------------------------------
	 * Removes a player from a team by using their id
	 * ----------------------------------------------
	 */
	public static void removePlayer(Scanner in) {
		try {
			System.out.println("Please select a team to remove a player from:");
			listTeams();
			int id = in.nextInt();
			
			Team a = league.getTeam(id);
			a.listPlayers();
			System.out.println("Enter the id of the player you wish to remove:");
			id = in.nextInt();
			
			a.removePlayer(id);
		}catch(Exception e) {
			System.out.println("Error has occured");
			in.nextLine();
		}
	}
	
	
	/*
	 * -------------------------------------------
	 * Appointing a manager to a team based on id
	 * -------------------------------------------
	 */
	public static void appointManager(Scanner in) {
		try {
			System.out.println("Please select a team to add a manager to:");
			listTeams();
			int id = in.nextInt();
			in.nextLine();
			
			System.out.println("First name:");
			String fName = in.nextLine();
			String mName = "";
			System.out.println("Last Name:");
			String lName = in.nextLine();
			String email = "manager@cit.ie";
			System.out.println("Phone No.:");
			String phone = in.nextLine();
			
			Manager a = new Manager(fName, mName, lName, email, phone);
			
			(league.getTeam(id)).setManager(a);
		}catch(Exception e) {
			System.out.println("Error has occured");
			in.nextLine();
		}
	}
	
	
	/*
	 * -------------------------------------------
	 * removes a manager from a team by id
	 * ------------------------------------------
	 */
	public static void removeManager(Scanner in) {
		try {
			System.out.println("Please select a team to remove a manager from:");
			listTeams();
			int id = in.nextInt();
			
			(league.getTeam(id)).removeManager();
		}catch(Exception e) {
			System.out.println("Error has occured");
			in.nextLine();
		}
	}
	
	
	/*
	 * 
	 * Searches for a player by first name
	 * iterates through all the teams in the league and players in the teams
	 * returns the toString of the player if found
	 * 
	 */
	public static void playerSearch(Scanner in){
		try {
			in.nextLine();
			System.out.println("\n\nEnter the FIRST NAME of the player you wish to search for:");
			String name = in.nextLine();
			
			for(int i = 0; i < league.length(); i++) {
				Team t = league.getTeam(i);
				if(t != null) {
					for(int j = 0; j < t.length(); j++){
						Player p = t.getPlayer(j);
						if(p != null) {
							Name n = p.getName();
							String fName = n.getFirstName();
							
							if(fName.equals(name)) {
								System.out.println(p);
							}
						}//end player null
					}//end team for
				}// end team null
			}//end league for
			
		}catch(Exception e) {
			System.out.println("Error has occured");
			in.nextLine();
		}
	}
	
	
	/*
	 * ----------------
	 * Saves to a file
	 * ----------------
	 */
	public static void saveFile() {
		Save s = new Save();
		s.saveFile(league);
	}
	
	
	/*
	 * ----------------
	 * Loads from file
	 * ----------------
	 */
	public static void loadFile() {
		
	}
	
	
	/*
	 * =============================================================================================================================================
	 * =============================================================================================================================================
	 * --------------------------------------------
	*	main method to run main menu from
	*	return here after every sub menu is closed
	*----------------------------------------------
	 */
	public static void main(String[] args) {
		league = new League("Premier League");
		Scanner in = new Scanner(System.in);
		int choice = -1;
		
		do {
			try {
				System.out.println(showMainMenu());
				choice = in.nextInt();
				
				switch(choice) {
				case 0:
					System.out.println("---APPLICATION CLOSING---");
					break;
				
				case 1:
					leagueMenu(in);
					continue;
					
				case 2:
					teamMenu(in);
					continue;
					
				case 3:
					saveFile();
					continue;
					
				case 4:
					loadFile();
					continue;
				}//end switch
			}catch(Exception e) {
				System.out.println("Error has occured");
				in.nextLine();
			}
			
		}while(choice != 0);
		
		in.close();	
	}//end main
	
	
	/*
	 *----------------------------------------- 
	 *	A menu to manage all league operations
	 *-----------------------------------------
	 */
	public static void leagueMenu(Scanner in) {
		int choice = -1;
		do {
			try {
				System.out.println(showLeagueMenu());
				choice = in.nextInt();
				
				switch(choice) {
				case 0:
					System.out.println("\n\n\n\n\n---RETURNING TO MAIN MENU---\n");
					break;
				
				case 1:
					System.out.println("\n\nTeams in league:");
					listTeams();
					break;
					
				case 2:
					System.out.println("\n\nCreating a team:");
					createTeam(in);
					break;
					
				case 3:
					System.out.println("\n\nRemoving a team:");
					removeTeam(in);
					break;
				}//end switch
			}catch(Exception e) {
				System.out.println("Error has occured");
				in.nextLine();
			}
			
		}while(choice != 0);
	}//end menu
	
	
	/*
	 * ----------------------------------------------
	 * A menu to manage team operations in the league
	 * ----------------------------------------------
	 */
	public static void teamMenu(Scanner in) {
		int choice = -1;
		do {
			try {
				System.out.println(showTeamMenu());
				choice = in.nextInt();
				
				switch(choice) {
				case 0:
					System.out.println("\n\n\n\n\n---RETURNING TO MAIN MENU---\n");
					break;
					
				case 1:
					teamDetails(in);
					break;
					
				case 2:
					addPlayer(in);
					break;
					
				case 3:
					removePlayer(in);
					break;
					
				case 4:
					appointManager(in);
					break;
					
				case 5:
					removeManager(in);
					break;
				
				case 6:
					playerSearch(in);
					break;
				}//end switch
			}catch(Exception e) {
				System.out.println("Error has occured");
				in.nextLine();
			}
		}while(choice != 0);
	}//end menu
	

}//end

