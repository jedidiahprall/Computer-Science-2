//import javax.xml.soap.Node;

/**
 *A list class that implements MyCollectinoInterface for project 4 
 *Calvin Nguyen and Osman
 *list class
 *Eclipse Java IDE
 *fulminate: denounce forcefully.
 *"You can't make decisions based on fear and the possibility of what might happen." - Michelle Obama, (1.1964)
 *@author Calvin Nguyen and Osman
 *@version project 4 
 *@class CalvinNguyen_04
 */


public class List<T> implements MyCollectionInterfaceProject04<T>{
	Node<T> head;
	Node<T> tail;
	int listCount = 0;
	Node<T> current = head;
	Node<T> nodeBefore;
	Node<T> nodeAfter;
	
//************************************************************************* 	
	/**
     * Adds a new entry to this collection
     * 
     * @param newItem The object to be added to the collection
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newItem) {
    	if (head==null) {
    		head = new Node<T>(newItem);
    	}
		while (current.next != null) {
			current = current.next;
		}
		current.next= new Node<T>(newItem);
		return true;
	}
    
//*************************************************************************  
    
    /**
     * Adds a new entry to this collection at the given position
     * 
     * @param newItem The object to be added to the collection
     * @param position The location where newItem will be inserted.
     * @return True if the addition is successful, or false if not.
     */
    public boolean add (T newItem, int position) {
    	boolean result = false;
        Node newNode = new Node(newItem);
        nodeBefore = null;
        nodeAfter = null;
        int counter = 0;
           if((position >= 1) && (position <= listCount + 1) ){
           
              if(position == 1){
              current.setNextNode(newNode);
              head = current;
              result = true; 
              listCount++;
              }
         
              else{
                 
                    while(position != counter){
                       current = current.getNextNode();
                       counter++;
                       nodeBefore = current;
                       current = current.getNextNode();
                       nodeAfter = current;
                       result = true;
                 }
              }
           }
           else{
              throw new IndexOutOfBoundsException(
                 "Position is not in bounds"); 
           }
       return result;
   } // End of method
    
 //*************************************************************************
    
 	/**
 	 * Removes one occurrence of a given entry from this collection.
 	 *
 	 * @param anEntry The entry to be removed.
 	 * @return True if the removal was successful, or false if not.
 	 */
    public boolean remove (T anEntry) {
		
        boolean result = false;
        current = head;
        nodeBefore = null;
        nodeAfter = null;
        try{
        if(isEmpty()){
           throw new IllegalArgumentException("List is empty");
        }
        nodeAfter = head.getNextNode();
        if(current.getData().equals(anEntry)){
           head = current.getNextNode();
           result = true;
           listCount--;
        }
        else{
           try{
              while(current != null && !current.getData().equals(anEntry)){
                 nodeBefore = current;
                 current = current.getNextNode();
                 nodeAfter = current.getNextNode();
                 
              }
              if(current != null){
                 listCount--;
                 result = true;
                 nodeBefore.setNextNode(nodeAfter);
                 current.setNextNode(null);
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
   } // End of method
    
 //*************************************************************************    
    /**
     * Removes all entries from this collection.
     */
  
    public void clear() {
    	head = null;
    	listCount = 0;
    	
    }
    
    
    /**
     * Gets the current number of entries in this collection.
     *
     * @return The integer number of entries currently in the collection.
     */
    public int getCurrentSize() {
    	Node current = head;
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
    public boolean isEmpty() {
    	if (head==null) {
    		return true;
    	}
    	return false;
    }
//*************************************************************************     
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
    
//************************************************************************* 
    
    /**
     * Tests whether this collection contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if the collection contains anEntry, or false if not.
     */
    public boolean contains (T anEntry) {
    	Node current = head;
    	while (current.next != null) {
    		if (current.getData() == anEntry) {
    			current = current.next;	
    			return true;
    			
    		}
    	}
    	return false;
    }
    
 //************************************************************************* 
   
    /**
     * Retrieves all entries that are in this collection.
     *
     * @return A newly allocated array of all the entries in the collection. 
     * Note: If the collection is empty, the returned array is empty.
     */
    public Object[] toArray () {
    	 Object[] array =  new Object[listCount];
         int index = 0;
         Node current = head;
         while((index < listCount) && (current != null)){
            array[index] = current.getData();
            current = current.getNextNode();
            index++;
         }
         return array;   
       
       } // End of method


 }
