                            // Student.java
// Simple Inheritance class
// Updated March 2020

// Inherits from Person (see "extends" clause on class header)
// The 'first' and 'last' public fields from Person.java
// are inherited by Student
// Known inheriting classes:  UGStudent.java, GradStudent.java

// protected access attriutes (id, major) are restricted to this class
// any any other classes which inherit from it

public class Student extends Person {

    public Student() {};

    public Student(int ident, String maj) {
        id = ident;
        major = maj;
    }

    protected int id;  // available in Student and subclasses of Student
    protected String major;  // available in Student and subclasses of Student
}
// protected is available to the class and also the inherited classes
