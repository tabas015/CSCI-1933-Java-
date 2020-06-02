// InterfaceApp.java
// Spring 2019
// This application uses the InterfaceClass class that implements the 
// Interface1 and Interface2 interfaces

public class InterfaceApp {

    public static void main(String[] args) {

        InterfaceClass o = new InterfaceClass();  // using default constructor

        // Note that constants (static) from the interfaces are not 
        // instantiated in the InterfaceClass, so we access the constants
        // directly from the interfaces where they are defined;
        // this allows distinguishing between constants with the
        // same name found in more than one implemented interface.

        System.out.println("\nValue of MAX: " + Interface1.MAX);
        System.out.println("Value of MAX: " + Interface2.MAX + "\n");

        System.out.print("printWord(3): ");
        o.printWord(3);

        System.out.print("\nprintValue(\"four\"): ");
        o.printValue("four");

        System.out.print("\nprintTwice(\"Twice\"): ");
        o.printTwice("Twice");
        
        System.out.println();

    }  // main method

}  // InterfaceApp class
