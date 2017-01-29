import java.sql.SQLException;
/**
 * 
 * @author Faizan Zaheer, 14038751
 *Here is our controller class for our EmployeeDAO instead of using a GUI
 *here is where we test if whether our query functions work.
 */
public class Controller {

	static String id = "6";
	static String name = "Arnold";

	public static void main(String[] args) {

		try {

			Employee newEmp = new Employee("2 ", "Darth Vader", 'F', "5-29-1905", "Death Star", "R4 DT", "G84CHUE3K",
					"Sith", "12-23-1994", "£54000000", "Vader@hotmail.com");

			// EmployeeDAO.insertEmployee(newEmp);

			Employee found = EmployeeDAO.selectEmployeeByName(name);
			System.out.println(found);
			System.out.println("Found Employee");

			//EmployeeDAO.insertEmployeeAtID(newEmp);

			//EmployeeDAO.deleteEmployeeAtId(id);

			EmployeeDAO.selectAllEmployees();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(EmployeeDAO.allEmployees);
	}
}