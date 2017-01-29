import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * @author Faizan Zaheer, 14038751
 * Declared all the different types of variables and their objects which includes;
 * JLabels
 * JTextFields
 * JButtons
 * JRadioButtons
 * JComboBoxes
 * JOptionPanes
 * JPanels
 */

public class aFrame extends JFrame {
	
	private JLabel ID = new JLabel("ID:");//Here is the Object of JLabels being declared, they also have the name so the user can identify them
	private JLabel Name = new JLabel("Name:");
	private JLabel Gender = new JLabel("Gender:");
	private JLabel DateofBirth = new JLabel("Date of Birth:");
	private JLabel Address = new JLabel("Address");
	private JLabel Postcode = new JLabel("Postcode");
	private JLabel Salary = new JLabel("Salary:");
	private JLabel NIN = new JLabel("National Insurance Number:");
	private JLabel Email = new JLabel("Email:");
	private JLabel StartDate = new JLabel("Start Date:");
	private JLabel JobTitle = new JLabel("Job Title:");
	
	private JTextField IDField = new JTextField(2);//here is the JTextFields being declared, in the brackets i can assign the size of the field
	private JTextField NameField = new JTextField(20);
	private JTextField SalaryField = new JTextField(20);
	private JTextField AddressField = new JTextField(20);
	private JTextField PostcodeField = new JTextField(20);
	private JTextField NINField = new JTextField(20);
	private JTextField EmailField = new JTextField(20);
	private JTextField JobField = new JTextField(20);
	private JTextField SearchField = new JTextField(20);

	private JButton Insert = new JButton("Insert");
	private JButton Update = new JButton("Update");
	private JButton Delete = new JButton("Delete");
	private JButton Clear = new JButton("Clear");
	private JButton Back = new JButton("<");
	private JButton Forward = new JButton(">");
	private JButton searchBtn = new JButton ("Search");

	private JRadioButton Male = new JRadioButton("Male");
	private JRadioButton Female = new JRadioButton("Female");
	private JPanel genderPanel = new JPanel();
	ButtonGroup bg = null;
	
	private JComboBox Day = new JComboBox();
	private JComboBox Month = new JComboBox();
	private JComboBox Year = new JComboBox();
	private JPanel datePanel = new JPanel();//JPanels are used to combine two objects together and allow me to put them onto the GUI

	private JComboBox SDay = new JComboBox();
	private JComboBox SMonth = new JComboBox();
	private JComboBox SYear = new JComboBox();
	private JPanel sDateP = new JPanel();
	
	private JOptionPane noDate = new JOptionPane();
	private JOptionPane nosDate = new JOptionPane();
	private JOptionPane noGender = new JOptionPane();

	EmployeeDAO dao = new EmployeeDAO();
	ArrayList<Employee> allemps = new ArrayList();
	
	int counter = 0;//counter which will be used to shift between employees in the database
	
	/**
	 * aFrame which is where all the functions will go such as the positioning
	 * and layout for all the buttons and textfields that will be placed within the
	 * GUI, we are going to be using the gridbag layout to position out components.
	 */

