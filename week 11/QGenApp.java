// QGenApp.java
// Queue Application using Q1Gen or Q2Gen implementation of the QGen interface

public class QGenApp {

    public static void main(String[] args) {

//        Q1Gen <Object> q = new Q1Gen <Object> ();  // linked list queue implementation
        Q2Gen <Object> q = new Q2Gen <Object> ();  // array queue implementation
     
        if (q.length() == 0)
          System.out.println("The queue is empty");
        else System.out.println("The queue is not empty");

        q.add(new String("hello"));
        System.out.println("'hello' added - Q Length is: " + q.length());
        q.remove();
        System.out.println("'hello' removed - Q Length is: " + q.length());
        q.add(new Double(7.1));
        System.out.println("'7.1' added - Q Length is: " + q.length());
        q.add(new String("abc"));
        System.out.println("'abc' added - Q Length is: " + q.length());

        System.out.println("Remove: " + q.remove().toString());
        System.out.println("- Q Length is: " + q.length());
        System.out.println("Remove: " + q.remove().toString());
        System.out.println("- Q Length is: " + q.length());
        System.out.println("Remove: " + q.remove());
        System.out.println("- Q Length is: " + q.length());

        if (q.length() == 0)
          System.out.println("Queue is empty");
        else System.out.println("Queue is not empty");

        q.remove();

        if (q.length() == 0)
          System.out.println("Queue is empty");
        else System.out.println("Queue is not empty"); 

    }  // main method

}  // QGenApp class
