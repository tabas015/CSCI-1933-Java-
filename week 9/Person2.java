// Person2.java
// Modified Simple Inheritance Example (based on Person.java)
// This class is abstract *and* also includes a method print() 
// which will be overriden in subclasses of Person.java.
// Additional accessor methods and protected class variables
// (compared with Person.java) are used.
// Person2 is *not* instantiable because it is abstract;
// it is abstract because it contains an abstract method--printTwice().

public abstract class Person2 {
    
    public Person2() {};

    public Person2(String f, String l) {
        first = f;
        last = l;
    }
 
    public void print(String s) {
        System.out.println("  printing from Person2: " + s);
        System.out.println("  " + first + " " + last);
    }

    // to be implemented later
    abstract public void printTwice(String s);

        
    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public void setFirst(String f) {
        first = f;
    }

    public void setLast(String l) {
        last = l;
    }

    protected String first;  // protected are available to subclasses
    protected String last;
}
