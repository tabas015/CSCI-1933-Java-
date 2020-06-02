// PersonApp2.java
// Modified application program that uses inherited classes listed below:
// abstract Person2.java, abstract Student2.java, 
// GradStudent2.java, and UGStudent2.java
// Note that abstract classes are not instantiable: no instances of
// Person2 and Student2 can be created.  
// Only GradStudent2 and UGStudent2 instances can be created.  
// However, the superclass types, Person2 and Student2, may be used
// as types of variables pointing to GradStudent2 and UGStudent2 instances.
// This example also shows dynamic binding to match a method with a method 
// name from the appropriate subclass.

public class PersonApp2 {

    public static void main(String[] args) {

// This cannot work because Person2 is not instantiable -- it is abstract
//      Person2 p = new Person2("Joe", "Person");

        GradStudent2 gS = new GradStudent2("Phd", true, 1, "CS", "Sue", "Grad");
        UGStudent2 uGS = new UGStudent2("Senior", 4.0);

        // set some of the uninitialized fields in uGS using inherited 
        // accessor methods
        uGS.setFirst("Jane");
        uGS.setMajor("Physics"); 

        Person2 genericPerson = uGS;  // a widening conversion by two levels
        Student2 genericStudent = gS;  // a widening conversion by one level

       
        System.out.println("\nDisplaying GradStudent2 object as GradStudent2");
        gS.print("GradStudent2 object is variable gS");
        gS.print();
        gS.printTwice("Twice");
        gS.printThree();

        System.out.println("\nDisplaying GradStudent2 object as Student2");
        genericStudent.print("GradStudent2 object is variable genericStudent");
        genericStudent.print(); 
        genericStudent.printTwice("Twice");
        genericStudent.printThree();

        System.out.println("\nDisplaying UGStudent2 object as UGStudent2");
        uGS.print("UGStudent2 object is variable uGS");
        uGS.print();
        uGS.printTwice("Twice");
        uGS.printThree();

        System.out.println("\nDisplaying UGStudent2 object as Person2");
        genericPerson.print("UGStudent2 object is variable genericPerson");
// This will not work because the signature for the print() method in the
// Person2 class has one parameter, so the interpreter will NOT look into 
// subclasses to find a similarly named method one with no parameters       
//      genericPerson.print();
        genericPerson.printTwice("Twice");
// This will not work because the printThree() method is not declared in
// the Person2 class
//      genericPerson.printThree();
        
    } // Main method
}  // PersonApp2 class
