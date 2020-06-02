// ReSize.java
// Updated 2/2020

// Array resizing method and demonstration
// What happens when an array (or Python list) gets full?
// Arrays need to be resized 
// Here we resize by a factor of 2 to keep resizing to a minimum. 
// What is the time complexity of an array resize?
// This program reads ints from the user and places them into
// an array in the order they are entered.  When the array is
// full, it is resized.

import java.util.Scanner;

public class ReSize {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] a = new int[2];  // make array small to start
        int count = 0;  // next index in a to fill

        System.out.print("Enter an integer (^d to stop): ");
        while (s.hasNextInt()) {

            if (count == a.length) { // resize array
              System.out.println("** resizing array from " + a.length + 
                                 " to " + a.length * 2 + " **");
              System.out.println("Resized array prior to adding new element");
              for (int i = 0; i < a.length; i++)
                  System.out.println("index " + i + " Value is " + a[i]);
              int[] temp = new int[2 * a.length];
              for (int i = 0; i < a.length; i++)  // copy from 'a' to 'temp'
                 temp[i] = a[i];

              // alternate to above for-loop is:
              // System.arraycopy(a, 0, temp, 0, a.length);

              a = temp;  // reassign 'a' to the new longer array 'temp'

            }  // array resizing

            a[count] = s.nextInt();  // get and place next value
            System.out.println("Array after new item added");
            for (int i = 0; i <= count; i++)
                System.out.println("index " + i + " Value is " + a[i]);
            count++;  
            System.out.print("Next int? ");

            }  // while  

    } // main

}  // ReSize
