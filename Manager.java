
public class Manager extends Person{
	
	private Team team;
	private int rating;
	private int[] RATINGRANGE = new int[] {1, 10};
	
	public Manager() {}
	
	public Manager(String fName, String mName, String lName, String email, String phone) {
		super(fName, mName, lName, email, phone);
		this.rating = 1;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		boolean check = checkRating(rating);
		if(check)
			this.rating = rating;
		else
			System.out.println("---Error---\nOut of range rating, value must be between 1 nad 10\nRating unchanged");
	}
	
	//checks for valid user input range
	public boolean checkRating(int rating) {
		boolean check = false;
		int min = this.RATINGRANGE[0];
		int max = this.RATINGRANGE[1];
		
		if(min <= rating && rating <= max)
			check = true;
		
		return check;	
	}

	public Team getTeam() {
		return team;
	}

	//checks if manager already has a team and calls the appropriate method from team
	public void setTeam(Team team) {
		if(this.team != null)
			this.team.removeManager();
		this.team = team;
	}
	
	//removes this managers team and stores it in temp to access the appropriate method there
	public void removeTeam() {
		if(this.team != null) {
			Team temp = this.team;
			this.team = null;
			temp.removeManager();
		}
	}
	
	@Override
	public String toString() {
		String out = super.toString();
		if(this.team == null)
			out += "Team:\tNone";
		else
			out += "Team:\t" + this.team.getName();
		out += "\nRating: ";
		for(int i = 0; i < this.rating; i++)
			out += "* ";
		return out;
	}


}//end



