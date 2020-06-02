// FindMethodClass.java
// Method to return true if an int is found in list
// Uses IntNode.java
// Revised February 2020

public class FindMethodClass {

    public static boolean find(IntNode ls, int item) {
        IntNode ptr = ls;

        while (ptr != null) {
            if (ptr.getData() == item)
              return true;
            ptr = ptr.getNext();
        }  // while

        return false;

    }  // find

    public static void main(String[] args) {

        IntNode l1 = null;
        IntNode l2 = new IntNode(5, null);
        IntNode l3 = new IntNode(5, new IntNode(3, null));

        if (find(l1, 4))
          System.out.println("4 was found in empty list");
        else System.out.println("4 was NOT found in empty list");

        if (find(l2, 4))
          System.out.println("4 was found in a list of only 5");
        else System.out.println("4 was NOT found in a list of only 5");

        if (find(l2, 5))
          System.out.println("5 was found in a list of only 5");
        else System.out.println("5 was NOT found in a list of only 5");

        if (find(l3, 1))
          System.out.println("1 was found in a list of 5, 3");
        else System.out.println("1 was NOT found in a list of 5, 3");

        if (find(l3, 5))
          System.out.println("5 was found in a list of 5, 3");
        else System.out.println("5 was NOT found in a list of 5, 3");

    }  // main

}  //  FindMethodClass
