// Stack.java
// Stack Interface
// Identify methods below as necessary, nice to have, or redundant

public interface Stack {

// Interface for a Stack

    public void push(Object o);

    /* adds an object o to the top of a stack by placing it in the 
       reverse order of arrival relative to other items added to the 
       stack; that is, last in, first out (LIFO) */

    public Object pop();
 
    /* removes and returns the object placed in a stack most recentlt
       relative to any other items presently in the stack */

    public Object top();

    /* returns the Object placed in a stack most recently, or null
       if the stack contains no items */

    public boolean isEmpty();

    /* returns true when a stack currently contains no items, false 
       otherwise */

}  // Stack Interface
