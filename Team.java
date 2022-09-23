//import java.util.Arrays;

public class Team {
	
	private Manager manager;
	private Player[] players;
	private int teamSize;
	private int teamMaxSize = 25;
	private String name;
	private String jersey;
	
	public Team() {}
	
	public Team(String name, String jersey) {
		this.name = name;
		this.jersey = jersey;
		this.teamSize = 0;
		//this.teamMaxSize = 25;
		this.players = new Player[25];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJersey() {
		return jersey;
	}

	public void setJersey(String jersey) {
		this.jersey = jersey;
	}
	
	//checks for existing manager of the team and uses remove method to handle associations
	public void setManager(Manager manager) {
		if(this.manager != null)
			removeManager();
		this.manager = manager;
		manager.setTeam(this);
		System.out.println(this.manager.getName() + " has been appointed to the team");
	}
	
	//removes current manager if there is one and stores them in temp and uses this to access the appropriate method in manager to remove associations
	public void removeManager() {
		if(this.manager!= null) {
			Manager temp = this.manager;
			this.manager = null;
			temp.removeTeam();
			System.out.println("\nManager has been removed\n");
		}
	}
	
	public void addPlayer(Player p) {
		if(teamSize < teamMaxSize) {
			players[teamSize] = p;
			teamSize++;
			System.out.println(p.getName() + " was succesfully added to " + this.name);
		}else
			System.out.println("---Error---\nTeam is at capacity\nRoster unchanged");
	}
	
	//removes player at index and calls to fix any blank spaces in list
	public void removePlayer(int index) {
		if(index >= 0 && index <= teamMaxSize) {
			Name a = players[index].getName();
			System.out.println(a + "was succesfully removed from " + this.name);
			
			players[index] = null;
			tidyRoster(index);
		}else
			System.out.println("---Error---\nIndex out of range\nRoster unchanged");
	}
	
	//fixes any blank spaces in the list by moving all positions above the index down one
	public void tidyRoster(int i) {
		for(; i < teamSize; i++) {
			if(i == (teamSize -1)) {
				players[i] = null;
				this.teamSize--;
			}else
				players[i] = players[i + 1];
		}
	}
	
	public void listPlayers() {
		if(this.teamSize > 0) {
			for(int i = 0; i < teamSize; i++) {
				System.out.println(i + ") " + players[i].getName());
			}
		}else
			System.out.println(name + " has no players on their team" );
	}

	public Player getPlayer(int i) {
		Player a = null;
		if(this.teamSize > 0 && i < teamSize) {
			a = players[i];
		}
		return a;
	}

	
	@Override
	public String toString() {
		String out = "Team Name:\t" + this.name + "\nJersey:\t\t" + this.jersey + "\nSquad Size:\t" + this.teamSize + "\n";
		out += "Manager:\t";
		if(manager == null)
			out += "None";
		else
			out += this.manager.getName();
		return out;
	}
	
	public int length() {
		return teamSize;
	}

}//end



