

public class Name {
	
	private String firstName;
	private String middleName;
	private String lastName;
	
	public Name() {}
	
	public Name(String first, String middle, String last) {
		this.firstName = first;
		this.middleName = middle;
		this.lastName = last;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Name: \t" + firstName + " " + middleName + " " + lastName + "\n";
	}

}//end


