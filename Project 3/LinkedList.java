// smi00903 & tabas015

public class LinkedList<T extends Comparable<T>> implements List<T> {
	private Node<T> head; // First element
    private int size; // Keeps track of list size
    private boolean isSorted;

    // Constructor
    public LinkedList() {
        isSorted = true; // Sorted in ascending order
        size = 0;

    } // Constructor

	// If the element is valid, add it to the end of the list
	// Returns true if addition is successful
	// Returns false otherwise
    public boolean add(T element) {
        if (element == null) { // Check if valid element
            return false;
        }
		else {
			// Create Node
			Node<T> newNode = new Node<T>(element);
			
			if (head==null) { // If this is the first time adding
				head = newNode;
			}
			else {
				Node<T> runner, current;
				current = head;
				runner = head.getNext();
		
				while (runner != null) { // Loop through list
					current = runner;
					runner = runner.getNext();
				}
				current.setNext(newNode);
			}
		}
		// Element is added so list size increases and the list may or may not be sorted anymore
		size++;
		isSorted = false;

        return true;
    } // Add

	// If element and index are valid, add it to the specified index and shift existing elements
	// Returns true if Node is successfully added
	// Returns false otherwise
	// Note: You can only add within the list, not to the end of it
    public boolean add(int index, T element) {
        if (element == null) { // Check if valid element
            return false;
        }
		else if (index < 0 || index >= size) { // Check if valid index
            return false;
		}
		else {
			// If you got this far, begin insertion
			Node<T> newNode = new Node<T>(element);
			Node<T> runner, current; // In the loop, current will be before the index, runner is at the index
			current = head;
			runner = head.getNext();
	
			for (int i=0; i<index-1; i++) { // Loop through list until you reach the correct index
				current = runner;
				runner = runner.getNext();
			}
			// Insert the element
			current.setNext(newNode);
			newNode.setNext(runner);
		}
		// Element is added so list size increases and the list may or may not be sorted anymore
		size++;
		isSorted = false;

        return true;
    }

    // Remove all elements from the list
    public void clear() {
		head = null;
	}
	
	// Checks if the specified element exists
	// Returns true if it does
	// Returns false otherwise
    public boolean contains(T element) {
		if (head.getData().equals(element)) { // Check for element
			return true;
		}
		else {
			// If the list is sorted, use a more efficient method
			Node<T> runner, current;
			current = head;
			runner = head.getNext();
			

			while ( runner != null) { // Loop through list
				current = runner;
				runner = runner.getNext();

				if (current.getData().equals(element)) { // Check for element
					return true;
				}
			}
		}
		
		return false;
	}
	
	// Returns element in the specified index
	// Returns null if the index is invalid
    public T get(int index) {
		if (index < 0 || index > size) {
			return null;
		}
		Node<T> runner, current;
		current = head; // Starts at 0 in the loop
		runner = head.getNext(); // Starts at 1 in the loop

		for (int i=0; i<index; i++) { // Loop through list until you reach the correct index
			current = runner;
			runner = runner.getNext();
		}
		return current.getData();
    }
 
	// Return the first index of element in the list
	// Returns -1 if that element isn't found
	public int indexOf(T element) {
		Node<T> runner, current;
		current = head; // Starts at 0 in the loop
		runner = head.getNext(); // Starts at 1 in the loop
		int index = 0;

		while ( runner != null) { // Loop through list
			if (current.getData().equals(element)) { // Check for element
				return index;
			}
			index++;
			current = runner;  // "current = current.next" would also work
			runner = runner.getNext();
		}

		return -1; // If you didn't find it
	}
	
	// Checks if a list is empty
	// Returns true if it's empty
	// Returns false otherwise
    public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

    public int lastIndexOf(T element) {
		Node<T> runner, current;
		int lastIndex = -1;
		current = head;

        for (int i=0; i<size-1; i++) {
            if (current.getData().equals(element)) {
                lastIndex = i;
			}
			current = current.getNext();
        }

		return lastIndex;
	}

