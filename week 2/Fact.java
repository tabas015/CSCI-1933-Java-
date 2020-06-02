// Fact.java
// Factorial class with both iterative and recursive factorial methods
// 
// Revised 1/2020

// Note all methods are static so there is nothing to instantiate.
// This class is only used to group the various factorial implementations
// together; it is NOT an example of object oriented design.

// Repetition algorithms can be recursive or iterative; they can be
// implemented with either recursive or iterative constructs.
// This yields four possible combinations of aproach and construct.  
// Three are given below.  Which combination is missing?

public class Fact {

    public static int rFactorial(int n) {
    // recursive algorithm version 
        if (n == 0)
          return 1;
        else return n * rFactorial(n - 1);
    }

    public static int iFactorial(int n) {
    // iterative algorithm version with helper method
        // start state
        // count = 0
        // partial = 1
        // invariant:  partial = count!

        return factIter(n, 0, 1);
    }

    public static int factIter(int n, int count, int partial) {
    // helper function for iFactorial above
        // invariant:  partial = count!
        if (count == n)
          return partial;
        else return factIter(n, count + 1, (count + 1) * partial);
    }


    public static int iCFactorial(int n) {
    // iterative agorithm version using Java iteration construct
        int count = 0, partial = 1;

        while (count < n) {  // invariant:  partial = count!
            count++;
            partial = partial * count;
        }
        return partial;
    }

    public static void main(String[] args) {
    // main driver method to test the factorial methods above
        System.out.println();
        System.out.println("Recursive fact(0): " + rFactorial(0));
        System.out.println("Recursive fact(1): " + rFactorial(1));
        System.out.println("Recursive fact(2): " + rFactorial(2));
        System.out.println("Recursive fact(3): " + rFactorial(3));
        System.out.println();
        System.out.println("Iterative-rec fact(0): " + iFactorial(0));
        System.out.println("Iterative-rec fact(1): " + iFactorial(1));
        System.out.println("Iterative-rec fact(2): " + iFactorial(2));
        System.out.println("Iterative-rec fact(3): " + iFactorial(3));
        System.out.println();
        System.out.println("Iterative-construct fact(0): " + iCFactorial(0));
        System.out.println("Iterative-construct fact(1): " + iCFactorial(1));
        System.out.println("Iterative-construct fact(2): " + iCFactorial(2));
        System.out.println("Iterative-construct fact(3): " + iCFactorial(3));
        System.out.println();
    }
}  // Fact class
