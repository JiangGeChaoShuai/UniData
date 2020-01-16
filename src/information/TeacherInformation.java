package information;

import java.util.ArrayList;

public class TeacherInformation extends AccountInformation {

	private ArrayList<CourseInfo> course = new ArrayList<CourseInfo>();

	public TeacherInformation(String username, String passwords, String name, String Birthday, String Email,
			String department) {
		super(username, passwords, name, Birthday, Email, department);
		// TODO Auto-generated constructor stub
	}

	public void setCourse(String courseCode, String courseName) {

		course.add(new CourseInfo(courseCode, courseName));

	}

	public ArrayList<CourseInfo> getCourse() {

		return course;
	}

}
