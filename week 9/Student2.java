// Student2.java
// Modified Simple Inheritance class
// Like Person2, Student2 is non-instantiable because it is abstract.
// Although Student2 implements the abstract method printTwice() from 
// Person2, it has its own abstract method printThree() that needs to 
// be implemented by a subclass.
// Keep in mind, if a class has at least one abstract method, it is
// abstract and non-instantiable.

public abstract class Student2 extends Person2 {

    public Student2() {};

    public Student2(int ident, String maj) {
        id = ident;
        major = maj;
    }

    public Student2(int ident, String maj, String first, String last) {
        super(first, last);  // use superclasses' constructor for these
        id = ident;
        major = maj;
    }

    public int getId() {
        return id;
    }
 
    public String getMajor() {
        return major;
    }

    public void setId(int i) {
        id = i;
    }

    public void setMajor(String m) {
        major = m;
    }
 
    // does NOT overRIDE the print() method in Person2
    // rather, it overLOADs the print() method in Person2
    public void print() {
        System.out.println(" printing from Student2: " + id + " " + major);
        System.out.println(" now calling super.print()");
        super.print("super print() called from Student2");
    }

    // implements the abstract method in Person2 and
    // the signature must be the same in order to implement it
    public void printTwice(String s) {
        System.out.println(" printing from Student2: " + s + s);
    }

    // abstract method is implemented in GradStudent2 and UGStudent2
    abstract public void printThree();

    protected int id;
    protected String major;
}
