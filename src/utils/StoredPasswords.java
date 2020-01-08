package utils;

public class StoredPasswords {

	private String username;
	private String passwords;
	
	public StoredPasswords(String username, String passwords) {
		
		this.username = username;
		this.passwords = passwords;
		
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
	
}
