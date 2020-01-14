package readFile;

import java.util.ArrayList;

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


}
