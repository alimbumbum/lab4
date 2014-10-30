package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Student;

public class StudentDAO {
	private static String url = "jdbc:mysql://localhost:3306/test"; 
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root"; 
	private static String password = "qwerty";
	private static Connection conn;
	StudentDAO() {
		initialize();
	}
	
	public static void initialize() {
		if (conn == null) {
			try { 
				Class.forName(driver).newInstance(); 
				conn = DriverManager.getConnection(url, user, password); 
			} 
			catch (Exception e) { 
				e.printStackTrace();
			}		
		}
	}	
	
	public static void addStudent(String fname, String lname, String faculty, int yof) {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT into students(first_name, last_name, faculty, year_of_study)"
					+ " VALUES('" + fname + "','" + lname + "','" + faculty + "'," + yof + ")");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Student> listStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			Statement st = conn.createStatement(); 
			ResultSet res = st.executeQuery("SELECT * FROM students"); 
			while (res.next()) {  
				students.add(new Student(res.getInt("id"), res.getString("first_name"), res.getString("last_name"), 
						res.getString("faculty"), res.getInt("year_of_study")));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	public static void updateStudent(Integer studentID, String faculty) {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("UPDATE students "
					+ "SET faculty = '" + faculty + "' "
					+ "WHERE id = " + studentID);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteStudent(Integer studentID) {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("DELETE FROM students "
					+ "WHERE id = " + studentID);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
