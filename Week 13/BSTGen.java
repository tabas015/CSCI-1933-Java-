// BSTGen.java
// Binary *Search* Tree Implementation 
// BSTGen.java is a wrapper class that uses BTNodeGen.java for 
// the underlying binary tree nodes
// The generic queue, Q1.Gen.java which implements QGen.java, 
// is used along with NGen.java, so be sure to have these files 
// present when running this code.
// New April 2020

// These Basic Binary Search Tree methods are provided:
// * constructor
// * isEmpty() empty tree predicate
// * display() to print entire tree contents to screen
// * add()  
// * remove()  
// * search()  

// Total order semantics are assumed:
//   * each element to the left of the root is <= the root
//   * each item to the right of the root is > the root

public class BSTGen<T extends Comparable<T>> {

  //  constructor - Default constructor only

    private BTNodeGen<T> head = null;

  // selectors

    public boolean isEmpty() {
     // returns true if the tree is empty

        return (root == null);
    }

  // utility

    public void display() {
        // displays binary search tree in level order
        // as it appears on a page:  left to right,
        // top to bottom

        if (root != null) {
          Q1Gen<BTNodeGen> q  = new Q1Gen<BTNodeGen>();  
          q.add(root);
          while (q.length() != 0) {
              BTNodeGen ptr = q.remove();
              System.out.println("Node: " + ptr.getData()); 
              if (ptr.getLeft() != null) {
                q.add(ptr.getLeft());
                System.out.println("  Left: " + ptr.getLeft().getData());
              }
              if (ptr.getRight() != null) {
                q.add(ptr.getRight());
                System.out.println("  Right: " + ptr.getRight().getData());
              }
          }  // while
        } 
    }  // display

  // Binary Search Tree algorithms

    public void add(T d) {
      // iterative insertion 

        if (root == null) 
            root = new BTNodeGen<T>(d, null, null);
        else {
            BTNodeGen<T> ptr = root, parent = null;
            while (ptr != null) {
                parent = ptr;
                // current data  <= d
                if (d.compareTo(ptr.getData()) <= 0) 
                    ptr = ptr.getLeft();
                else
                    ptr = ptr.getRight();
            }  // while
            ptr = new BTNodeGen<T>(d, null, null);
            if (d.compareTo(parent.getData()) <= 0) 
                parent.setLeft(ptr);
            else
                parent.setRight(ptr);
        }
    }  // add


    public boolean remove(T d) {
      // modified from similar method written by Alec Shinomiya Fall 2016
      // recursive remove (uses removeHelper below)
        System.out.println("HERE");

        if (root==null)
          return false;
        else return removeHelper(root, null, d);
    }
 
    public boolean removeHelper(BTNodeGen<T> ptr, BTNodeGen<T> parent, T d)  {
      // recursive remove
      // modified from similar method written by Alec Shinomiya Fall 2016

        if (ptr == null)           // CASE 0: not found, tree unchanged
            return false;

        // Cases 1, 2, 3 below apply when item is found in the BST

        if (ptr.getData().compareTo(d) == 0) {  // item found -- 3 cases 
          
          if (ptr.getLeft() == null) {  // CASES 1 and 2: item to be removed
                                        //                has no left branch
            if (ptr == root)       // CASE 1: item to be removed is at root
                root = root.getRight();
            else {                 // CASE 2: item to be removed not at root
                if (ptr == parent.getLeft())  // item to be removed is on parent's left
                    parent.setLeft(ptr.getRight());
                else  // item to be removed is on parent's right 
                    parent.setRight(ptr.getRight());
            }
          }
        else {                     // CASE 3: a left branch exists
            ptr.setData(ptr.getLeft().getRightMostDataR());
            ptr.setLeft(ptr.getLeft().removeRightMost());
        }

        return true;
        }
        else if (ptr.getData().compareTo(d) > 0)
               return removeHelper(ptr.getLeft(), ptr, d);
        else return removeHelper(ptr.getRight(), ptr, d);
    }  // removeHelper  

    public BTNodeGen search(T d) {
      // iterative search
      // has side-effect of printing Found/Not Found info to screen

        BTNodeGen<T> ptr = root;
        int compare;
       
        if (ptr == null) 
          compare = 0;
        else compare = d.compareTo(ptr.getData()); 
        while (ptr != null && compare != 0) {
            if (compare < 0) {
                System.out.print(" left ");
                ptr = ptr.getLeft();
            }
            else {
                System.out.print(" right ");
                ptr = ptr.getRight();
            }
            if (ptr == null)
              compare = 0;
            else compare = d.compareTo(ptr.getData());
        }  // while
        if (ptr == null)
            System.out.println(" [Not Found!]");
        else
            System.out.println(" [Found!]");

        return ptr;
    }  //search

  // local data

    protected BTNodeGen<T> root;

    public static void main(String[] args) {
        BSTGen<String> t = new BSTGen<String>();
        t.add("a");
        t.add("b");
        t.add("x");
        t.add("w");
        t.add("z");
        t.add("k");
        t.display();
        t.search("z");
        t.remove("a");
        t.display();
        t.remove("x");
        t.display();
    }  // main

}  // BSTGen
