import java.util.EmptyStackException;

public class OurStack<T> implements StackInterface<T> {

	private T[] stack;		// Array of stack entries
	private int topIndex;	// Index of top entry
	private boolean initialized = false;
	//private int topNode = 0;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
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
   /**
	 * Adds a new entry to the top of this stack.
	 * @param newEntry object to add to stack.
	 */
   
	public void push(T newEntry) {
		
		stack[topIndex + 1] = newEntry;
		topIndex++;
	} // end push

	//*************************************************************************
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
	/**
	 * Detects whether this stack is empty.
	 * @return true if the stack is empty
	 */
	public boolean isEmpty() {
		return topIndex < 1;
	} // end isEmpty
	//*************************************************************************
	/**
	 * Removes all entries from this stack.
	 */
	public void clear() {
		topIndex = 0;
	}

	

}