// IntNodeDemo.java
// Revised February 2020
// Uses IntNode.java to build a list of ints in same order as they
// are entered.  (Compare with main() in IntNode.java which creates 
// the linked list in reverse of order entered.)

import java.util.Scanner;

public class IntNodeDemo {

    public static void main(String[] args) {
        // tests the IntNode class by building a short list of ints

        IntNode start = null;
        IntNode tail = null;
        IntNode ptr;
        
        Scanner s = new Scanner(System.in);

        System.out.print("Enter an integer (^d to quit): ");
        if (s.hasNextInt()) { // add to empty list special case
          start = new IntNode(s.nextInt(), start);
          tail = start;
        }  // add to empty list special case

        
        System.out.print("Next integer (^d to quit): ");
        while (s.hasNextInt()) {
            tail.setNext(new IntNode(s.nextInt(), null));
            tail = tail.getNext();
            System.out.print("Next integer (^d to quit): ");
        } 

        System.out.println("\nThe list of ints entered in order...");
        ptr = start;
        while (ptr != null) {
            System.out.println(ptr.toString());
            ptr = ptr.getNext();
        }

    }  // main

}  // IntNodeDemo
