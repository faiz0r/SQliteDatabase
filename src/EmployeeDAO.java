import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Faizan Zaheer, 14038751
 * This is the EmployeeDAO here is where all the base classes are and where we will use our SQL queries in order to retrieve the date
 * Storing employees from the database into an array called allEmployees
 * using the driver org.sqlite.JDBC as we are using SQLite to manage our employees
 * creating connections to the database
 */

public class EmployeeDAO {

	public static ArrayList<Employee> allEmployees = new ArrayList();

	public static Connection getDBConnection() {

		Connection dbConnection = null;
		try {
			Class.forName("org.sqlite.JDBC");	//this driver allows for us to use sqlite
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			String dbURL = "jdbc:sqlite:employees.sqlite";	//connecting to our sqlite database 
			dbConnection = DriverManager.getConnection(dbURL);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}
	/**
	 * Here is the base class which selects all the employees from the database and then stores
	 * it within an array list so that we can retrieve the information later on.
	 * @return all the selected employees from the variable allEmployees
	 * @throws SQLException
	 */
	public static ArrayList<Employee> selectAllEmployees() throws SQLException {

		Connection dbconnection = null;
		Statement statement = null;
		ResultSet resultset = null;

		String query = "SELECT * FROM employees; ";	//Selecting all employee from the employees table

		try {
			dbconnection = getDBConnection();
			statement = dbconnection.createStatement();
			resultset = statement.executeQuery(query);	
			while (resultset.next()) {
				String id = resultset.getString("ID"); //all the data types acquired from the database
				String name = resultset.getString("Name");
				String gender = resultset.getString("Gender");
				char gen = gender.charAt(0);
				String dob = resultset.getString("DOB");
				String address = resultset.getString("Address");
				String postcode = resultset.getString("Postcode");
				String nin = resultset.getString("NIN");
				String jobtitle = resultset.getString("JobTitle");
				String startdate = resultset.getString("StartDate");
				String salary = resultset.getString("Salary");
				String email = resultset.getString("Email");

				Employee emp1 = new Employee(id, name, gen, dob, address, postcode, nin, jobtitle, startdate, email,
						salary);

				allEmployees.add(emp1);	//emp1 is the variable that stores the employees

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {	//closing all the connections
			if (resultset != null) {
				resultset.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbconnection != null) {
				dbconnection.close();
			}
		}
		return allEmployees;//returning the variable
	}

	/**
	 * Here we have our base class for selecting employee by their name, this allows the user to select
	 * an employee by typing the name
	 * @param name
	 * @return name of the user will display that has related text within the variable name
	 */
	public static Employee selectEmployeeByName(String name) {//method to select employee by name
		Connection connection = null;
		Statement statement = null;
		Employee emp1 = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:employees.sqlite");
			connection.setAutoCommit(false);
			System.out.println("Read operation - database successfully opened");
			statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT * FROM employees WHERE Name LIKE '%" + name + "%'");//query to select all form the employee table where the name is similar to the string name
			while (resultset.next()) {
				String id = resultset.getString("ID");
				String sname = resultset.getString("Name");
				String gender = resultset.getString("Gender");
				char gen = gender.charAt(0);
				String dob = resultset.getString("DOB");
				String address = resultset.getString("Address");
				String postcode = resultset.getString("Postcode");
				String nin = resultset.getString("NIN");
				String jobtitle = resultset.getString("JobTitle");
				String startdate = resultset.getString("StartDate");
				String salary = resultset.getString("Salary");
				String email = resultset.getString("Email");

				emp1 = new Employee(id, sname, gen, dob, address, postcode, nin, jobtitle, startdate, email, salary);

			}
			resultset.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Read operation successfully done");
		return emp1;
	}
	
	/**
	 * insert employee  allows the user to get the credentials of all the fields within the database
	 * and inserting them into the database
	 * @param emp
	 * @return inserted employee within the database
	 */

	public static boolean insertEmployee(Employee emp) {//method to insert employee
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:employees.sqlite");
			connection.setAutoCommit(false);
			System.out.println("Insert operation - database successfully opened");

			statement = connection.createStatement();	//getting name, gender and dob, and inserting them into the employees table
			String sql = "INSERT INTO employees"
					+ "('Name', 'Gender', 'DOB', 'Address', 'Postcode', 'NIN', 'JobTitle', 'StartDate', 'Salary', 'Email') "
					+ "VALUES" + "('" + emp.getName() + "','" + emp.getGender() + "','" + emp.getDob() + "', '"
					+ emp.getAddress() + "'," + " '" + emp.getPostcode() + "', '" + emp.getnatInscNo() + "', '"
					+ emp.getTitle() + "', '" + emp.getStartDate() + "'," + " '" + emp.getSalary() + "','"
					+ emp.getEmail() + "')";//retrieving the data from the employees class

			statement.executeUpdate(sql);
			statement.close();
			connection.commit();
			connection.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return true;
		}
		System.out.println("Record is inserted into employees table!");
		return false;
	}
	
	/**
	 * base class to insert employee at ID better known to edit an employee according
	 * to their corresponding ID, this allows the user to adjust the credentials
	 * of an employee.
	 * @param emp
	 * @return employees credentials become edited
	 */

	public static boolean insertEmployeeAtID(Employee emp) {
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:employees.sqlite");
			connection.setAutoCommit(false);
			System.out.println("Update operation - database successfully opened");

			statement = connection.createStatement();//getting name, gender and dob, and inserting them into the employees table at ID
			String sql = "UPDATE employees SET Name='" + emp.getName() + "', " + "Gender='" + emp.getGender() + "', "
					+ "DOB= '" + emp.getDob() + "', " + "Address= '" + emp.getAddress() + "', " + "Postcode= '"
					+ emp.getPostcode() + "', " + "NIN= '" + emp.getnatInscNo() + "', " + "JobTitle= '" + emp.getTitle()
					+ "', " + "StartDate= '" + emp.getStartDate() + "', " + "Salary= '" + emp.getSalary() + "', "
					+ "Email= '" + emp.getEmail() + "' " + "WHERE ID ='" + emp.getId() + "';";
			statement.executeUpdate(sql);
			connection.commit();
			statement.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Update operation successfully done");
		return false;
	}
	

	/**
	 * Allow the user to delete an employee at their corresponding id
	 * @param id
	 * @return employee is deleted from the database at the corresponding id
	 */
	public static boolean deleteEmployeeAtId(String id) {
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:employees.sqlite");
			connection.setAutoCommit(false);
			System.out.println("Delete operation - database successfully opened");
			statement = connection.createStatement();
			String sql = "Delete from employees where ID = " + id;//deleting a record at the String id
			statement.executeUpdate(sql);
			connection.commit();
			statement.close();
			return true;
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return false;
		}
	}
}