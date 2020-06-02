// Complex4App.java
// Revised 1/2020

// This driver program uses the Complex4.java class.
// Tests the toString() and equals() methods
// Make sure that you understand the difference between
// equals() and == .  
// Also, remember that an unimplemented equals() is the
// same as ==. 
// Could this same information be included within a main()
// method within Complex4?  Why or why not would this be
// a good idea?

public class Complex4App {
  
    public static void main (String[] args) {

        Complex4 c1, c2;
        double realSum, imaginarySum;
  
        c1 = new Complex4(0, 0);  // create an instance of Complex4
        c2 = new Complex4(0, 0);  // create another instance of Complex4

        System.out.println("c1 is: " + c1.toString());
        System.out.println("c2 is: " + c2);
        // Note that toString() is invoked on the c2 above by default
        // Just another reason to always write a toString() method

        if (c1.equals(c2))
          System.out.println("c1 and c2 are equal");
        else System.out.println("c1 and c2 are NOT equal");

        if (c1 == c2)
          System.out.println("c1 and c2 are ==");
        else System.out.println("c1 and c2 are not ==");

        c1.setRealPart(1.0);  
        c1.setImaginaryPart(2.0);
        c2.setRealPart(3.0);
        c2.setImaginaryPart(4.0);

        System.out.println("c1 is: " + c1.toString());
        System.out.println("c2 is: " + c2);

        if (c1.equals(c2))
          System.out.println("c1 and c2 are equal");
        else System.out.println("c1 and c2 are NOT equal");

    }  // main

}  // Complex4App class
