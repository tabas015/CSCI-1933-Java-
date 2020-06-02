// Person.java
// Simple class used to show inheritance
// Updated March 2020

// Known inheriting classes: Student.java, UGStudent.java, GradStudent.java

// Person inherits directly from Object since the is no "extends" clause
// on the class header.
// This top-level class has no accessor methods and uses public attributes.
// It is intentionally sparse so as not to obscure the point: inheritance.
// Public attributes can be used and modified by external objects.
// A better implementation has restricted access attribute variables
// and public accessor methods.

public class Person {
    
    public Person() {};

    public Person(String f, String l) {
        first = f;
        last = l;
    }
 
    public String first;
    public String last;
}
