/**
 *Java implementation to convert infix expression to postfix using stack class
 *Jedidiah Prall and Calvin Nguyen 
 *OurStack Class
 *Eclipse Java IDE
 *Quixotic: Exceedingly idealistic; unrealistic and impractical.
 *"Don’t ruin a good day today by thinking about a bad yesterday. Let it go." — Grant Cardone, (3.1958) 
 *@author Jedidiah Prall and Calvin Nguyen 
 *@version Project 5
 *@class JedidiahPrall_CalvinNguyen_05
 */

import java.util.EmptyStackException;

public class OurStack<T> implements StackInterface<T> {

	private T[] stack;		                        // Array of stack entries
	private int topIndex;	                        // Index of top entry
	private boolean initialized = false;            // Initialized boolean
	private static final int DEFAULT_CAPACITY = 50; // Default Capacity for stack
	private static final int MAX_CAPACITY = 10000;  // Maximum Capacity for stack
	
   //*************************************************************************
	/**
	 * Creates a new stack
	 */
	
   public OurStack() {
		@SuppressWarnings("unchecked")
      T[] tempStack = (T[])new Object[DEFAULT_CAPACITY];
		stack = tempStack;
      topIndex = 0;
      initialized = true;
	} // end default constructor
	
   //*************************************************************************
   /**
    * Creates a stack that already has a capacity
	 *@param initial Capacity 
	 */
   
   public OurStack(int initialCapacity) {
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack = tempStack;
		topIndex = 0;
		initialized = true;
		
	} // end constructor
	
   //*************************************************************************
   
   // Start of Push
   
   /**
	 * Adds a new entry to the top of this stack.
	 * @param newEntry object to add to stack.
	 */
   
	public void push(T newEntry) {
		
		stack[topIndex + 1] = newEntry;
		topIndex++;
		
	} // end push

	//*************************************************************************
	
	// Start of pop
	
	/**
	 * Removes and returns this stack's top entry.
	 * @return either object at top of stack or, if stack is empty
	 * 	stack is empty before operation, null
	 */
	
	public T pop() {
		
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		}
	} // end pop
	
	//*************************************************************************
	
	// Start of peek
	
	/**
	 * Detects whether this stack is empty.
	 * @return true if the stack is empty.
	 */
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return stack[topIndex];
		} 
	} // end peek
	
	//*************************************************************************
	
	// Start of isEmpty
	
	/**
	 * Detects whether this stack is empty.
	 * @return true if the stack is empty
	 */
	public boolean isEmpty() {
		return topIndex < 1;
		
	} // end isEmpty
	
	//*************************************************************************
	
	// Start of clear
	
	/**
	 * Removes all entries from this stack.
	 */
	public void clear() {
		topIndex = 0;
		
	} // End of clear

} // End of OurStack