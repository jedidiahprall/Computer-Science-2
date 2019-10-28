/**
 *A linked list class that implements MyCollectionInterface for project 4 
 *Calvin Nguyen and Osman Rakhimov
 *Linked List class
 *Eclipse Java IDE
 *insouciant:showing a casual lack of concern; indifferent.
 *"Life begin at the end of your Comfort Zone. So if you`re feeling uncomfortable right now, 
 *	know that the change taking place in your life is a begining, not an ending" - Neale Walsch, (9.1943)
 *@author Calvin Nguyen and Osman Rakhimov
 *@version project 4 
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
		
		Node newNode = new Node(newItem);
		
		newNode.next = head;
		head = newNode;
		
		if (head.equals(newNode)) {
			numberOfEntries ++;
		}
		return result;
		
	}
	
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
				}
				
				newNode.next = currentNode.next;
				currentNode.next = newNode;
				numberOfEntries++;
			}// end of if
		}
		else {
				throw new IndexOutOfBoundsException("Wrong position given");
			}
			return result;
	}
	
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
                 
              }
              if(currentNode != null){
                 numberOfEntries--;
                 result = true;
                 nodeBefore.setNextNode(nodeAfter);
                 currentNode.setNextNode(null);
              }
            }
            catch(NullPointerException e){
              System.err.println("Node is null");
            }
         }
        }
        catch(IllegalArgumentException e){
        System.err.println("No item found in list");
        }    
        return result;
	}

	
//*************************************************************************
	
    /**
     * Removes all entries from this collection.
     */
	
	public void clear() {
		head = null;
		numberOfEntries = 0;
	}
	
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
    	}
    	return listCount;
    }
	
//*************************************************************************  
    
    /**
     * Check to see if the collection is empty.
     *
     * @return True if the collection is empty, or false if not.
     */
	
	public boolean isEmpty() { //this
		result = false;
		
		if(numberOfEntries==0) {
			result = true;
		}
		return result;
	}// end of empty
	
//*************************************************************************     
    /**
     * Counts the number of times a given entry appears in this collection.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the collection.
     */
	
	public int getFrequencyOf(T anEntry) { //this
		Node<T> currentNode = new Node<T> (anEntry);
		int listCount=0;
		for(int i = 0; i<= numberOfEntries; i++) {
			if(anEntry.equals(currentNode.getData())) {
				listCount++;
			}
			currentNode = currentNode.getNextNode();
			
		}
		return listCount;
	}

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
			}// end of if
			
						
		}// end of while
		return result;
	}// end of contains

//************************************************************************* 
	   
    /**
     * Retrieves all entries that are in this collection.
     *
     * @return A newly allocated array of all the entries in the collection. 
     * Note: If the collection is empty, the returned array is empty.
     */
	
	public Object[] toArray() {
		Object[] thing =  new Object[numberOfEntries];
	      int index = 0;
	      Node<T> currentNode = head;
	      while((index < numberOfEntries) && (currentNode != null)){
	         thing[index] = currentNode.getData();
	         currentNode = currentNode.getNextNode();
	         index++;
	      }
	      return thing;   
	    
	    } // End of method
	
}
