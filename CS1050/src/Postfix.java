/**
 *Java implementation to convert infix expression to postfix using stack class
 *Jedidiah Prall and Calvin Nguyen 
 *ourStack Class
 *Eclipse Java IDE
 *Quixotic: Exceedingly idealistic; unrealistic and impractical.
 *"Don’t ruin a good day today by thinking about a bad yesterday. Let it go." — Grant Cardone, (3.1958) 
 *@author Jedidiah Prall and Calvin Nguyen 
 *@version Project 5
 *@class JedidiahPrall_CalvinNguyen_05
 */

public class Postfix 
{ 
/************************************************************************************************************/	
	/** 
	 * Checks second position of the array for "ADD", If valid will store references in student2 and will 
	 * A utility function to return precedence of a given operator with a higher returned value means higher precedence 
	 */
	public static void Postfix() {
   }
   
   static int Prec(char ch) 
	{ 
		switch (ch) 
		{ 
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
	/** 
	 * Method that converts given infix expression to postfix expression
	 * @param inputExpression is the infix expression
	 */
	public static String convertToPostfix(String inputExpression) throws IllegalArgumentException 
	{ 
		// initializing empty String for result 
		String result = new String(""); 
		
		// initializing empty stack 
		OurStack<Character> stack = new OurStack<>(); 
      int variableCount = 0;
		
      
      for (int i = 0; i<inputExpression.length(); i++) {
       
         char c = inputExpression.charAt(i); 
         			
			if (Character.isWhitespace(c)) {
            continue;
         } // End of if
         
         // If the scanned character is an operand, add it to output. 
			else if (Character.isLetterOrDigit(c)) { 
				result += c; 
            variableCount += 1;
         } // End of else if
			
			// If the scanned character is an '(', push it to the stack. 
			else if (c == '(') {
				stack.push(c);
         } // End of else if
			
			// If the scanned character is an ')', pop and output from the stack 
			// until an '(' is encountered. 
			else if (c == ')') 
			{ 
				while (!stack.isEmpty() && stack.peek() != '(') {
					result += stack.pop(); 
				} // End  of while loop
				if (!stack.isEmpty() && stack.peek() != '(') {
					return "Invalid Expression";
            } // End of if			 
				else {
					stack.pop(); 
            } // End of else
			} // End of if
			else // an operator is encountered 
			{ 
				while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
					result += stack.pop();
            } // End of while
				   stack.push(c); 
               variableCount -=1;
            
			} // End of for loop
         
         if (variableCount > 1) {
           stack.clear();
           throw new IllegalArgumentException("  None. Invalid syntax. (Missing Operator)");
           
         }

	
		} // End of for loop
	
		// pop all the operators from the stack 
	 
     while (!stack.isEmpty()) { 
         result += stack.pop(); 
      } // End of while loop
 	
     boolean balance;
        balance = checkBalance(result);
        
        if (balance == false) {
                throw new IllegalArgumentException("  None Invalid Syntax." +
                                            " Missing Close Parentheses.");
        }
            
		return result; 
	} 
        
        public static boolean checkBalance(String expression) {
		
		StackInterface<Character> openDelimiterStack = new OurStack<Character>();
		
		char nextCharacter;
		int characterCount = expression.length();
		boolean isBalanced = true;
		int index = 0;
		
		while (isBalanced  && (index < characterCount)) {
			
			nextCharacter = expression.charAt(index);
			switch (nextCharacter) {
				case '(': case '[': case '{':
				// Push nextCharacter on stack
				openDelimiterStack.push(nextCharacter);
				break;
				case')': case ']': case '}':
					if (openDelimiterStack.isEmpty()) { // if stack is empty
					isBalanced = false;
					} 
					else {
						char openDelimiter = openDelimiterStack.pop();
						//true or false according to whether openDelimiter and
						// nextCharacter are a pair of delimiters
						isBalanced = isPaired(openDelimiter, nextCharacter);
					
					} // end if
					break;
					default:
					break;
				} // end switch
			index++;
		} // end while
		if (!openDelimiterStack.isEmpty()) { // stack is not empty
			isBalanced = false;
			//return isBalanced;
		} // end if
            return isBalanced;
	} // end checkBalance
	
	/**
	 * Returns true if the given characters, open and close,
	 * form a pair of parentheses, brackets, or braces.
	 * @param open
	 * @param close
	 * @return
	 */
	private static boolean isPaired(char open, char close) {
		return  (open == '(' && close == ')') ||
				(open == '[' && close == ']') ||
				(open == '{' && close == '}'); 
	} // end isPaired

	
	// Driver method 
	public static void main(String[] args) 
	{ 
		//String exp = "( a +b   * c^ d ) ^( e* f- g  h)"; 
		//System.out.println(convertToPostfix(exp)); 
	}
}  