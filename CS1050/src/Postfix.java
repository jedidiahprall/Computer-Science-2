/* Java implementation to convert infix expression to postfix*/
// Note that here we use Stack class for Stack operations 

public class Postfix 
{ 
	// A utility function to return precedence of a given operator 
	// Higher returned value means higher precedence 
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
	
	// The main method that converts given infix expression 
	// to postfix expression. 
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
         }
         
         // If the scanned character is an operand, add it to output. 
			else if (Character.isLetterOrDigit(c)) { 
				result += c; 
            variableCount += 1;
         }
			
			// If the scanned character is an '(', push it to the stack. 
			else if (c == '(') {
				stack.push(c);
         } 
			
			// If the scanned character is an ')', pop and output from the stack 
			// until an '(' is encountered. 
			else if (c == ')') 
			{ 
				while (!stack.isEmpty() && stack.peek() != '(') {
					result += stack.pop(); 
				} // End while
				if (!stack.isEmpty() && stack.peek() != '(') {
					return "Invalid Expression";
            } // End if			 
				else {
					stack.pop(); 
            } // End else
			} // End if
			else // an operator is encountered 
			{ 
				while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
					result += stack.pop();
            } 
				   stack.push(c); 
               variableCount -=1;
            
			} 
         
         if (variableCount > 1) {
           stack.clear();
           throw new IllegalArgumentException("None. Invalid syntax.");
           
         }

	
		} // End for 
	
		// pop all the operators from the stack 
	 
     while (!stack.isEmpty()) { 
         result += stack.pop(); 
      }
	
		return result; 
	} 
	
	// Driver method 
	public static void main(String[] args) 
	{ 
		String exp = "( a +b   * c^ d ) ^( e* f- g  h)"; 
		System.out.println(convertToPostfix(exp)); 
	}
} 