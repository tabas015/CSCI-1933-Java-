// HeadedList.java
// Create a headed linked list to fix problem with adding to
// and empty list or adding to the start of a list
// Uses IntNode.java
// March 2020

public class HeadedList {

    public static void addToHeadedListInOrder(IntNode ls, int newItem) {
        // Same as addToListInOrder(), except a "headed" list is assumed
        // Assume that ls is pointing to a "header" node that is not
        // part of the data; the "header" node is always *skipped over*
        // The two special cases (adding to empty list and adding to
        // the start of a list) are no longer special cases; instead,
        // they are part of the general case because with a header node
        // always at the start, we will never have an empty list, nor
        // add to the very front of a list.  Rather all additions will
        // be after the header.

        IntNode ptr, trailer;

        System.out.println("Adding: " + newItem);
        
          // general case for all additions

          ptr = ls.getNext();
          trailer = ls;

          while (ptr != null && ptr.getData() < newItem) {
              trailer = ptr;
              ptr = ptr.getNext();
          }  // find location for new item in list

          trailer.setNext(new IntNode(newItem, ptr));

          // general case for all additions

        System.out.println("\nSorted list within addToListInOrder()...");
        ptr = ls;
        while (ptr != null) {
            System.out.println(ptr.toString());
            ptr = ptr.getNext();
        }
    }  //  addToHeadedListInOrder

    public static void main(String[] args) {
        // test driver for addInOrderMethod()

        IntNode start = new IntNode(-1, null);  // create header node

        addToHeadedListInOrder(start, 8);
        addToHeadedListInOrder(start, 12);
        addToHeadedListInOrder(start, 6);
        addToHeadedListInOrder(start, 7);
        addToHeadedListInOrder(start, 4); 
        addToHeadedListInOrder(start, 18);
    
        System.out.println("\nFinal Sorted list in main()...");
        IntNode ptr = start.getNext();  // skip header node
        while (ptr != null) {
            System.out.println(ptr.toString());
            ptr = ptr.getNext();
        }

    }  // main

}  // HeadedList
