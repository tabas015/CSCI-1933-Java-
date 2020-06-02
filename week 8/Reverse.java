import java.util.Scanner;
//package Chapter2;
public class Reverse {
  public static void main(String args[]){
    IntNode n1, n2, n3, n4, n5, n6,n7, n8, n9;
    n9 = new IntNode(10, null);
    n8 = new IntNode(9, n9);
    n7 = new IntNode(8, n8);
    n6 = new IntNode(6, n7);
    n5 = new IntNode(5, n6);
    n4 = new IntNode(4, n5);
    n3 = new IntNode(3, n4);
    n2 = new IntNode(2, n3);
    n1 = new IntNode(1, n2);
    System.out.println(n1);
    //reverse(n1);
    System.out.println(n9);
    
  }

  /*public static void reverse(IntNode head){
    if(head == null)
        return null;
    if(head.link == null)
        return null;
    
    IntNode pre = null;
    IntNode current = head;
    IntNode next;
    
    while(current != null){
        next = current.link;
        current.link = pre;
        pre = current;
        current = next;
    }
    
    //return pre;
  }*/
}

