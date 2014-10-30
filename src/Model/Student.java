package Model;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String faculty;
	private int yearOfStudy;
	Student () {
		
	}
	public Student (String firstName, String lastName, String faculty, int yearOfStudy) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.faculty = faculty;
		this.yearOfStudy = yearOfStudy;
	}
	public Student (int id, String firstName, String lastName, String faculty, int yearOfStudy) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.faculty = faculty;
		this.yearOfStudy = yearOfStudy;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public int getYearOfStudy() {
		return yearOfStudy;
	}
	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
}
