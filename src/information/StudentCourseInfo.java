package information;

public class StudentCourseInfo {

	private String courseCode;
	private String courseName;
	private int courseMark;
	
	public StudentCourseInfo(String courseCode, String courseName, int courseMark) {
		
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseMark = courseMark;
		
	}

	public int getCourseMark() {
		return courseMark;
	}

	public void setCourseMark(int courseMark) {
		this.courseMark = courseMark;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
}
