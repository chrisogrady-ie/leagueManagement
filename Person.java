
public class Person {
	
	private Name name;
	private String email;
	private String phone;
	
	public Person() {}
	
	public Person(String fName, String mName, String lName, String email, String phone) {
		this.email = email;
		this.phone = phone;
		this.name = new Name();
		setName(fName, mName, lName);
	}

	public Name getName() {
		return name;
	}

	public void setName(String fName, String mName, String lName) {
		name.setFirstName(fName);
		name.setMiddleName(mName);
		name.setLastName(lName);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return this.getName() + "Email: \t" + this.email + "\nPhone: \t" + this.phone + "\n";
	}

}//end 


