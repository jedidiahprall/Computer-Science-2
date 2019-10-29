/**
 *A linked list class that implements MyCollectionInterface for project 4 
 *Calvin Nguyen and Osman Rakhimov
 *Linked List class
 *Eclipse Java IDE
 *insouciant:showing a casual lack of concern; indifferent.
 *"Life begin at the end of your Comfort Zone. So if you`re feeling uncomfortable right now, 
 *	know that the change taking place in your life is a beginning, not an ending" - Neale Walsch, (9.1943)
 *@author Calvin Nguyen and Osman Rakhimov
 *@version Project 4 
 *@class LinkedList
 */

public class LinkedList<T> implements MyCollectionInterfaceProject04<T> {
	private Node<T> head;
	private Node<T> currentNode = head;
	private Node<T> nodeBefore;
	private Node<T> nodeAfter;
	private int numberOfEntries;
	private boolean result = false;
	
//************************************************************************* 	
	/**
	  * Adds a new entry to this collection
	  * 
	  * @param newItem The object to be added to the collection
	  * @return True if the addition is successful, or false if not.
	  */
	
	public boolean add(T newItem) {
		Node<T> newNode = new Node<T>(newItem);
		newNode.next = head;
		head = newNode;
		
		if (head.equals(newNode)) {
			numberOfEntries ++;
			
		} // End of if statement
		
		return result;
		
	} // End of add method
	
//*************************************************************************  
    /**
     * Adds a new entry to this collection at the given position
     * 
     * @param newItem The object to be added to the collection
     * @param position The location where newItem will be inserted.
     * @return True if the addition is successful, or false if not.
     */
	
	public boolean add(T newItem, int givenPosition) {
		result = false;
		
		if((givenPosition >= 0) && (givenPosition <= numberOfEntries)) {
			
			Node<T> newNode = new Node<T> (newItem);
			
			if (givenPosition == 0) {
				newNode.next = head;
				head = newNode;
				numberOfEntries ++;
				add(newItem);
				result = true;
			}

			else {
				Node<T> currentNode = head;
				
				for (int i = 1;i < givenPosition; i++) {
					currentNode = currentNode.next;
					
				} // End of for loop
				
				newNode.next = currentNode.next;
				currentNode.next = newNode;
				numberOfEntries++;
				
			} // End of if statement
			
		} // End of if statement
		
		else {
				throw new IndexOutOfBoundsException("Wrong position given");
				
			} // End of if statement		
		
			return result;
			
	} // End of add
	
 //*************************************************************************
    
 	/**
 	 * Removes one occurrence of a given entry from this collection.
 	 *
 	 * @param anEntry The entry to be removed.
 	 * @return True if the removal was successful, or false if not.
 	 */
	

	public boolean remove(T anEntry) {
		result = false;
        currentNode = head;
        nodeBefore = null;
        nodeAfter = null;
        
        try{
        if(isEmpty()){
           throw new IllegalArgumentException("List is empty");
        }
        nodeAfter = head.getNextNode();
        if(currentNode.getData().equals(anEntry)){
           head = currentNode.getNextNode();
           result = true;
           numberOfEntries--;
        }
        else{
           try{
              while(currentNode != null && !currentNode.getData().equals(anEntry)){
                 nodeBefore = currentNode;
                 currentNode = currentNode.getNextNode();
                 nodeAfter = currentNode.getNextNode();
                 
              } // End of while loop
              
              if(currentNode != null){
                 numberOfEntries--;
                 result = true;
                 nodeBefore.setNextNode(nodeAfter);
                 currentNode.setNextNode(null);
                 
              } // End of if statement
              
            } // End of try statement
            catch(NullPointerException e){
              System.err.println("Node is null");
              
            } // End of try-catch
           
         } // End of if statement
        
        } // End of try-catch 
        catch(IllegalArgumentException e){
        System.err.println("No item found in list");
        
        } // End of try-catch  
        
        return result;
        
	} // End of remove method

	
//*************************************************************************
	
    /**
     * Removes all entries from this collection.
     */
	
	public void clear() {
		head = null;
		numberOfEntries = 0;
		
	} // End of clear method
	
//*************************************************************************
	
	 /**
     * Gets the current number of entries in this collection.
     *
     * @return The integer number of entries currently in the collection.
     */

	public int getCurrentSize() { 
		Node <T> current = head;
		int listCount=0;
		
    	while (current.next != null) {
    		listCount +=1;
    		current = current.next;	
    		
    	} // End of while loop
    	
    	return listCount;
    	
    } // End of getCurrentSize method
	
//*************************************************************************  
    
    /**
     * Check to see if the collection is empty.
     *
     * @return True if the collection is empty, or false if not.
     */
	
	public boolean isEmpty() { 
		result = false;
		
		if(numberOfEntries==0) {
			result = true;
			
		} // End of if statement
		
		return result;
		
	}// End of isEmpty method
	
//*************************************************************************     
    /**
     * Counts the number of times a given entry appears in this collection.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the collection.
     */
	
	public int getFrequencyOf(T anEntry) { 
		Node<T> currentNode = new Node<T> (anEntry);
		int listCount=0;
		
		for(int i = 0; i<= numberOfEntries; i++) {
			if(anEntry.equals(currentNode.getData())) {
				listCount++;
				
			} // End of if statement
			
			currentNode = currentNode.getNextNode();
			
		} // End of for loop
		
		return listCount;
		
	} // End of getFrequecncyOf method

//************************************************************************* 
    
    /**
     * Tests whether this collection contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if the collection contains anEntry, or false if not.
     */
	
	public boolean contains(T anEntry) {
		result = false;
		Node<T> currentNode = head;
		
		while(!result && (currentNode != null)) {
			if(anEntry.equals(currentNode.getData())) {
				result = true;
			}
			else {
				currentNode = currentNode.getNextNode();
				
			}// End of if statement
			
						
		} // End of while loop
		
		return result;
		
	} // End of contains method

//************************************************************************* 
	   
    /**
     * Retrieves all entries that are in this collection.
     *
     * @return A newly allocated array of all the entries in the collection. 
     * Note: If the collection is empty, the returned array is empty.
     */
	
	public Object[] toArray() {
		Object[] array =  new Object[numberOfEntries];
	    int index = 0;
	    Node<T> currentNode = head;
	      
	    while((index < numberOfEntries) && (currentNode != null)){
	        array[index] = currentNode.getData();
	        currentNode = currentNode.getNextNode();
	        index++;
	         
	      } // End of while loop 
	      
	      return array;   
	    
	    } // End of method
	
}
