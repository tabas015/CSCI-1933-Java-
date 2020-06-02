// PersonApp.java
// Application program that uses inherited classes listed below:
// Person.java --> Student.java --> GradStudent.java 
// Person.java --> Student.java --> UGStudent.java

public class PersonApp {

    public static void main(String[] args) {

        Person p1 = new Person("Joe", "Student");
        Student s1 = new Student (123,"csci");
        GradStudent gS1 = new GradStudent("Phd", true);
        UGStudent ugs = new UGStudent("So", 3.99);

        gS1.major = "CSci";
        gS1.first = "l";
        gS1.last = "m";

       
//        gS1 = (GradStudent) p1;
// This is a problem because we are trying to typecast something to 
// GradStudent that is not of type Gradstudent

//      p1 = (Person) gS1;
// The type casting is NOT needed here because we are "widening" with our
// conversion--a GradStudent already is a Person.
// So, we can just make the assignment without casting as follows:
        p1 = gS1;
        //gS1 = p1;// incompatible types: Person cannot be converted to GradStudent

        System.out.println("\nSome Grad info follows:");
        System.out.println("  " + gS1.major);
        System.out.println("  " + gS1.first + " " + gS1.last);
        System.out.println("  " + gS1.degreeSought + " " + gS1.GradPlanFiled);
        System.out.println("Person info follows:");
        System.out.println("  " + p1.first + " " + p1.last);
        System.out.println();
        //System.out.println("  " + p1.degreeSought + " " + (GradStudent) p1.GradPlanFiled);
// These fields do not exist in p1 which is type Person
    }

}  // PersonApp class
