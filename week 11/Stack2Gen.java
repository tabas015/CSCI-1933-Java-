// Stack2Gen.java
// Simple StackGen interface implemented using an array of generic objects

public class Stack2Gen <T> implements StackGen <T> {

    // constructors

    public Stack2Gen () {
        s = (T[]) new Object[0];
    }
   
    public Stack2Gen (int initLength) {
        
        if (initLength < 0)
          throw new IllegalArgumentException("capacity requested is negative");
        s = (T[]) new Object[initLength];
    }
    
    // selectors

    public void push(T o) {

        T[] biggerArray;

        if (howMany == s.length) {
          try {
            biggerArray = (T[]) new Object[s.length * 2 + 1];
          }
          catch (OutOfMemoryError e) {
            throw new OutOfMemoryError("Current stack size is " + s.length);
          }
          System.arraycopy(s, 0, biggerArray, 0, howMany);
          s = biggerArray;
        }
  
        s[howMany++] = o;
    }

    public T pop() {

        if (howMany == 0)
          throw new RuntimeException("Tried to pop an empty stack");
        else return s[--howMany];
    }

    public T top() {
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

    private T[] s;
    private int howMany = 0;

}  // Stack2Gen class
