/*

INSERT PROGRAM HEADER HERE

*/
import java.io.*;
import java.util.Scanner;

public class JedidiahPrall_CalvinNguyen_05 {
	
   public static void main (String [] args) {
   
      final String INPUT_FILE = "2050 Project 05_Input.txt";
      
      try {
			File inputFile = new File(INPUT_FILE);
			Scanner scnr = new Scanner(inputFile);

			while (scnr.hasNextLine()) {
         
            try {
               Postfix p = new Postfix();
               String infix = scnr.nextLine();
               System.out.println(p.convertToPostfix(infix));
            } // End try
            
            catch (Exception e) {
               System.err.println(e.getMessage());
            } // End Catch
         } // End while

		} // End try
      catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} // End catch
   } // End main

}