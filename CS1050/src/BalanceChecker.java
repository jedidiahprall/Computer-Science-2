public class BalanceChecker {
	
	/**
	 * Decides whether the parentheses, brackets, and braces in a string
	 * occur in left/right pairs.
	 * @param expression A string to be checked
	 * @return True if the delimiters are paired correctly
	 */
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

}