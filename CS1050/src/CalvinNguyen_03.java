/**
 *Runs a series of tests to make sure that the Student and GradeItem Class are working properly 
 *Calvin Nguyen and Nestor Ayla
 *Project 3
 *Eclipse Java IDE
 *fulminate: denounce forcefully.
 *"You can't make decisions based on fear and the possibility of what might happen." - Michelle Obama, (1.1964)
 *@author Calvin Nguyen and Nestor Ayla
 *@version project 3 
 *@class CalvinNguyen_03
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalvinNguyen_03 {

	// Variables

	private static List<Student> listOfStudents;
	private static List<GradeItem> listOfGradeItems;
	final static String INPUT_FILE = "Project_03_Input02.txt";
	final static String OUTPUT_FILE = "Project_03_Output02.txt";
	private static String[] splitter;
	private static PrintWriter output; // Output
	private static Student student; // Student 2
	private static GradeItem gradeItem; // Grade Item 1

/************************************************************************************************************/

	public static void main(String[] args) throws IOException {
		
		// Initialize List
	
		listOfGradeItems = new ArrayList<GradeItem>(); 
		listOfStudents = new ArrayList<Student>();
 
		// Calling methods
		
		processInput();

		generateReport();

	}

/************************************************************************************************************/
	// Start of processInput method
	/**
	 * processInput method scans the input file and uses the split method to split 
	 * the input data by "," and process either studentData or GradeItemData if the
	 * first item starts with "student" or Grade "Item"
	 * @throws IOException
	 */
	
	
	public static void processInput() throws IOException {
		File INPUT_FILE = new File("Project_03_Input02.txt"); // Importing the file.

		Scanner scan;
		String t1 = "";

		try                                                  // Uses Scanner to check if the file exists or not.
		{
			scan = new Scanner(INPUT_FILE);
			System.err.println("Reading data from file " + INPUT_FILE);

		} catch (FileNotFoundException e) {

			System.err.println("File not found");

			return;

		}
		while (scan.hasNextLine()) {                       	 /* Scanner continues scanning even if there is an empty 
										                       space.*/
			t1 = scan.nextLine();
			if (t1.isEmpty()) {
				continue;
			} // End of if statement

			splitter = t1.split(",");

			if (splitter[0].equals("STUDENT")) {
				processStudentData(splitter);
				
			} // End of if statement

			else if (splitter[0].equals("GRADE ITEM")) {
				processGradeItemData(splitter);

			} // End of else if statement
			
			else {
				throw new IOException("Text file does not start with Student or Grade Item");
			} // End of else statement
			
		} // End of while loop
		
	} // End of processInput method

/************************************************************************************************************/
	// Start of processStudentData method

	/**
	 * processStudentData checks second position of the array for "ADD" or "DEL", If valid
	 * will determine whether the object is is added or removed from the list. 
	 * Will throw exception if it is not.
	 * 
	 * @param splitter String array that identifies the items from the text file.
	 * @throws IllegalArgumentException
	 */

	public static void processStudentData(String[] splitter) throws IllegalArgumentException {


		if (splitter[1].equals("ADD")) {

				try {
					student = new Student(splitter[2], splitter[3], splitter[4], splitter[5]);
				} // End of try 

				catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());  // Returns exceptions message
					return;
				} // End of catch

			if (listOfStudents.contains(student)) {
				
				System.err.println("Student with Student ID " + splitter[2] + " is already in the list");
				
				} // End of if statement
			
			else {
				
				listOfStudents.add(student);
				System.err.println("Student with Student ID " + splitter[2] + " was added to the list.");
				
			} // End of else Statement

		} // End of if Statement

		else if (splitter[1].equals("DEL")) {


				try {
					student = new Student(splitter[2], splitter[3], splitter[4], splitter[5]);
					
				} // End of try

				catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());  // Returns exceptions message
					return;
				} // End of catch

			if (listOfStudents.contains(student)) {
				
				listOfStudents.remove(student);
				System.err.println("Student with Student ID " + splitter[2] + " was removed from the list.");
				
				} // End of if statement
			
			else {
				
				System.err.println("Student with Student ID " + splitter[2] + " was not removed from the list");
				
			} // End of else statement
			
		} // End of else if statement 
		
		else {

			throw new IllegalArgumentException(
					"The second postions has: " + splitter[1] + " instead of  ' ADD' or 'DEL" + " in the textfile");

		} //End of else statement

	} // End of if Statement

	// End of processStudentData method

