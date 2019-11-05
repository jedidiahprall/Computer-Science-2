import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
import java.util.List;

public class CalvinNguyen_05 {

	private static String[] expression;
	private static List<String> exp = new ArrayList<>();
	private static String t1 = "";

	public static void main(String[] args) throws IOException {
//   String exp = "((( a +b   * c^ d )) ^( e* f– g ^h))";
//     System.out.println("Infix Expression: " + exp);
//     System.out.println("Postfix Expression: " + infixToPostFix(exp));

		processInput();
		processPostFix();
	}

	/**
	 * @return
	 **********************************************************************************************************/
	public static void processInput() throws IOException {
		File INPUT_FILE = new File("Project_5_Infix.txt"); // Importing the file.

		Scanner scan;

		try // Uses Scanner to check if the file exists or not.
		{
			scan = new Scanner(INPUT_FILE);
			System.err.println("Reading data from file " + INPUT_FILE);

		} catch (FileNotFoundException e) {

			System.err.println("File not found");

			return;

		}
		while (scan.hasNextLine()) { /*
										 * Scanner continues scanning even if there is an empty space.
										 */
			t1 = scan.nextLine();
			exp.add(t1);

		} // End of while loop

	} // End of processInput method

	/************************************************************************************************************/

	public static int precedence(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}

	/************************************************************************************************************/

	public static String infixToPostFix(String expression) {

		String result = "";
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);

			// check if char is operator
			if (precedence(c) > 0) {
				while (stack.isEmpty() == false && precedence(stack.peek()) >= precedence(c)) {
					result += stack.pop();
				}
				stack.push(c);
			} else if (c == ')') {
				char x = stack.pop();
				while (x != '(') {
					result += x;
					try {
						x = stack.pop();
					} catch (EmptyStackException e) {
					}
				}
			} else if (c == '(') {
				stack.push(c);
			} else {
				// character is neither operator nor (
				result += c;
			}
		}
		for (int i = 0; i <= stack.size(); i++) {
			result += stack.pop();
		}
		return result;
	}

/************************************************************************************************************/

	public static void processPostFix() throws IOException {
		
		System.out.println("Infix Expression                              Postfix Expression"); // 30 spaces
		
		for (int i = 0; i < exp.size(); i++) {
			System.out.printf("\n%-44s", exp.get(i));
			try {
//				System.out.println("Infix Expression: " + exp.get(i));
				
				String expression = exp.get(i).replaceAll("\\s","");
				
				System.out.printf("  %s", infixToPostFix(expression));
				
//				System.out.println("Postfix Expression: " + infixToPostFix(expression));
				
			} catch (EmptyStackException e) {
				
				System.err.println("  None. Invalid syntax. (What’s missing?)");


			}
			continue;
		}
	}

}
