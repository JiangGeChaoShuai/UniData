package information;
// commenting done

// stores the information that gets read from the student info class
public class CourseInfo {

	private String courseCode;
	private String courseName;
	private int courseMark;
	
	// store course info for students
	public CourseInfo(String courseCode, String courseName, int courseMark) {
		
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseMark = courseMark;
		
	}
	
	// stores course info for teachers
	public CourseInfo(String courseCode, String courseName) {
		this.courseCode = courseCode;
		this.courseName = courseName;
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
