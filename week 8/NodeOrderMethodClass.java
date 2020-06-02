  // NodeOrderMethodClass.java
// Method to add an int to sorted list of ints 
// Uses class IntNode.java
// Illustrates opportunity for a "headed" list
// March 2020

public class NodeOrderMethodClass {

    public static IntNode addToListInOrder(IntNode ls, int newItem) { //void 
        // Uses same code as the in-lined approach in IntNodeOrder.java
        // However...
        // WARNING!  This method does not add to an empty list, 
        // nor does it add to the start of a list
        // Key point:  Why?
        // How to fix?
        // One option is a "headed" list, another is return the list
        // Why?

        IntNode ptr, trailer;

        System.out.println("Adding: " + newItem);
        
        if (ls == null) {  // add to empty list special case
          ls = new IntNode(newItem, null);
        }  // add to empty list special case
        else if (ls.getData() > newItem)  // special case add at start
              ls = new IntNode(newItem, ls);
        else {  // general case
          ptr = ls.getNext();
          trailer = ls;
          while (ptr != null && ptr.getData() < newItem) {
              trailer = ptr;
              ptr = ptr.getNext();
          }  // find location for new item in list
          trailer.setNext(new IntNode(newItem, ptr));
        }  // general case

        System.out.println("\nSorted list within addToListInOrder()...");
        ptr = ls;
        while (ptr != null) {
            System.out.println(ptr.toString());
            ptr = ptr.getNext();
        }
        return ls; //changed 
    }  //  addToListInOrder

    public static void main(String[] args) {
        // test driver for addInOrderMethod()
        IntNode start;
        addToListInOrder(start,5);
        addToListInOrder(start,8);
        addToListInOrder(start, 12);
        addToListInOrder(start,6);
        addToListInOrder(start,7);
        addToListInOrder(start, 4);  // will not get added
        addToListInOrder(start, 18);
        /*IntNode start = new IntNode(5, null);
        // What happens if I do NOT add the first item manually as above
        // but use addToListOrder(start, 5) instead?

        addToListInOrder(start, 8);
        addToListInOrder(start, 12);
        addToListInOrder(start, 6);
        addToListInOrder(start, 7);
        addToListInOrder(start, 4);  // will not get added
        addToListInOrder(start, 18);
    */
        System.out.println("\nFinal Sorted list in main()...");
        IntNode ptr = start;
        while (ptr != null) {
            System.out.println(ptr.toString());
            ptr = ptr.getNext();
        }

    }  // main

}  // NodeOrderMethodClass
