// N.java
// A *simplified* node class for use with higher order data structures
// that create lists of nodes.  
// This node class uses Object data.

public class N {
  
    // constructors
    
    public N() {}

    public N(Object o, N link) {
        data = o;
        next = link;
    }

    // selectors

    public Object getData() {
        return data;
    }

    public void setData(Object o) {
        data = o;
    }

    public N getNext() {
        return next;
    }

    public void setNext(N link) {
        next = link;
    }

    // instance variables

    private Object data;
    private N next;

}  // N class
