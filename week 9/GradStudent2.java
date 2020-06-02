// GradStudent2.java
// Modified Simple Inheritance class
// Inherits the abstract Student2 class and has some new methods,

public class GradStudent2 extends Student2 {

    public GradStudent2() {};

    public GradStudent2(String degree, boolean plan) {
        degreeSought = degree;
        GradPlanFiled = plan;
    }

    public GradStudent2(String degree, boolean plan, int id,  String maj, 
                        String first, String last) {
        super(id, maj, first, last);  // uses superclases' constructor
        degreeSought = degree;
        GradPlanFiled = plan;
    }

    // overRIDE print() method from Student2
    public void print() {
        System.out.println("printing from GradStudent");
        super.print();
    }

    // implement printThree() method from Student2.
    public void printThree() {
        System.out.println("printing from GradStudent2: Three");
    }   

    public String getDegree() {
        return degreeSought;
    }

    public boolean getPlan() {
        return GradPlanFiled;
    }

    protected String degreeSought;
    protected boolean GradPlanFiled;
}
