// IntArray.java
// Revised 2/2019
// Uses print methods found in ArrayPrint.java
// Useful methods for one-dimensional integer arrays
// Showing basic array declaration, access, updating

// Since there is not a dedicated class for an array of ints,
// all these methods are static.  
// Would a  programmer be just as well off with the inherited 
// equals() or clone() when working with integer arrays, or 
// would the versions presented here (equal() and clone()) be better? 
// Note: the inherited versions are non-static, but the versions 
// here are static.  Why?


public class IntArray {

    // statically make and return a separate copy of an integer array
    public static int[] clone(int[] original) {
        int[] copy = new int[original.length];
        for (int i = 0; i < copy.length; i++)
            copy[i] = original[i];
        return copy;
    }

    // statically copy contents of first int array to second int array
    public static void copy(int[] first, int[] second) {
        int len = Math.min(first.length, second.length);
        for (int i = 0; i < len; i++)
            second[i] = first[i];
    }

    // statically determine if two int arrays are identical in content
    public static boolean equal(int[] one, int[] two) {
        boolean ident = true;
        if (one.length == two.length)
          for (int i = 0; i < one.length; i++) {
              if (one[i] != two[i])
                ident = false;
          } 
        else ident = false;
        return ident;
    }

    //test program
    public static void main(String[] args) {

    int a[] = {1, 2, 3, 4, 5};
    int b[] = a;  // points to above array to begin
    int c[] = {1, 3, 5, 7, 9, 11, 13, 15};
    
    a[1] = 1000;

// original arrays:  a, b, c    
    System.out.println();
    System.out.println("Arrays a, b, c to start");
    System.out.println("\nArray a:");
    ArrayPrint.arrayPrint(a);
    System.out.println("\nArray b:");
    ArrayPrint.arrayPrint(b);
    System.out.println("\nArray c:");
    ArrayPrint.arrayPrint(c);
    System.out.println();

    System.out.println("a equal a: " + equal(a, a));
    System.out.println("a equal b: " + equal(a, b));
    System.out.println("a equal c: " + equal(a, c));
    System.out.println("b equal c: " + equal(b, c));
    System.out.println();

// copy:  a --> c
    System.out.println("Arrays a, b, c after copy(a, c)");
    copy(a, c);
    System.out.println("\nArray a:");
    ArrayPrint.arrayPrint(a);
    System.out.println("\nArray b:");
    ArrayPrint.arrayPrint(b);
    System.out.println("\nArray c:");
    ArrayPrint.arrayPrint(c);
    System.out.println();

    System.out.println("a equal a: " + equal(a, a));
    System.out.println("a equal b: " + equal(a, b));
    System.out.println("a equal c: " + equal(a, c));
    System.out.println("b equal c: " + equal(b, c));
    System.out.println();

// clone:  b gets the clone of c
    System.out.println("Arrays a, b, c after b = clone(c)");
    b = clone(c);  // be now gets new space
    System.out.println("\nArray a:");
    ArrayPrint.arrayPrint(a);
    System.out.println("\nArray b:");
    ArrayPrint.arrayPrint(b);
    System.out.println("\nArray c:");
    ArrayPrint.arrayPrint(c);
    System.out.println();
    
    System.out.println("a equal a: " + equal(a, a));
    System.out.println("a equal b: " + equal(a, b));
    System.out.println("a equal c: " + equal(a, c));
    System.out.println("b equal c: " + equal(b, c));

    }  // main method
       
}  // IntArray class
