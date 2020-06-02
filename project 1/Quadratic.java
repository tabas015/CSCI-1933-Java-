// Fahia Tabassum
// tabas015
// Quadratic class
import java.util.Scanner;
public class Quadratic{
  private float a;
  private float b;
  private float c;
  private float d;
  public Quadratic(float a, float b, float c){
    this.a = a;
    this.b = b;
    this.c = c;
    float d = b * b - 4 * a * c;
  }

  // accessor methods
  public void setA(float value) {
    a = value;
  }
  public void setB(float value) {
    b = value;
  }
  public void setC(float value) {
    c = value;
  }
  public float getA() {
    return a;
  }
  public float getB() {
    return b;
  }
  public float getC() {
    return c;
  }

  //operators
  public Quadratic add(Quadratic other){
    float addA;
    float addB;
    float addC;
    addA = this.a + other.getA();
    addB = this.b + other.getB();
    addC = this.c + other.getC();
    Quadratic quadratic = new Quadratic(addA,addB,addC);
    return quadratic;
  }
  public Quadratic subtract(Quadratic other){
    float subA;
    float subB;
    float subC;
  
    subA = this.a - other.getA();
    subB = this.b - other.getB(); 
    subC = this.c - other.getC();
    Quadratic quadratic = new Quadratic(subA,subB,subC);
    return quadratic;
  }
  public Roots findRoots(){
    float d = b * b - 4 * a * c; //disciriminant 
    float pos = d; 

    if(pos < 0){
      pos = pos * -1; //if d gets negative then this pos variable will work well for it 
    }
    
    float x =  (float)(Math.sqrt(pos)) / (2 * a); 
    float y = (float)(-(Math.sqrt(pos))) / (2 * a); 
    
    float z = (-b /((2*a))); // for real part

    Roots roots;
    Complex4 root1, root2;

    if (d >0){
      root1 = new Complex4(z + x,0); 
      root2 = new Complex4(z - y,0);
    }

    else{
      root1 = new Complex4(z,x);
      root2 = new Complex4(z,y);
    }
    roots = new Roots (root1,root2);
    return roots;
  }
  public String toString(){
    String signA = "";
    if (a>=0){
      signA = "";
    }
    
    String signB = "";
    if (b>=0){
      signB = " +";
    }
  
    String signC = "";
    if (c>=0){
      signC = " +";
    }
    
    return (""+ signA + a + "x^2 "+ signB + b + "x"+ signC + c + "");
  }

  public boolean equals(Object other){
    Quadratic temp;
    if (other instanceof Quadratic) {
      temp = (Quadratic) other;
      if (a == temp.getA() && b == temp.getB() && c == temp.getC()){
        return true;
      } 
    }
    return false;
  }
  
  public static void main(String[] args) {
    Quadratic q1 = new Quadratic(9,-4,1);
    System.out.print("The first quadratic function is: q1 = ");
    System.out.println(q1.toString());
    System.out.print("For q1 ");
    System.out.println(q1.findRoots());


    Quadratic q2 = new Quadratic(10,5,1);
    System.out.print("The second quadratic function is: q2 = ");
    System.out.println(q2.toString());
    System.out.print("For q2 ");
    System.out.println(q2.findRoots());


    Quadratic q3 = new Quadratic(9,-4,1);
    System.out.print("The third quadratic function is: q3 = ");
    System.out.println(q3.toString());
    System.out.print("For q3 ");
    System.out.println(q3.findRoots());


    System.out.print("By adding q1 and q2 we get:");
    System.out.println(q1.add(q2));
    System.out.print("By subtracting q1 and q2 we get:");
    System.out.println(q1.subtract(q2));
    System.out.print("q1 and q2 equal to one another?: ");
    System.out.println(q1.equals(q2));
    System.out.print("q1 and q3 equal to one another?: ");
    System.out.println(q1.equals(q3));
  }
}

