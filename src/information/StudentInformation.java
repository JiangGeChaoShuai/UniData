package information;

import java.util.ArrayList;
// commenting done

// class to store the information for the students, extends the account information class
public class StudentInformation extends AccountInformation {

	private String dateEnrolled;
	private ArrayList<CourseInfo> course = new ArrayList <CourseInfo>();

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

	public void setCourse(String courseCode, String courseName, int courseMark) {
		
		course.add(new CourseInfo(courseCode, courseName, courseMark));
		
	}
	
	public ArrayList<CourseInfo> getCourse(){
		
		
		return course;
	}
	
}
