 // GradStudent.java
// Simple Inheritance class
// Updated March 2020

// No known subclasses
// Question:  what attributes are part of a GradStudent object?

public class GradStudent extends Student {

    public GradStudent() {};

    public GradStudent(String degree, boolean plan) {
        super(12,"CSCI");
        degreeSought = degree;
        GradPlanFiled = plan;
        //super(12,"CSCI");
        //major = "CSci";
        first = "first-name-here";
        last = "last-name-here";
    }

    public String degreeSought;
    public boolean GradPlanFiled;
}
