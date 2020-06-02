 // UGStudent.java
// Simple Inheritance class
// Updated March 2020

// Inherits from Student.java
// No known subclasses
// Note use of "super()"
// Question: what attributes are part of a UGStudent object?

public class UGStudent extends Student {
   
    public UGStudent() {};

    public UGStudent(String yr, double grades) {
        super(1234567, "CSci"); // id and major from the parent class, student 
        year = yr;
        gpa = grades;
    }

    public String year;
    public double gpa;
}
