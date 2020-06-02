// ArrayPrint.java
// Class containing static methods to do array printing

// Given how these methods may be used, should these methods be static?
// If the methods here were non-static, would it be reasonable for a 
// programmer to have to create an instance of this class in order
// to use the methods?
// How would you write a method to print out an array of Strings?

public class ArrayPrint {

    // overloaded methods to print arrays or various types

    public static void arrayPrint(int[] x) {

    for (int i = 0; i < x.length; i++)
        System.out.println("  index: " + i + "     Value is: " + x[i]);
    }  // arrayPrint method


    public static void arrayPrint(double[] x) {

    for (int i = 0; i < x.length; i++)
        System.out.println("  index: " + i + "     Value is: " + x[i]);
    }  // arrayPrint method

    public static void arrayPrint(char[] x) {

    for (int i = 0; i < x.length; i++)
        System.out.println("  index: " + i + "     Value is: " + x[i]);
    }  // arrayPrint method

    public static void main(String[] args) {
    // driver test method to show how overloaded mathods are used

    int a[] = {1, 2, 3, 4, 5};
    double b[] = {1.1, 2.2, 3.3, 4.4, 5.5};
    char c[] = {'a', 'b', 'c', 'd', 'e'};

    System.out.println();
    System.out.println("Values in int array a...");
    arrayPrint(a);
    System.out.println("Values in double array b...");
    arrayPrint(b);
    System.out.println("Values in char array c...");
    arrayPrint(c);

    }  // main method
       
}  // ArrayPrint class
