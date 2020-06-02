
// UGStudent2.java
// Modified Simple Inheritance class
// Inherits the abstract Student2 class

public class UGStudent2 extends Student2 {
   
    public UGStudent2() {};

    public UGStudent2(String yr, double grades) {
        year = yr;
        gpa = grades;
    }

    public UGStudent2(String yr, double grades, int id, String maj,
                      String first, String last) {
        super(id, maj, first, last);  // invoke super classes' constructor
        year = yr;
        gpa = grades;
    }

    public void print() {
        System.out.println("printing from UGStudent2");
        super.print();
    }

    public void print(String whatToPrint) {
        System.out.println("printing from UGStudent2 " + whatToPrint);
    }

    // implement abstract method from Student2
    public void printThree() {
        System.out.println("printing from UGStudent2: Three");
    }

    protected String year;
    protected double gpa;
}
