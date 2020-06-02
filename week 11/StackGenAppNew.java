// StackGenAppNew.java
// This demo creates Stacks of a more specific type than Object
// to illustrate the advantage of generics for type conflict
// error detection at compile time (instead of at runtime).

// Application using Stack1Gen or Stack2Gen implementation of the StackGen Interface
// Since both Stack1Gen and Stack2Gen implement the same interface, it makes no
// difference which implementation is used.
// Making a simple change to the variable declaration for the stack will allow
// changing between the StackGen implementations.

// The stack variable type might better be StackGen to hide the underlying
// linked list of stack implementation, but Stack1Gen and Stack2Gen are
// used here to emphasize which underlying implementatio is used.

public class StackGenAppNew {

    public static void main(String[] args) {

//        Stack1Gen <Integer> s = new Stack1Gen <Integer> ();  // linked list stack implementation
        Stack2Gen <Integer> s =  new Stack2Gen <Integer> ();  // array stack implementation
    
        System.out.println();
        if (s.isEmpty())
          System.out.println("The stack is empty");
        else System.out.println("The stack is not empty");

//        s.pop();  // should produce an Exception

        System.out.println("Top to start is: " + s.top());  // should be null

        s.push(4);
        s.push(5);
        s.push(6);

        System.out.println("Pop: " + s.pop() + ";  New top: " +
            s.top().toString());
        System.out.println("Pop: " + s.pop() + ";  New top: " +
            s.top().toString());
        System.out.println("Pop: " + s.pop() + ";  New top: " +
            s.top());

        System.out.println("New top: " + s.top());
        System.out.println();
 
    }  // main method

}  // StackGenAppNew class
