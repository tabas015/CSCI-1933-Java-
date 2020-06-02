// BTNGen.java 
// Generic Binary Tree Node (reduced to minimum)
// Analogous to NGen.java
// Contains no extra Tree methods
// This Generic Binary Tree Node (BTNGen.java) is an instantiable 
// class for nodes in a Binary Tree of Generic type
// Spring 2019 

// Each node consists of:
//   * data <comparable <T>>
//   * left branch
//   * right branch
// Either or both the left and right branches of a node can be null
// In addition to the constructor, several accessor methods are included
// which are similar to those discussed/written in lecture

public class BTNGen<T extends Comparable<T>> {

  // constructor

    public BTNGen(T d, BTNGen<T> l, BTNGen<T> r) {

        data = d;
        left = l;
        right = r;
    }

  // getters and setters 
  // selectors

    public BTNGen<T> getLeft()   { return left; }
    public BTNGen<T> getRight()  { return right; }
    public T getData()   { return data; }

  // modifiers

    public void setLeft(BTNGen<T> l)   { left = l; }
    public void setRight(BTNGen<T> r)  { right = r; }
    public void setData(T d)   { data = d; }

  // instance variables

    private T data;
    private BTNGen<T> left;
    private BTNGen<T> right;
    
}  // BTNGen.java