/************************************************************************************************************/

	// Start of porcessGradeItemData method

	/**
	 * processGradeItemData checks second position of the array for "ADD" or "DEL", If valid
	 * will determine whether the object is is added or removed from the list. 
	 * Will throw exception if it is not.
	 * 
	 * @param splitter String array that identifies the items from the text file.
	 * @throws IllegalArgumentException
	 */
	
	public static void processGradeItemData(String[] splitter) throws IllegalArgumentException {

		if (splitter[1].equals("ADD")) {

				try {
					gradeItem = new GradeItem(splitter[3], Integer.parseInt(splitter[2]), splitter[4], splitter[5],
							splitter[6], Integer.parseInt(splitter[7]), Integer.parseInt(splitter[8].trim()));
				} // End of Try

				catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());

				} // End of catch
				
			if (listOfGradeItems.contains(gradeItem)) {
				System.err.println(
						"Grade Item with Grade Item ID " + Integer.parseInt(splitter[2]) + " is already in the list.");
			} // End of if statement
			
			else {

				listOfGradeItems.add(gradeItem);
				System.err.println(
						"Grade Item with Grade Item ID " + Integer.parseInt(splitter[2]) + " was added to the list.");
			} // End of else

		}

		else if (splitter[1].equals("DEL")) {

			try {
				gradeItem = new GradeItem(splitter[3], Integer.parseInt(splitter[2]), splitter[4], splitter[5],
						splitter[6], Integer.parseInt(splitter[7]), Integer.parseInt(splitter[8].trim()));
			} // End of try

			catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
			} // End of catch
			
			if (listOfGradeItems.contains(gradeItem)) {
				listOfGradeItems.remove(gradeItem);
				System.err.println("Grade Item with Grade Item ID " + Integer.parseInt(splitter[2])
						+ " was removed from the list.");
			} // End of if statement
			
			else {
				System.err.println("Was unable to remove gradeItem object to the list");
				
			} // End of else statement
			
		} else {

			throw new IllegalArgumentException(
					"The second postions has: " + splitter[1] + " instead of  ' ADD' or 'DEL" + " in the textfile");

		} //End of else statement

	}

	// End of test 2b method

/************************************************************************************************************/
	
	// Start of generateReport method
	
	/**
	 * generateReport method calls toArray method from list class and is used to sort, print, and format all
	 * Student and GradeItem Objects, onto a output file.
	 * @throws IOException
	 */
	
	public static void generateReport() throws IOException {

		Student tempStudent = new Student("Number", "First", "last", "email@gmail.com");

		Object[] studentObjects = listOfStudents.toArray();

		GradeItem tempGradeItem = new GradeItem("studentID", 1, "course", "HW", "data", 100, 95);

		Object[] gradeItemObjects = listOfGradeItems.toArray();

		File OUTPUT_FILE = new File("Project_03_Output02.txt");     // Generates report to output file
		System.out.print("Generating Report to file " + OUTPUT_FILE);
		
		try {
			output = new PrintWriter(OUTPUT_FILE);                  

		} catch (IOException ex) {
			System.out.printf("Error: unable to export data to file $s\n", ex);

		}

		// Format Header
		
		output.println("StudentID  FirstName  LastName  Email" + "\n  Grade Items\n" 
				+ "  GradeItemID  CourseID  Type  Date "
				+ " Maximum Score   Actual Score    Grade (%)*");
		output.println("==================================================================================="
				+ "\n  Total                           SumOfMaxScore   SumActualScore" + "    Grade (%)");

		// Output report

		for (int i = 0; i < studentObjects.length; i++) {
			
			int totalMaximumScore = 0;
			int totalActualScore = 0;
			
			
			if (studentObjects[i] instanceof Student) {            // check if object actually works with student
				tempStudent = (Student) studentObjects[i];

				output.printf("\n%s    %s    %s   %s\n"
						
						,tempStudent.getStudentID(), tempStudent.getFirstName(),
						tempStudent.getLastName(), tempStudent.getEmail());
				
				output.println("   Grade Items");

				for (int t = 0; t < gradeItemObjects.length; t++) {
					
					if (gradeItemObjects[t] instanceof GradeItem) { // check if object actually works with student
						
						tempGradeItem = (GradeItem) gradeItemObjects[t];

						if (tempStudent.getStudentID().equals(tempGradeItem.getStudentID())) {
							
							output.printf("   %s\t%s\t%-8s\t%4s\t%s\t%s\n",
									tempGradeItem.getGradeItemID(), tempGradeItem.getCourse(),
									tempGradeItem.getItemTypes(),tempGradeItem.getDate(), 
									tempGradeItem.getMaximumScore(), tempGradeItem.getActualScore());
							
							totalMaximumScore += tempGradeItem.getMaximumScore();
							totalActualScore += tempGradeItem.getActualScore();
							
						} // End of if statement

					} // End of if
					
				} // End of for loop
				
				double gradePercentage = ((double)totalActualScore / totalMaximumScore) * 100;
				
				output.println("======================================================================================");
				output.printf("\tTotal%38s\t%s\t", totalMaximumScore, totalActualScore);
				output.printf("%.1f", gradePercentage);
				output.print("%");
				output.println(" ");
			}
		}
		
		output.close();
		System.out.print("... done.");
	
	} // End of generateReport method 
	

	/************************************************************************************************************/
}
