// Stack1.java
// Simple Stack interface is implemented using a linked list
// The linked list used is a simple node class called N.  (See N.java)

public class Stack1 implements Stack {

    // constructor

    public Stack1() {}
    
    // selectors

    public void push(Object o) {
        start = new N(o, start);
    }

    public Object pop() {
        if (start == null)
          throw new RuntimeException("Tried to pop an empty stack");
        else {
          Object data = start.getData();
          start = start.getNext();
          return data;
        }
    }

    public Object top() {
        if (start == null)
          return null;
        else return start.getData();
    }

    public boolean isEmpty() {
        if (start == null)
          return true;
        else return false;
    }

    // instance variables

    private N start = null;

}  // Stack1 class
