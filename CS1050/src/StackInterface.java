public interface StackInterface <T> {
	
	/**
	 * Adds a new entry to the top of this stack.
	 * @param newEntry object to add to stack.
	 */
	public void push(T newEntry);
		
	/**
	 * Removes and returns this stack's top entry.
	 * @return either object at top of stack or, if stack is empty
	 * 	stack is empty before operation, null
	 */
	public T pop();
		
	/**
	 * Detects whether this stack is empty.
	 * @return true if the stack is empty.
	 */
	public T peek();
		
	/**
	 * Detects whether this stack is empty.
	 * @return true if the stack is empty
	 */
	public boolean isEmpty();
		
	/**
	 * Removes all entries from this stack.
	 */
	public void clear();
	
}// end StackInterface