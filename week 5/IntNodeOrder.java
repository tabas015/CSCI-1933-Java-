// IntNodeOrder.java
// Revised February 2020

// Creates an ordered list (from low to high) of integers
// Uses IntNode.java for the individual nodes in the linked list

// What happens when the "adding" to the list is done in a
// separate method such as public void add(IntNode start, int value)?
// Does it still work?  Try it by writing a separate add()
// method in place of adding the elements directly in main().

import java.util.Scanner;

public class IntNodeOrder {
    
    public static void main(String[] args) {

        // Tests the IntNode class by building a sorted list of ints

        // Three cases when adding to a list in sorted order:  
        //  1)  Adding to an empty list
        //  2)  Adding to the very beginning of a (non-empty) list
        //  3)  Adding somewhere after the first item of a list

        IntNode start = null;
        IntNode ptr, trailer;
        
        Scanner s = new Scanner(System.in);

        System.out.print("Enter an integer (^d to quit): ");
        if (s.hasNextInt()) {  // add to empty list special case
          start = new IntNode(s.nextInt(), null);
        }  // add to empty list special case

        System.out.print("Next integer (^d to quit): ");
        while (s.hasNextInt()) {
            int temp = s.nextInt();
            if (start.getData() > temp)  // special case add at start
              start = new IntNode(temp, start);
            else {  // general case
              ptr = start.getNext();
              trailer = start;
              while (ptr != null && ptr.getData() < temp) {
                  trailer = ptr;
                  ptr = ptr.getNext();
              }  // find location for new item in list
              trailer.setNext(new IntNode(temp, ptr));
            }  // general case
            System.out.print("Next integer (^d to quit): ");
        }  // while input loop

        System.out.println("\nThe sorted list of ints ...");
        ptr = start;
        while (ptr != null) {
            System.out.println(ptr.toString());
            ptr = ptr.getNext();
        }

    }  // main

}  // IntNodeOrder
