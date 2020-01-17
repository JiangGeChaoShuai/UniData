package information;

import java.util.ArrayList;
// commenting done

// class to store information for courses that get read from course library file
public class CourseInformation {

	private ArrayList<StudentInformation> studentInCourse = new ArrayList<StudentInformation>();
	private TeacherInformation teacher;
	private ArrayList<TimeOfWeek> times = new ArrayList<TimeOfWeek>();
	private String classCode;
	private String className;

	public CourseInformation(String classCode, String className, TeacherInformation teacher) {

		this.classCode = classCode;
		this.className = className;
		this.teacher = teacher;

	}

	public CourseInformation(CourseInformation course) {

		studentInCourse = course.getStudentInCourse();
		teacher = course.getTeacher();
		times = course.getTimes();
		classCode = course.getClassCode();
		className = course.getClassName();
	}

	public void addStudent(StudentInformation student) {

		studentInCourse.add(student);
	}

	public void addTime(TimeOfWeek time) {

		times.add(time);
	}

	public TeacherInformation getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherInformation teacher) {
		this.teacher = teacher;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public ArrayList<StudentInformation> getStudentInCourse() {
		return studentInCourse;
	}

	public ArrayList<TimeOfWeek> getTimes() {
		return times;
	}

	// checks for conflict between two different courses
	public boolean checkCourseTime(CourseInformation courseTimeChecker) {

		
		for (TimeOfWeek time  : this.getTimes()) {

			for (TimeOfWeek time2 : courseTimeChecker.getTimes()) {
				

				//check if date match
				if (time.getDate().equals(time2.getDate())) {

					
					// check if class one starts while class two is going on
					if (time.getBeginTime() >= time2.getBeginTime() && time.getBeginTime() <= time2.getEndTime()) {

						return false;
					}
					// check if class two starts while class one is going on
					if (time.getEndTime() >= time2.getBeginTime() && time.getEndTime() <= time2.getEndTime()) {

						return false;
					}

				}
			}

		}
		return true;
	}

}
