package utils;

public abstract class AccountInformation {

	private String username;
	private String passwords;
	private String name;
	private String Birthday;
	private String Email;
	private String department;
	
	public AccountInformation(String username, String passwords, String name, String Birthday, String Email, String department) {
		
		this.username = username;
		this.passwords = passwords;
		this.name = name;
		this.Birthday = Birthday;
		this.Email = Email;
		this.setDepartment(department);
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
		Birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}