	// Overwrites the specified index
	// Returns overwritten Nodes' data
	// If that data can't be found, returns null
    public T set(int index, T element) {
		if (element == null) { // Check if valid element
            return null;
        }
		else if (index < 0 || index >= size) { // Check if valid index

            return null;
		}

		// If you got this far, begin insertion
		T data = null;
        Node<T> newNode = new Node<T>(element);
		Node<T> runner, current;
		current = head;
		runner = head.getNext();
		
		for (int i=0; i<index; i++) { // Loop through list until you reach the correct index
			current = runner;
			runner = runner.getNext();
		}
		data = current.getData();
		// Replace the element
		current.setData(element);
		isSorted = false;
        return data; // Return current element
	}
	// Returns list size
    public int size() {
		return size;
	}
	// If order = true, sort list ascendingly
	// If order = false, sort list descendingly
	// Uses bubble sort
    public void sort(boolean order) {
		boolean swapped = true;
        
		if (order == true) { // Sort ascendingly
			for (int i = 0; i<size; i++) {
				Node<T> current = head;
				Node<T> runner = head.getNext();
				for (int j = 0; j<size-2; j++) {
					if (current.getData().compareTo(runner.getData()) < 0) { // If current<runner
						// Swap data, rather than Nodes
						T temp = current.getData();
						current.setData(runner.getData());
						runner.setData(temp);
					}
					current = runner;
					runner = runner.getNext();
				}
			}
	    }
	    else if (order == false) { // Sort descendingly
	        for (int i = 0; i<size; i++) {
				Node<T> current = head;
				Node<T> runner = head.getNext();

				for (int j = 0; j<size-2; j++) {
					if (current.getData().compareTo(runner.getData()) > 0) { // If current>runner
						// Swap data, rather than Nodes
						T temp = current.getData();
						current.setData(runner.getData());
						runner.setData(temp);
					}
					current = runner;
					runner = runner.getNext();
				}
			}
		}

	} // sort
	
	// Removes first instance of element
	// Returns true if element is successfully removed
	// Returns false otherwise
    public boolean remove(T element) {
		if (head.getData().equals(element)) { // If it's the first Node
			head = head.getNext(); // Just change where head points to
			return true;
		}
		else {
			Node<T> runner, current;
			current = head;
			runner = head.getNext();

			while (runner != null) { // Loop through list
				if (runner.getData().equals(element)) { // If you find the element
					current.setNext(runner.getNext()); // Point the next Node to 2 Nodes down (skipping the Node to be removed)
					size--;
					isSorted = false;
					return true;
				}
				current = runner;
				runner = runner.getNext();
			}
		}
		return false;
	} // Remove
	// Remove element at specified index and return that element
	// Returns removed element's data if it's successfully removed
	// Returns null otherwise
    public T remove(int index) {
		if (index < 0 || index > size) { // Test if index is valid
			return null;
		}
		Node<T> runner, current;
		current = head;
		runner = head.getNext();
		
		for (int i=0; i<index-1; i++) { // Loop through list until you reach the correct index
			current = runner;
			runner = runner.getNext();
		}

		// Point the next Node to 2 Nodes down (skipping the Node to be removed)
		current.setNext(runner.getNext());

		isSorted = false;
		size--;
		return runner.getData();
	}

	// Returns string of all elements in list
    public String toString() {
		String toPrint = "";

		Node<T> runner, current;
		current = head; // Starts at 0 in the loop
		runner = head.getNext(); // Starts at 1 in the loop
		int index = 0;

		while (runner != null) { // Loop through list
			toPrint += "[" + index + "] = " + current.getData() + "\n";

			current = runner;
			runner = runner.getNext();	
			index++;
		}
		toPrint += "[" + index + "] = " + current.getData();

		return toPrint;
	}

} // Class
