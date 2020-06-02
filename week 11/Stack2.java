// Stack2.java
// Simple Stack interface is implemented using an array of objects
// Updated April 2020

public class Stack2 implements Stack {

    // constructors

    public Stack2() {
        s = new Object[0];
    }
   
    public Stack2(int initLength) {
        
        if (initLength < 0)
          throw new IllegalArgumentException("capacity requested is negative");
        s = new Object[initLength];
    }
    
    // selectors

    public void push(Object o) {

        Object[] biggerArray;

        if (howMany == s.length) {
          try {
            biggerArray = new Object[s.length * 2 + 1];
          }
          catch (OutOfMemoryError e) {
            throw new OutOfMemoryError("Current stack size is " + s.length);
          }
          System.arraycopy(s, 0, biggerArray, 0, howMany);
          s = biggerArray;
        }
  
        s[howMany++] = o;
    }

    public Object pop() {

        if (howMany == 0)
          throw new RuntimeException("Tried to pop an empty stack");
        else return s[--howMany];
    }

    public Object top() {
        if (howMany == 0)
          return null;
        else return s[howMany - 1];
    }

    public boolean isEmpty() {
        if (howMany == 0)
          return true;
        else return false;
    }

    // instance variables

    private Object[] s;
    private int howMany = 0;

}  // Stack2 class
