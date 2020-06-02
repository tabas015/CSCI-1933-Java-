// Number.java
// Simple data objects for inserting into generic data structures
// that require ordering
// April 2019

public class Number implements Comparable<Number> {

    public int a, b;
    
    public Number(int one, int two) {
        a = one;
        b = two;
    }

    public int compareTo(Number other) {
        return ((a + b) - (other.a + other.b));
    }

    public String toString() {
        return "" + (a + b);
    }    

}  // Number
    
