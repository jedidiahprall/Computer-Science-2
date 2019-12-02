
/**
 *To sort using both quick Sort and shell sort methods to sort 100 random integers from an input file and exported sorted array to an output file. 
 *Jedidiah Prall and Calvin Nguyen 
 *Eclipse Java IDE
 *Quixotic: Exceedingly idealistic; unrealistic and impractical.
 *"Don’t ruin a good day today by thinking about a bad yesterday. Let it go." — Grant Cardone, (3.1958) 
 *@author Jedidiah Prall and Calvin Nguyen 
 *@version Project 6
 *@class JedidiahPrall_CalvinNguyen_05
 */

import java.io.File; // Defines a file
import java.io.FileWriter; // Used to write to the output file
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter; // Used to print to the output file
import java.util.Scanner; // Input stream
import java.util.ArrayList; // Contains object arrays, used ONLY in generateReport method
import java.util.Arrays;
import java.io.BufferedReader;

public class JedidiahPrall_CalvinNguyen_06 {

	private static String INPUT_FILE = "Project_06_Input.txt"; // Input file, declared in main method
	private static String OUTPUT_FILE = "Project_06_Output.txt"; // Output file, declared in main method
	private static int length;
	private static int array[];
	private static int[] sortedArray ;
	private static int count = 0;
	private static PrintWriter output; // Output

	public static void main(String[] args) throws IOException {

		INPUT_FILE = "Project_06_Input.txt";
		OUTPUT_FILE = "Project_06_Output.txt";

		processInput();

		shellSort(sortedArray);

		quickSort(sortedArray);

		generateReport();

	}

	public static void processInput() throws IOException {

		int lineNum = 0;
		int length = 100;

		File file = new File("Project_06_Input.txt");

		Scanner fileReader;

		try {

			fileReader = new Scanner(file);

		} catch (FileNotFoundException e) {
			System.err.println("File \'" + INPUT_FILE + "\' not found.");
			return;

		}
		array = new int[length];
		sortedArray = new int[length];

		while (fileReader.hasNextInt()) {
			array[lineNum] = fileReader.nextInt();
			sortedArray[lineNum] = array[lineNum];
			lineNum++;
		}
		System.out.println("Original Array:");
		for (int i = 0; i < length; i++)
			System.out.print(array[i] + " ");

		fileReader.close();
		System.out.println("");

	}

	/************************************************************************************************************/
	// Start of shellSort method

	/**
	 * shellSort with organize the random numbers by
	 * 
	 * @param Array int array that holds all of the random numbers to be sorted.
	 */

	private static void shellSort(int[] sortedArray) {

		int increment = sortedArray.length / 2;
		while (increment > 0) {
			for (int i = increment; i < sortedArray.length; i++) {
				int j = i;
				int temp = sortedArray[i];
				while (j >= increment && sortedArray[j - increment] > temp) {
					sortedArray[j] = sortedArray[j - increment];
					j = j - increment;
				}
				sortedArray[j] = temp;
			}
			if (increment == 2) {
				increment = 1;
			} else {
				increment *= (5.0 / 11);
			}
		}

	}

	/************************************************************************************************************/
	// Start of quickSort method

	/**
	 * shellSort with organize the random numbers by
	 * 
	 * @param Array int array that holds all of the random numbers to be sorted.
	 */
	private static void quickSort(int[] sortedArray) {
		if (sortedArray == null || sortedArray.length == 0) {
			return;
		}
		sortedArray = sortedArray;
		length = sortedArray.length;
		sort(0, sortedArray.length - 1);

	}

	/************************************************************************************************************/
	// Start of sort method

	/**
	 * sort method will iterate through the array comparing both the low and high
	 * index to the pivot
	 * 
	 * @param Array int array that holds all of the random numbers to be sorted.
	 */
	private static void sort(int lowIndex, int highIndex) {
		int low = lowIndex;
		int high = highIndex;
		int pivot = array[low + (high - low) / 2];

		while (low <= high) {
			while (array[low] < pivot) {
				low++;
			}
			while (array[high] > pivot) {
				high--;
			}
			if (low <= high) {
				swap(low, high);
				low++;
				high--;
			}
		}
		if (low < high)
			sort(lowIndex, high);
		if (low < high) {
			sort(low, highIndex);
		}

	}

	/************************************************************************************************************/
	// Start of swap method

	/**
	 * swap method with switch the lowIndex with the highIndex of the array when
	 * called.
	 * 
	 * @param Array int array that holds all of the random numbers to be sorted.
	 */

	private static void swap(int lowIndex, int highIndex) {
		int temp = array[lowIndex];
		array[lowIndex] = array[highIndex];
		array[highIndex] = temp;
	}

	/************************************************************************************************************/
	// Start of generateReport method

	/**
	 * generateReport method with write the sorted int array onto an output file
	 * with desired output.
	 * 
	 * @param Array int array that holds all of the random numbers to be sorted.
	 */
	public static void generateReport() throws IOException {
		File creation = new File("Project_06_Output1.txt");
		try {
			output = new PrintWriter(creation);

			output.println("ShellSort array: ");
			for (int j = 0; j < sortedArray.length; j++) {
				if (j % 10 == 0 && j > 0) {
					output.println();
				}
				output.print(sortedArray[j] + " ");
			}

			output.close();

		} catch (IOException ex) {
			System.out.printf("Error: unable to export data to file $s\n", ex);
		}

		File creation2 = new File("Project_06_Output2.txt");
		try {
			output = new PrintWriter(creation2);

			output.println("Quick Sort array: ");
			for (int j = 0; j < sortedArray.length; j++) {
				if (j % 10 == 0 && j > 0) {
					output.println();
				}
				output.print(sortedArray[j] + " ");
			}
			output.close();
		} catch (IOException ex) {
			System.out.printf("Error: unable to export data to file $s\n", ex);
		}
	}
}