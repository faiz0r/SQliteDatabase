/**
 * 
 * @author Faizan Zaheer, 14038751
 *This is the person class below are the variables that will be used in the database
 */
public class Person {

	private String name;
	private char gender;
	private String natInscNo;
	private String dob;
	private String Address;
	private String Postcode;

	/**
	 * Below are the variables that are used in the person class
	 * @param newName
	 * @param newGender
	 * @param newNatInscNo
	 * @param newDob
	 * @param newAddress
	 * @param newPostcode
	 */
	public Person(String newName, char newGender, String newNatInscNo, String newDob, String newAddress,
			String newPostcode) {
		this.name = newName;
		this.gender = newGender;
		this.natInscNo = newNatInscNo;
		this.dob = newDob;
		this.Address = newAddress;
		this.Postcode = newPostcode;

	}

	/**
	 * Below are the strings and char we want to store in the returned variables.
	 * @return name, gender, natInscNo, dob, Address, Postcode
	 */
	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public char getGender() {
		return gender;
	}

	public void setgender(char newGender) {
		this.gender = newGender;
	}

	public String getnatInscNo() {
		return natInscNo;
	}

	public void setNatInscNo(String newNatInscNo) {
		this.natInscNo = newNatInscNo;
	}

	public String getDob() {
		return this.dob;
	}

	public void setDob(String newdob) {
		this.dob = newdob;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String newAddress) {
		this.Address = newAddress;
	}

	public String getPostcode() {
		return Postcode;
	}

	public void setPostcode(String newPostcode) {
		this.Postcode = newPostcode;
	}

	public String toString() {
		return "Name: " + getName() + ", Gender: " + getGender() + ", Address: " + getAddress() + ", Postcode: "
				+ getPostcode();

	}
}