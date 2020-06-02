// IntNode.java
// February 2019
// Simple integer node class with test driver main() method

import java.util.Scanner;

public class IntNode {

    private int data;
    private IntNode next;  // pointer to next node in list
    private int length;

    public IntNode() {}  // default constructor

    public IntNode(int value, IntNode ptr) {
        data = value;
        next = ptr;
    }
  
    // accessor methods

    public int getData() {return data;}

    public IntNode getNext() {return next;}

    public void setData(int value) {data = value;}

    public void setNext(IntNode ptr) {next = ptr;}

    public int getLength(){ return length; }

    public boolean equals(Object anotherObject) {
        // returns true iff both fields of
        // the corresponding nodes are ==

        if (anotherObject instanceof IntNode) {
          IntNode temp = (IntNode) anotherObject; 
          if (data == temp.getData() &&
              next == temp.getNext())
            return true;
        }
        return false;
    }

    public String toString() {
        return "" + data;
    }

    public static void main(String[] args) {
        // tests the IntNode class by building a short list of ints

        IntNode start = null;
        IntNode ptr;
        
        Scanner s = new Scanner(System.in);

        System.out.print("Enter an integer (^d to quit): ");
        while (s.hasNextInt()) {
            start = new IntNode(s.nextInt(), start);
            System.out.print("Next integer (^d to quit): ");
        } 

        System.out.println("\nList of ints entered in reverse...");
        ptr = start;
        while (ptr != null) {
            System.out.println(ptr.toString());
            ptr = ptr.getNext();
        }

    }  // main

}  // IntNode
