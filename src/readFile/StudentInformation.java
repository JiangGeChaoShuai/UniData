package readFile;

public class StudentInformation extends AccountInformation {

	private String dateEnrolled;

	public StudentInformation(String username, String passwords, String name, String Birthday, String Email,
			String dateEnrolled, String department) {

		super(username, passwords, name, Birthday, Email, department);
		this.setDateEnrolled(dateEnrolled);

	}

	public String getDateEnrolled() {
		return dateEnrolled;
	}

	public void setDateEnrolled(String dateEnrolled) {
		this.dateEnrolled = dateEnrolled;
	}

}
