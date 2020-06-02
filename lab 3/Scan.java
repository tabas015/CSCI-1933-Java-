// Scan.java
// Java IO example with Scanner class
// C's printf() option used in this example instead of println()
// Scanner class used for "seamless" input without exception handling
// Revised 1/2020

import java.util.Scanner;

public class Scan {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);  // create a scanner instance
        int count = 0, n;
        String words;
 
        // first Scanner example is reading of ints
        // printf on next line is like C, can you re-write with println() ?
        System.out.printf("\nValue %d - Enter an integer (^d to stop): ", 
                          ++count);
        while (s.hasNextInt())  {  // true if more integer tokens
                                   // in this Scanner instance 
            n = s.nextInt();  // only reads if int tokens present
            System.out.printf("You entered: %d\n\n", n);
            System.out.printf("Value number %d: - Enter an integer: ", 
                              ++count);
        }
        System.out.printf("\nOK\n\n");  

        s = new Scanner(System.in);  // new Scanner instance
        count = 0;

        // second Scanner example is reading of Strings
        System.out.printf("\nString %d - Enter a string (^d to stop): ", 
                          ++count);
        while (s.hasNext())  {  // true if more String tokens 
                                // in this Scanner instance 
            words = s.nextLine();  // only reads if a String token present
            System.out.printf("You entered: %s\n\n", words);
            System.out.printf("Value number %d: - Enter a string: ", 
                              ++count);
        }
        System.out.printf("\nOK\n\n");  
    }  // main
} // Scan.java
