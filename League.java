
public class League {
	
	private String name;
	private Team[] teams;
	private int leagueSize;
	
	public League(String divisionName) {
		this.name = divisionName;
		this.teams = new Team[18];
		this.leagueSize = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void listTeams() {
		if(this.leagueSize < 1)
			System.out.println("-----League is empty!-----");
		else
			for(int i = 0; i < leagueSize; i++) {
				System.out.println(i + ")" + teams[i].getName());
			}
	}

	public void addTeam(Team t) {
		if(leagueSize < teams.length) {
			teams[leagueSize] = t;
			leagueSize++;
			System.out.println(t.getName() + " was succesfully added to " + this.name);
		}else
			System.out.println("---Error---\nLeague is at capacity\nDivision unchanged");
	}
	
	public void removeTeam(int index) {
		if(index >= 0 && index <= leagueSize) {
			String a = teams[index].getName();
			System.out.println(a + " was succesfully removed from " + this.name);
			
			teams[index] = null;
			tidyLeague(index);
		}else
			System.out.println("---Error---\nIndex out of range\nRoster unchanged");
	}
	
	public Team getTeam(int i) {
		Team a = null;
		if(i >= 0 && i < leagueSize) {
			a = teams[i];
		}else
			System.out.println("---Error---\\nNo team at this index");
		return a;
	}
	
	public void tidyLeague(int i) {
		for(; i < leagueSize; i++) {
			if(i == (leagueSize -1)) {
				teams[i] = null;
				this.leagueSize--;
			}else
				teams[i] = teams[i + 1];
		}//end for
	}
	
	public int length() {
		return this.leagueSize;
	}

	
}


