/**
 *To convert infix expressions from input file and display their postfix using a stack class
 *Jedidiah Prall and Calvin Nguyen 
 *Stack Class
 *Eclipse Java IDE
 *Quixotic: Exceedingly idealistic; unrealistic and impractical.
 *"Don’t ruin a good day today by thinking about a bad yesterday. Let it go." — Grant Cardone, (3.1958) 
 *@author Jedidiah Prall and Calvin Nguyen 
 *@version Project 5
 *@class JedidiahPrall_CalvinNguyen_05
 */
import java.io.*;
import java.util.EmptyStackException;
import java.util.Scanner;

public class JedidiahPrall_CalvinNguyen_05 {
	
   public static void main (String [] args) {
   
      final String INPUT_FILE = "2050 Project 05_Input.txt";
      
      try {
			File inputFile = new File(INPUT_FILE);
			Scanner scnr = new Scanner(inputFile);
			System.out.printf("Infix Expresssion  %45s%n", "Postfix Expression");
			while (scnr.hasNextLine()) {
         
            try {
               Postfix p = new Postfix();
               String infix = scnr.nextLine();
               System.out.printf("\n%-44s", infix);
               System.out.printf("  %s", p.convertToPostfix(infix));
            } // End of try
            
            catch (Exception e) {
               System.err.println(e.getMessage());
            } // End of catch
         } // End of while

		} // End of try
      catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} // End of catch
   } // End of main

} // End of JedidiahPrall_CalvinNguyen_05