	public aFrame() {

		super("Employee Record System");

		try {
			allemps = EmployeeDAO.selectAllEmployees();	//Select all employee method from our stored employees within the array allemps
		} catch (SQLException e) {
			e.printStackTrace();
		}

		setLayout(new GridBagLayout());	//setLayout(new GridBagLayout());, using the GridBagLayout for my GUI
		GridBagConstraints c = new GridBagConstraints();	//c = new GridBagConstraints,  have stored it in the variable c 

		c.weightx = 0.5;	//c.weightx = 0.5, The spacing around the Objects
		c.weighty = 0.5;

		// JLabels

		c.gridx = 0;	//c.gridx = 0, The positioning on the GUI using the GridBagLayout method 
		c.gridy = 0;
		add(ID, c);	//add(Component, c), Adding the component onto the canvas using the c constraint

		c.gridx = 0;
		c.gridy = 1;
		add(Name, c);

		c.gridx = 0;
		c.gridy = 2;
		add(Gender, c);

		c.gridx = 0;
		c.gridy = 3;
		add(DateofBirth, c);

		c.gridx = 0;
		c.gridy = 4;
		add(Address, c);

		c.gridx = 0;
		c.gridy = 5;
		add(Postcode, c);

		c.gridx = 0;
		c.gridy = 6;
		add(Email, c);

		c.gridx = 0;
		c.gridy = 7;
		add(NIN, c);

		c.gridx = 0;
		c.gridy = 8;
		add(Salary, c);

		c.gridx = 0;
		c.gridy = 9;
		add(StartDate, c);

		c.gridx = 0;
		c.gridy = 10;
		add(JobTitle, c);

		// JTextField
		
		c.gridx = 1;
		c.gridy = 0;
		IDField.setText(allemps.get(counter).getId());//setting information onto a JTextField and getting it from the Employees Class
		add(IDField, c);

		c.gridx = 1;
		c.gridy = 1;
		NameField.setText(allemps.get(counter).getName());//using the counter variable in order to shift between stored data within the database
		add(NameField, c);

		c.gridx = 1;
		c.gridy = 4;
		AddressField.setText(allemps.get(counter).getAddress());
		add(AddressField, c);

		c.gridx = 1;
		c.gridy = 5;
		PostcodeField.setText(allemps.get(counter).getPostcode());
		add(PostcodeField, c);

		c.gridx = 1;
		c.gridy = 6;
		EmailField.setText(allemps.get(counter).getEmail());
		add(EmailField, c);

		c.gridx = 1;
		c.gridy = 7;
		NINField.setText(allemps.get(counter).getnatInscNo());
		add(NINField, c);

		c.gridx = 1;
		c.gridy = 8;
		SalaryField.setText(allemps.get(counter).getSalary());
		add(SalaryField, c);

		c.gridx = 1;
		c.gridy = 10;
		JobField.setText(allemps.get(counter).getTitle());
		add(JobField, c);
		
		c.gridx = 1;
		c.gridy = 13;
		add(SearchField, c);

		// JButtons
		
		c.gridx = 0;
		c.gridy = 14;
		add(Insert, c);

		c.gridx = 0;
		c.gridy = 15;
		add(Update, c);

		c.gridx = 0;
		c.gridy = 16;
		add(Delete, c);

		c.gridx = 1;
		c.gridy = 14;
		add(Clear, c);

		c.gridx = 2;
		c.gridy = 13;
		add(Back, c);

		c.gridx = 3;
		c.gridy = 13;
		add(Forward, c);
		
		c.gridx = 0;
		c.gridy = 13;
		add(searchBtn, c);

		// JButton Functions
		
		/**
		 * This is the JButton functionality for Back & Forward, here we will be using ActionListeners
		 * in order to give the buttons unique functions towards our stored employees within
		 * our database to allow the user to manipulate the database, in this case we are using our
		 * in counter to move back and fourth throughout our database, in this case we are incrementing the counter
		 */
		
		Forward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<Employee> array = null;
				try {
					array = EmployeeDAO.selectAllEmployees();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				if (counter <= array.size()) {	//Here we are using a fore loop to loop the array for when we reach
					counter++;				  	// the end of the database
				} else {

				}

				if (allemps.get(counter).getGender() == 'M') {	//selects changes within the option for the Male 
																//and Female of each employee
					Male.setSelected(true);
				} else {
					Female.setSelected(true);
				}

				String[] parts = allemps.get(counter).getDob().split("-");	//selects changes for dates of each 
				int day = Integer.parseInt(parts[0]);						//employee within the database and 
				int month = Integer.parseInt(parts[1]);						//splitting the selection of the int with a "-"
				int year = Integer.parseInt(parts[2]);
				Day.setSelectedItem(day);
				Month.setSelectedItem(month);
				Year.setSelectedItem(year);

				String[] date = allemps.get(counter).getStartDate().split("-");
				int sday = Integer.parseInt(date[0]);
				int smonth = Integer.parseInt(date[1]);
				int syear = Integer.parseInt(date[2]);
				SDay.setSelectedItem(sday);
				SMonth.setSelectedItem(smonth);
				SYear.setSelectedItem(syear);

				IDField.setText(allemps.get(counter).getId());		//selects the changes for basic information of each 
				NameField.setText(allemps.get(counter).getName());	//employee in the database
				AddressField.setText(allemps.get(counter).getAddress());
				PostcodeField.setText(allemps.get(counter).getPostcode());
				SalaryField.setText(allemps.get(counter).getSalary());
				NINField.setText(allemps.get(counter).getnatInscNo());
				EmailField.setText(allemps.get(counter).getEmail());
				JobField.setText(allemps.get(counter).getTitle());
			}
		});
		
		/**
		 * Back functions in the same way as our forward button but decrements the data within each of the text fields
		 */
		
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (counter > 0) {	//the counter will stop decrementing when the counter reaches 0
					counter--;
				}

				if (allemps.get(counter).getGender() == 'M') {	
					Male.setSelected(true);
				} else {
					Female.setSelected(true);
				}

				String[] parts = allemps.get(counter).getDob().split("-");
				int day = Integer.parseInt(parts[0]);
				int month = Integer.parseInt(parts[1]);
				int year = Integer.parseInt(parts[2]);
				Day.setSelectedItem(day);
				Month.setSelectedItem(month);
				Year.setSelectedItem(year);

				String[] date = allemps.get(counter).getStartDate().split("-");
				int sday = Integer.parseInt(date[0]);
				int smonth = Integer.parseInt(date[1]);
				int syear = Integer.parseInt(date[2]);
				SDay.setSelectedItem(sday);
				SMonth.setSelectedItem(smonth);
				SYear.setSelectedItem(syear);

				IDField.setText(allemps.get(counter).getId());
				NameField.setText(allemps.get(counter).getName());
				AddressField.setText(allemps.get(counter).getAddress());
				PostcodeField.setText(allemps.get(counter).getPostcode());
				SalaryField.setText(allemps.get(counter).getSalary());
				NINField.setText(allemps.get(counter).getnatInscNo());
				EmailField.setText(allemps.get(counter).getEmail());
				JobField.setText(allemps.get(counter).getTitle());
			}
		});

		/**
		 * Here is our clear button, this is a simple button that will clear all the fields within the GUI,
		 * there is also some validation involved making the user unable to clear until one of the fields
		 * have text inside of it.
		 */
		
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				NameField.setText("");	//setting all the fields to appear empty
				AddressField.setText("");
				PostcodeField.setText("");
				SalaryField.setText("");
				NINField.setText("");
				EmailField.setText("");
				JobField.setText("");
				Day.setSelectedIndex(0);	//setting the date to be the first int in this case it's 1
				bg.clearSelection();
				Month.setSelectedIndex(0);
				Year.setSelectedIndex(50);	//setting the Year to be the 50th number in this case it's 1966
				SDay.setSelectedIndex(0);
				SMonth.setSelectedIndex(0);
				SYear.setSelectedIndex(0);

			}
		});
		
		/**
		 * Functionality for the Insert button getting the information from our string variables, isSelected and getSelected 
		 * then setting them into the database using the insert button we are also using  validation to see if the 
		 * name, postcode and email fields are checked otherwise the user will not be able to insert data.
		 */

		Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("Insert Employee");

				String id = IDField.getText();
				String name = NameField.getText();
				String address = AddressField.getText();
				String postcode = PostcodeField.getText();
				String salary = SalaryField.getText();
				String natInscNo = NINField.getText();
				String Email = EmailField.getText();
				String Title = JobField.getText();

				char gender = ' ';		//using is selected statements for the gender to see what is selected M
				if (Male.isSelected())	//or F which will be printed into the database
					gender = 'M';
				else if (Female.isSelected())
					gender = 'F';

				String dob = " ";
				String day = String.valueOf(Day.getSelectedItem());		//Date of Birth is stored in the variable 
				String month = String.valueOf(Month.getSelectedItem());	//dob and whatever is selected within 
				String year = String.valueOf(Year.getSelectedItem());	//the combobox is seperated with "-" between them
				dob = day + "-" + month + "-" + year;

				String startDate;
				String sday = String.valueOf(SDay.getSelectedItem());
				String smonth = String.valueOf(SMonth.getSelectedItem());
				String syear = String.valueOf(SYear.getSelectedItem());
				startDate = sday + "-" + smonth + "-" + syear;
				
				String validDob = Year.getSelectedItem()+"";
				String validsDate = SYear.getSelectedItem()+"";
				
				if(Male.isSelected()==false&&(Female.isSelected()==false)){	//user is unable to insert without selecting a Gender
					JOptionPane.showMessageDialog(noGender, "No Gender is Selected");
				} else {
				
				int CheckYear = Integer.parseInt(validDob);
				int CheckSYear = Integer.parseInt(validsDate);
				if(CheckYear < CheckSYear){	//user is unable to insert if the Date of Birth is greater than the StartDate
					Employee toInsert = new Employee(id, name, gender, dob, address, postcode, natInscNo, Title, startDate,
							Email, salary);
					EmployeeDAO.insertEmployee(toInsert); //insert employee into the database 
				} else
					JOptionPane.showMessageDialog(noDate, "Date of Birth can't be larger than the Start Date");
			}
			}
		});
		
		/**
		 * Functionality for the Update button using the method from our EmployeeDAO
		 * getting the information from the Fields
		 * if statement for the gender to see what is selected M or F
		 * Date of Birth is stored in the variable dob and whatever is selected within the combo box is separated with "-" between them
		 * if statement for the validation to see if the name, postcode and email fields are checked
		 */

		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = IDField.getText();
				String name = NameField.getText();
				String address = AddressField.getText();
				String postcode = PostcodeField.getText();
				String salary = SalaryField.getText();
				String natInscNo = NINField.getText();
				String email = EmailField.getText();
				String title = JobField.getText();

				char gender = ' ';
				if (Male.isSelected())
					gender = 'M';
				else if (Female.isSelected())
					gender = 'F';

				String dob = " ";
				String day = String.valueOf(Day.getSelectedItem());
				String month = String.valueOf(Month.getSelectedItem());
				String year = String.valueOf(Year.getSelectedItem());
				dob = day + "-" + month + "-" + year;

				String startDate;
				String sday = String.valueOf(SDay.getSelectedItem());
				String smonth = String.valueOf(SMonth.getSelectedItem());
				String syear = String.valueOf(SYear.getSelectedItem());
				startDate = sday + "-" + smonth + "-" + syear;
				
				String validDob = Year.getSelectedItem()+"";
				String validsDate = SYear.getSelectedItem()+"";
				
				Employee toUpdate = new Employee(id, name, gender, dob, address, postcode, natInscNo, title, startDate,
						email, salary);
				
				if(bg.isSelected(null)){
					JOptionPane.showMessageDialog(noGender, "No Gender is Selected");
				} else {
				int CheckYear = Integer.parseInt(validDob);
				int CheckSYear = Integer.parseInt(validsDate);
				if(CheckYear < CheckSYear){
					EmployeeDAO.insertEmployeeAtID(toUpdate); //update employee //insert employee into the database 
				} else {
					JOptionPane.showMessageDialog(nosDate, "Date of Birth can't be larger than the Start Date");
					
				}
				
				}

			}
		});
		
		/**
		 * Functionality for the Delete button using the method from our EmployeeDAO
		 * getting the information from the IDField
		 */

		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = IDField.getText();

					EmployeeDAO.deleteEmployeeAtId(id);
			}
		});
		
		/**
		 * Functionality for the Search button using the method from our EmployeeDAO
		 * getting the information from the SearchField storing it within the variable search
		 * Variable Find is used for the method SelectEmployeeByName and getting that information for our TextFields
		 */
		
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				String search = SearchField.getText(); //getting the text from our Search Field stored in the variable Find

				Employee Find = EmployeeDAO.selectEmployeeByName(search); //search for employee

				System.out.println(Find);

				IDField.setText(Find.getId()); //getting the information from the search field and seting them into the textfields
				NameField.setText(Find.getName());
				AddressField.setText(Find.getAddress());
				PostcodeField.setText(Find.getPostcode());
				SalaryField.setText(Find.getSalary());
				NINField.setText(Find.getnatInscNo());
				EmailField.setText(Find.getEmail());
				JobField.setText(Find.getTitle());

				if (Find.getGender() == 'M') {
					Male.setSelected(true);
				} else {
					Female.setSelected(true);
				}

				String[] parts = Find.getDob().split("-");
				int day = Integer.parseInt(parts[0]);
				int month = Integer.parseInt(parts[1]);
				int year = Integer.parseInt(parts[2]);
				Day.setSelectedItem(day);
				Month.setSelectedItem(month);
				Year.setSelectedItem(year);

				String[] date = Find.getStartDate().split("-");
				int sday = Integer.parseInt(date[0]);
				int smonth = Integer.parseInt(date[1]);
				int syear = Integer.parseInt(date[2]);
				SDay.setSelectedItem(sday);
				SMonth.setSelectedItem(smonth);
				SYear.setSelectedItem(syear);
				
				}
		});

		// JRadioButton
		
		bg = new ButtonGroup();
		bg.add(Male);
		bg.add(Female);
		genderPanel.add(Male);
		genderPanel.add(Female);
		c.gridx = 1;
		c.gridy = 2;

		if (allemps.get(counter).getGender() == 'M') {
			Male.setSelected(true);
		} else {
			Female.setSelected(true);
		}

		add(genderPanel, c);

		// JComboBox ArrayList
		for (int i = 1; i <= 31; i++) {//here is a forloop which will insert the numbers used within the comboboxes
			Day.addItem(i);
			SDay.addItem(i);
		}
		for (int i = 1; i <= 12; i++) {
			Month.addItem(i);
			SMonth.addItem(i);
		}
		for (int i = 2016; i >= 1940; i--) {
			Year.addItem(i);
			SYear.addItem(i);
		}

		String[] parts = allemps.get(counter).getDob().split("-");
		int day = Integer.parseInt(parts[0]);
		int month = Integer.parseInt(parts[1]);
		int year = Integer.parseInt(parts[2]);
		Day.setSelectedItem(day);
		Month.setSelectedItem(month);
		Year.setSelectedItem(year);

		String[] date = allemps.get(counter).getStartDate().split("-");
		int sday = Integer.parseInt(date[0]);
		int smonth = Integer.parseInt(date[1]);
		int syear = Integer.parseInt(date[2]);
		SDay.setSelectedItem(sday);
		SMonth.setSelectedItem(smonth);
		SYear.setSelectedItem(syear);

		// JComboBox
		datePanel.add(Day);
		datePanel.add(Month);
		datePanel.add(Year);
		c.gridx = 1;
		c.gridy = 3;
		add(datePanel, c);

		sDateP.add(SDay);
		sDateP.add(SMonth);
		sDateP.add(SYear);
		c.gridx = 1;
		c.gridy = 9;
		add(sDateP, c);
		
		//Validation
		/**
		 * Here we have our validation section this will disable some of our buttons when their following fields are empty
		 */
		
		DocumentListener validation = new DocumentListener()
		{

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				 buttonChanged ();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				 buttonChanged ();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				 buttonChanged ();
				
			}
		
			public void buttonChanged (){ //disable the Insert and update button for when the following fields are empty
				if (NameField.getText().isEmpty() || PostcodeField.getText().isEmpty()
						|| EmailField.getText().isEmpty()) {
					
					Insert.setEnabled(false);
					Update.setEnabled(false);
					
				} else {
					Insert.setEnabled(true);
					Update.setEnabled(true);
				}
				
				if (IDField.getText().isEmpty())//disable the delete button
				{
					Delete.setEnabled(false);
				} else {
					Delete.setEnabled(true);
				}
				
				if (NameField.getText().isEmpty() && SalaryField.getText().isEmpty()//disable the clear button
						&& AddressField.getText().isEmpty() && PostcodeField.getText().isEmpty()
						&& NINField.getText().isEmpty() && EmailField.getText().isEmpty()
						&& JobField.getText().isEmpty()) {
					Clear.setEnabled(false);
				} else {
					Clear.setEnabled(true);
				}

			}
			
		};
		
		IDField.getDocument().addDocumentListener(validation);//the following fields that will be used as part of the validation required
		NameField.getDocument().addDocumentListener(validation);
		AddressField.getDocument().addDocumentListener(validation);
		PostcodeField.getDocument().addDocumentListener(validation);
		EmailField.getDocument().addDocumentListener(validation);
		NINField.getDocument().addDocumentListener(validation);
		SalaryField.getDocument().addDocumentListener(validation);
		JobField.getDocument().addDocumentListener(validation);

	}
}


