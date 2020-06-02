// BTNodeGen.java 
// Generic Binary Tree Node 
// Spring 2019 
// Updated April 2020
// Generic Binary Tree Node (BTNodeGen.java) is an instantiable 
// class for nodes in a Binary Tree of Generic type

// BTNodeGen.java has the SAME fields and methods as BTNGen.java:
//   * data <comparable <T>>
//   * left branch 
//   * right branch

// BTNodeGen.java also includes several binary tree methods similar to 
// those developed in lecture; some are implemented twice--recursively
// and iteratively
// These binary tree methods are included work relative to "this" node

// Because of the additional binary tree methods included here,
// BTNodeGen.java is used as the underlying nodes for a 
// Binary *Search* Tree in class BSTGen.java

// BTNodeGen.java includes a main() test driver that uses Number.java
// as data, so be sure to have Number.java available when running
// this code.


public class BTNodeGen<T extends Comparable<T>> {

  // constructor

    public BTNodeGen(T d, BTNodeGen<T> l, BTNodeGen<T> r) {

        data = d;
        left = l;
        right = r;
    }

  // selectors

    public BTNodeGen<T> getLeft()   { return left; }
    public BTNodeGen<T> getRight()  { return right; }
    public T getData()   { return data; }

  // modifiers

    public void setLeft(BTNodeGen<T> l)   { left = l; }
    public void setRight(BTNodeGen<T> r)  { right = r; }
    public void setData(T d)   { data = d; }

    public void display() {
      // display "this" node and its immediate children, if any 

        System.out.print("data = " + data);
        if (left != null)
            System.out.print(", left child = " + left.getData());
        if (right != null)
            System.out.print(", right child = " + right.getData());
        System.out.println();
    }

    public String toString() {
      // data conversion

        return data.toString();
    }

  // general Binary Tree methods

    public int getMaxDepth() {  // assuming root is at depth 1
      // recursive getMaxDepth -- returns depth starting from current node

        if ((left == null) && (right == null))
            return 1;
        else if (left == null)
            return (1 + right.getMaxDepth());
        else if (right == null)
            return (1 + left.getMaxDepth());
        else
            return (1 + (int) Math.max(left.getMaxDepth(),
                                       right.getMaxDepth()));
    }

    public BTNodeGen<T> removeRightMost() {
      // removes right most node and returns modified (smaller) tree

        if (right == null)
            return left;
        else {
            setRight(right.removeRightMost());
            return this;
        }
    }

    public BTNodeGen<T> removeLeftMost() { 
      // removes left most node and returns the new (smaller) tree

        if (left == null)
            return right;
        else {
            setLeft(left.removeLeftMost());
            return this;
        }
    }

    public T getLeftMostDataR() {
      // recursive getLeftMostData method
      // returns the left most Object found under this node

        if (left == null)
            return data;
        else
            return left.getLeftMostDataR();
    }

    public T getLeftMostDataI() {
      // iterative getLeftMostData method
      // returns the left most Object found under this node

        T ans;
        if (left == null)
            ans = data;
        else {
            BTNodeGen<T> ptr = left;
            while (ptr.getLeft() != null) 
                ptr = ptr.getLeft();
            ans = ptr.getData();
        }
        return ans;
    }

    public T getRightMostDataR() {
      // recursive getRightMostData method
      // returns the right most Object found under this node

        if (right == null)
            return data;
        else
            return right.getRightMostDataR();
    }

    public T getRightMostDataI() {
      // iterative getRightMostData method
      // returns the right most Object found under this node

        T ans;
        if (right == null)
            ans = data;
        else {
            BTNodeGen<T> ptr = right;
            while (ptr.getRight() != null) 
                ptr = ptr.getRight();
            ans = ptr.getData();
        }
        return ans;
    }

  // instance variables

    private T data;
    private BTNodeGen<T> left;
    private BTNodeGen<T> right;


public static void main(String[] args) {
    // testing program

    BTNodeGen<Number> t = new BTNodeGen<Number>(new Number(1, 2), null, null);
    System.out.println(t.toString());
    Number n1 = new Number(3, 4);
    Number n2 = new Number(0, 1);
    if (t.getData().compareTo(n1) < 0)  // root < new item
      t.setRight(new BTNodeGen<Number>(n1, null, null));
    else t.setLeft(new BTNodeGen<Number>(n1, null, null));
    if (t.getData().compareTo(n2) < 0)  // root < new item
      t.setRight(new BTNodeGen<Number>(n2, null, null));
    else t.setLeft(new BTNodeGen<Number>(n2, null, null));
    System.out.println(t.toString());
    System.out.println("Left most: " +  t.getLeftMostDataI().toString());
    System.out.println("Right most: " +  t.getRightMostDataI().toString());
    System.out.println("Max Depth: " + t.getMaxDepth());
    System.out.println("removed right: " + t.removeRightMost().toString());
    
}  // main

    
}  // BTNodeGen.java
