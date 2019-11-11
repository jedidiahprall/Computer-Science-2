/**
 *Java implementation to convert infix expression to postfix using stack class
 *Jedidiah Prall and Calvin Nguyen 
 *Postfix Class
 *Eclipse Java IDE
 *Quixotic: Exceedingly idealistic; unrealistic and impractical.
 *"Don’t ruin a good day today by thinking about a bad yesterday. Let it go." — Grant Cardone, (3.1958) 
 *@author Jedidiah Prall and Calvin Nguyen 
 *@version Project 5
 *@class JedidiahPrall_CalvinNguyen_05
 */

public class Postfix { 
	
/************************************************************************************************************/	
	/** 
	 * A utility function to return precedence of a given operator with a higher returned value
	 * means higher precedence
	 * @param ch is the operator character
	 */
	
	static int precedence(char ch) 
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
   
   // Start of convertToPostfix
   
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
				while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
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
                                            " (Missing Close Parentheses)");
        }
            
		return result; 
		
	} // End of convertToPostfix
	
/************************************************************************************************************/	 
	// Start of checkBalance
	
	/** 
	 * Method to check the balanced parentheses for infix expression.
	 * @param expression is the infix expression.
	 * @return Returns true if the expression has balanced parentheses and will return
	 * false if the expression has unbalanced parentheses. 
	 */      
	
     public static boolean checkBalance(String expression) {

		StackInterface<Character> opEndelimiterStack = new OurStack<Character>();
		
		char nextCharacter;
		int characterCount = expression.length();
		boolean isBalanced = true;
		int index = 0;
		
		while (isBalanced  && (index < characterCount)) {
			
			nextCharacter = expression.charAt(index);
			switch (nextCharacter) {
				case '(': case '[': case '{':
				// Push nextCharacter on stack
				opEndelimiterStack.push(nextCharacter);
				break;
				case')': case ']': case '}':
					if (opEndelimiterStack.isEmpty()) { // if stack is empty
					isBalanced = false;
					} 
					else {
						char opEndelimiter = opEndelimiterStack.pop();
						//true or false according to whether opEndelimiter and
						// nextCharacter are a pair of delimiters
						isBalanced = isPaired(opEndelimiter, nextCharacter);
					
					} // End if
					break;
					default:
					break;
					
				} // End switch
			
			index++;
			
		} // End while
		
		if (!opEndelimiterStack.isEmpty()) { // stack is not empty
			isBalanced = false;
			
		} // End if
            return isBalanced;
            
	} // End checkBalance
        
/************************************************************************************************************/	 
	
     // Start of isPaired
     
     /**
	 * Method to check if there the expression form a pair of parentheses
	 * @param open is the open parentheses 
	 * @param close is the close parentheses
	 * @return Returns true if the given characters, open and close,
	 * form a pair of parentheses, brackets, or braces.
	 */
     
	private static boolean isPaired(char open, char close) {
		return  (open == '(' && close == ')') ||
				(open == '[' && close == ']') ||
				(open == '{' && close == '}'); 
		
	} // End isPaired

/************************************************************************************************************/	 

	// Start of main
	
	public static void main(String[] args) 
	{ 
	}// End of main
	
}  // End of Postfix