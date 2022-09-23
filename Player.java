
public class Player extends Person{
	
	private int goals;
	private boolean goalie;
	
	public Player() {}
	
	public Player(String fName, String mName, String lName, String email, String phone, int goals, boolean goalie) {
		super(fName, mName, lName, email, phone);
		this.goals = goals;
		this.goalie = goalie;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public boolean isGoalie() {
		return goalie;
	}

	public void setGoalie(boolean goalie) {
		this.goalie = goalie;
	}

	@Override
	public String toString() {
		String out = super.toString() + "Position:\t";
		if(goalie == true)
			out += "Goalie \nGoals Conceded:";
		else
			out += "Outfield Player \nGoals Scored:";
		out += "\t" + goals + "\n";
		return out;
	}

}//end


