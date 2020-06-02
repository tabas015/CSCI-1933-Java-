// smi00903 & tabas015
public class ArrayList<T extends Comparable <T>> implements List<T> {
    private T[] a;
    private int size; // Keeps track of list size
    private boolean isSorted;
    
    // Constructor
    public ArrayList() {
        a = (T[]) new Comparable[2];
        isSorted = true; // Sorted in ascending order
        size = 2;
    } // Constructor
    
    // Adds element to the end of the array and resizes the array with the new element
    // Returns true if element is added successfully, returns false otherwise
    public boolean add(T element) {
        if (element == null) {
            return false;
        }
        if (a[0] == null) {
            a[0] = element;
            return true;
        }
        if (a[1] == null) {
            a[1] = element;
            return true;
        }
        T[] newArray = (T[]) new Comparable[size+1];  // New, bigger array

        for (int i=0; i<a.length; i++) {
            newArray[i] = a[i];
        }
        newArray[size] = element; // Add the new element to the end of the array
        size++;
        isSorted = false;
        a = newArray; // Reassign a to the resized array
        return true;
    } // add
    // Adds the new element at the desired index then moves all existing elements after it
    // Returns true if element is added successfully, returns false otherwise
    public boolean add(int index, T element) {
        if (element == null) {
            return false;
        }
        T[] newArray = (T[]) new Comparable[size+1]; // New, bigger array

        // Loop through array, assigning appropriate elements
        for (int i=0; i<size+1; i++) {
            if (i == index) {
                newArray[i] = element; // Add new element
            }
            else if (i > index) {
                newArray[i] = a[i-1]; // Offset i after adding new element
            }
            else {
                newArray[i] = a[i]; // Haven't reach index yet, so add normally
            }
        }

        size++;
        isSorted = false;
        a = newArray; // Reassign a to the resized array
        return true;
    }

    // Eliminates all elements within a reset size
    public void clear() {
        a = (T[]) new Comparable[2];
        size = 0;
    }
     // Checks if given element exists
     // Returns true if it does, and returns false otherwise
    public boolean contains(T element) {
        for (int i=0; i<size; i++) {
            if (a[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    // If the specified index exists, returns the element at that location.
    // Otherwise, returns null
    public T get(int index) {
        if (index >= 0 && index < a.length) {
            return a[index];
        }
        else {
            return null;
        }
    }

    // Returns the index of the specified element
    // If the element is not present in the array, returns -1
    public int indexOf(T element) {
        for (int i=0; i<size; i++) {
            if (a[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    // Returns true if the array is empty. Returns false otherwise
    public boolean isEmpty() {
        if (size == 0) { return true; }
        else { return false; }
    }
    // Returns the last index of the specified element
    // If the element doesn't exist, returns -1
    public int lastIndexOf(T element) {
        for (int i = size - 1; i >= 0; i--) {
            if (a[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    // Sets the specified index to the specified element
    // If the index or element isn't valid, returns null
    public T set(int index, T element) {
        if (index >= 0 && index < size && element != null) {
            T oldElement = a[index];
            a[index] = element;
            return oldElement;
        }
        return null;
    }

    // Returns array size
    public int size() {
        return size;
    }

	// If order = true, sort list ascendingly
	// If order = false, sort list descendingly
	// Uses bubble sort
    public void sort(boolean order) {
        boolean swapped = true;
        T temp;

        if (order == true) { // Sort ascendingly
            for (int i=0; i<a.length && swapped == true; i++) {
                swapped = false;
                for (int j=1; j<size - i; j++) {
                    if (a[j].compareTo(a[j-1]) < 0) {
                        swapped = true;
                        temp = a[j];
                        a[j] = a[j-1];
                        a[j-1] = temp;
                    }
                }
            }
        }
        else { // Sort descendingly
            for (int i=0; i<a.length && swapped == true; i++) {
                swapped = false;
                for (int j=1; j<size - i; j++) {
                    if (a[j].compareTo(a[j-1]) > 0) {
                        swapped = true;
                        temp = a[j];
                        a[j] = a[j-1];
                        a[j-1] = temp;
                    }
                }
            }
        }
        isSorted = true;
    } // sort

    // Removes the specified element if it is in the array
    // Returns true if the element is successfully removed.
    // Returns false otherwise
    public boolean remove(T element) {
        if (element == null) {
            return false;
        }
        T[] newArray = (T[]) new Comparable[size-1]; // New, smaller array
        boolean foundIndex = false;

        // Loop through array
        for (int i=0; i<size-1; i++) {
            if (a[i] == element) {
                foundIndex = true;
                newArray[i] = a[i+1]; // Skip the element to be removed
            }
            else if (foundIndex == true) {
                newArray[i] = a[i+1]; // Offset i after skipping element
            }
            else {
                newArray[i] = a[i]; // Haven't found element to be removed, so add elements normally
            }
        }

        a = newArray; // Reassign a to the resized array
        isSorted = false;
        size--;
        return true;
    }

    // Removes the specified index from the array, making the array smaller
    // Returns the removed data if the operation is succesful
    // Returns false otherwise
    public T remove(int index) {
        if (index < 0 || index > size) { // Check if index is valid
            return null;
        }
        T[] newArray = (T[]) new Comparable[size+1];
        T removed = null;

        // Loop through array
        for (int i=0; i<size-1; i++) {
            if (i == index) {
                newArray[i] = a[i];
                removed = a[i];
            }
            else if (i > index) {
                newArray[i] = a[i+1]; // Offset i after adding new element
            }
            else {
                newArray[i] = a[i]; // Haven't reach index yet, so add normally
            }
        }

        a = newArray;
        isSorted = false;
        size--;
        return removed;
    }

    // Returns String of the array's indexes and elements
    public String toString() {
        String toPrint = "";

        for (int i=0; i<size; i++) {
            toPrint += "a[" + i + "] = " + a[i];
            if (i != size-1) {
                toPrint += "\n";
            }
        }
        return toPrint;
    }
}
