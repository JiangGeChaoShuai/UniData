package information;

import java.util.ArrayList;

public class StudentInformation extends AccountInformation {

	private String dateEnrolled;
	private ArrayList<StudentCourseInfo> course = new ArrayList <StudentCourseInfo>();

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
		
		course.add(new StudentCourseInfo(courseCode, courseName, courseMark));
		
	}
	
	public ArrayList<StudentCourseInfo> getCourse(){
		
		
		return course;
	}
	
}