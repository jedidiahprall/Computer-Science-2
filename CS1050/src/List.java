//import javax.xml.soap.Node;

/**
 *A list class that implements MyCollectinoInterface for project 4 
 *Calvin Nguyen and 
 *list class
 *Eclipse Java IDE
 *fulminate: denounce forcefully.
 *"You can't make decisions based on fear and the possibility of what might happen." - Michelle Obama, (1.1964)
 *@author Calvin Nguyen and Nestor Ayla
 *@version project 3 
 *@class CalvinNguyen_03
 */


public abstract class List<T> implements MyCollectionInterfaceProject04<T>{
	Node head;
	Node tail;
	Node curr;
	int listCount;
	/**
     * Adds a new entry to this collection
     * 
     * @param newItem The object to be added to the collection
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newItem) {
    	if (head==null) {
    		head = new Node(newItem);
    	}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next= new Node(newItem);
		return true;
	}
    
 public boolean add (T newItem, int position) {
   
 	return false;
}
 
 /**
  * Removes one occurrence of a given entry from this collection.
  *
  * @param anEntry The entry to be removed.
  * @return True if the removal was successful, or false if not.
  */
    public boolean remove (T anEntry) {
		Node current = head;
		while (current.next != null) {
			current = current.next;
			if (current.next.data==anEntry) {
				current=current.next.next;
				return true;
			}
		}
		return false;
    }
    
    /**
     * Removes all entries from this collection.
     */
    
    public void clear() {
    	head = null;
    	
    }
    
    
    /**
     * Gets the current number of entries in this collection.
     *
     * @return The integer number of entries currently in the collection.
     */
    public int getCurrentSize() {
    	int size =0;
    	Node current = head;
    	while (current.next != null) {
    		size +=1;
    		current = current.next;		
    	}
    	return size;
    }
    
    
    /**
     * Check to see if the collection is empty.
     *
     * @return True if the collection is empty, or false if not.
     */
    public boolean isEmpty() {
    	if (head==null) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * Counts the number of times a given entry appears in this collection.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the collection.
     */
    public int getFrequencyOf(T anEntry) {
    	int frequency = 0;
    	Node current = head;
    	while (current.next != null) {
    		if (current.next.data == anEntry) {
    			frequency += 1;
    			current = current.next;	
    		}
    	}
    	return frequency;
    }
    
    /**
     * Tests whether this collection contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if the collection contains anEntry, or false if not.
     */
    public boolean contains (T anEntry) {
    	Node current = head;
    	while (current.next != null) {
    		if (current.next.data == anEntry) {
    			current = current.next;	
    			return true;
    			
    		}
    	}
    	return false;
    }
   
//
//    /**
//     * Retrieves all entries that are in this collection.
//     *
//     * @return A newly allocated array of all the entries in the collection. 
//     * Note: If the collection is empty, the returned array is empty.
//     */
//    public Object[] toArray () {
//    	return 1;
//    }



 }
