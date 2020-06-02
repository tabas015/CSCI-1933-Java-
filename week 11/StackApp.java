// StackApp.java
// Application using Stack1 or Stack2
// Since both Stack1 and Stack2 implement the Stack interface, it makes no
// difference which implementation is used.
// Making a simple change to the variable declaration for the stack will allow
// changing between implementations
// Updated April 2020

public class StackApp {

    public static void main(String[] args) {

        //Stack1 s1 = new Stack1();  // linked list Stack implementation
        Stack2 s = new Stack2();  // array Stack implementation
        
      
        if (s.isEmpty())
          System.out.println("The stack is empty");
        else System.out.println("The stack is not empty");

        System.out.println("Top to start is: " + s.top());  // should be null

        s.push(new String("hello"));
        s.push(new Double(7.1));
        s.push(new String("abc"));
        try {

        System.out.println("Pop: " + s.pop().toString() + ";  New top: " +
            s.top().toString());
        System.out.println("Pop: " + s.pop().toString() + ";  New top: " +
            s.top().toString());
        System.out.println("Pop: " + s.pop().toString() + ";  New top: " +
            s.top());
        System.out.println("New top: " + s.top());
        System.out.println();
        s.pop();
        }
        catch(RuntimeException e) {
        System.out.println("caught"); }

        System.out.println("What really happened here?");
 
    }  // main method

}  // StackApp class
