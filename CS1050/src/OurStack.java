import java.util.EmptyStackException;

public class OurStack<T> implements StackInterface<T> {

	private T[] stack;		// Array of stack entries
	private int topIndex;	// Index of top entry
	private boolean initialized = false;
	//private int topNode = 0;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
   //*************************************************************************
	
   public OurStack() {
		@SuppressWarnings("unchecked")
      T[] tempStack = (T[])new Object[DEFAULT_CAPACITY];
		stack = tempStack;
      topIndex = 0;
      initialized = true;
	} // end default constructor
	
   //*************************************************************************
	
   public OurStack(int initialCapacity) {
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack = tempStack;
		topIndex = 0;
		initialized = true;
	} // end constructor
	
   //*************************************************************************
	
	/**
	 * @param newEntry
	 */
	public void push(T newEntry) {
		
		stack[topIndex + 1] = newEntry;
		topIndex++;
	} // end push

	//*************************************************************************
	
	/**
	 * @return
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
	 * @return
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
	 * @return
	 */
	public boolean isEmpty() {
		return topIndex < 1;
	} // end isEmpty
	//*************************************************************************
	/**
	 * @return
	 */
	public void clear() {
		topIndex = 0;
	}

	

}