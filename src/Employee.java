/**
 * 
 * @author Faizan Zaheer, 14038751
 *This is the person class below are the variables that will be used in the database
 */
public class Employee extends Person {

	private String id;
	private String salary;
	private String startDate;
	private String title;
	private String email;
/**
 * Below are the variables that are used in the Employee class
 * @param id
 * @param name
 * @param gender
 * @param dob
 * @param address
 * @param postcode
 * @param natInscNo
 * @param Title
 * @param startDate
 * @param Email
 * @param salary
 */
	public Employee(String id, String name, char gender, String dob, String address, String postcode, String natInscNo,
			String Title, String startDate, String Email, String salary) {

		super(name, gender, natInscNo, dob, address, postcode);
		this.id = id;
		this.salary = salary;
		this.startDate = startDate;
		this.title = Title;
		this.email = Email;

	}

	public String getId() {//getting and setting the String variables
		return id;
	}

	public void setId(String newId) {
		this.id = newId;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String newSalary) {
		this.salary = newSalary;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String newstartDate) {
		this.startDate = newstartDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String newtitle) {
		this.title = newtitle;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String newemail) {
		this.email = newemail;
	}

	public String toString() {//toString to allow all of the variables to be displayed within the console
		return "\n ID: " + getId() + "\n Name: " + getName() + "\n Gender: " + getGender() + "\n Date of Birth: "
				+ getDob() + "\n Address: " + getAddress() + "\n Postcode: " + getPostcode()
				+ "\n National Insurance Number:" + getnatInscNo() + "\n Job Title: " + getTitle() + "\n Start Date: "
				+ getStartDate() + "\n Salary: " + getSalary() + "\n Email: " + getEmail();
	}
}
