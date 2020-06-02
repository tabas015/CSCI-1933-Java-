 // ExceptionExample.java
// Spring 2020

// Introductory Example of Exception handling
// Two versions of a method (compute1() and compute2()) are compared.
// The first version does NOT use exception handling, the second does.
// Exception handling allows the programmer to take control of exception
// situations rather than letting the program quit.
// Run the program with calls to compute1() and compute2() and compare.

public class ExceptionExample {
    
    public static int compute1(int a, int b) {
    // compute1() does NOT use exception handling
    // compare it with compute2() (below) which is the same, except that
    // compute2() uses exception handling

        int result = -1;

        result = a / b;

        return result;

    }  // compute1

    public static int compute2(int a, int b) {
    // compute2() uses exception handling

        int result = -1;
        try {
            result = a / b;
        }
        catch (NullPointerException e) { // the most specific exception should go first
            System.out.println("Caught an IO Exception");
        }
        catch (Exception e) {// then the common ones
            System.out.println("compute2() caught an Exception: " + e.toString());
        }
        finally {
            System.out.println("finally in compute2() always executes");
        }

        return result;

    }  // compute2

    public static void main(String[] args) {
        int x = 123;
        int y = 0;

        System.out.println("\nUsing try block in main()...");
        try {
            System.out.println("Calling compute2(x, y) from main(): ");
            System.out.println(compute2(x, y));
            System.out.println("Calling compute1(x, y) from main(): ");
            System.out.println(compute1(x, y));
        }
        catch(Exception e) {
            System.out.println("Caught in main()"); 
        }
        finally {
            System.out.println("finally in main() always executes");
        }
        
        System.out.println("\nWithout using try block in main()...");
        System.out.println("Calling compute2(x, y) from main(): ");
        System.out.println(compute2(x, y));
        System.out.println("Calling compute1(x, y) from main(): ");
        System.out.println(compute1(x, y));

        System.out.println();

    }  // main method
}  // ExceptionExample
