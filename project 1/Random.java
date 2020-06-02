// Name- Fahia Tabassum
// tabas015
// Random Class
import java.util.Scanner;
public class Random {
  private int P1; // variables
  private int P2;
  private int M;
  int seed;
  int counter;
  public Random(int P1, int P2, int M) {
  // initializing variables
    this.P1 = P1;
    this.P2 = P2;
    this.M = M;
    seed = 0;
  }
  public void setSeed(int seed){
    this.seed = seed;
  }
  public int getMaximum(){
    return M;
  }
  public int random(){
    seed = ((P1*seed)+P2) % M; // r(old) = seed; as given in the problem
    return seed;               // set the r(new) to seed without making any other extra r(new) variable
  }
  public int randomInteger(int lower, int upper){
    if (lower > upper){
      int temp = 0;
      temp = lower;
      lower = upper;
      upper = temp;
    } // swapped lower and upper
    int v = (random()% (upper - lower) +1 )+ lower;

    return v;
  }
  public boolean randomBoolean() {
    return (random() % 2 == 0);
  }

  public double randomDouble(double lower, double upper){
    if (lower > upper){
      double temp = 0;
      temp = lower;
      lower = upper;
      upper = temp;
    }
    double x =  ((double) random()) / M  ;
    return (x  * (upper-lower)) + lower ;
  }
  public int getSeed(){
    return seed;
  } //getting the seed

  public static void main(String[] args) {
    Random r = new Random(7919, 65537, 102611);

    System.out.println("The maximum value is: ");
    System.out.println(r.getMaximum());

    System.out.println("The random new(r new) values are: ");
    for(int i=0; i<10; i++){
      System.out.println(r.random());
    }

    
    int trueCounter = 0;
    int falseCounter = 0;
    boolean value;
    for(int i=0; i<100; i++){
      value = r.randomBoolean();
      if (value){
        trueCounter++;
      }
      else{
        falseCounter++;
      }
    }
    System.out.println("The random boolean values are: ");
    System.out.println("True: " + trueCounter + " times"); // counting how many times the method 
    System.out.println("False: " + falseCounter +" times"); // gives true and false
    
    System.out.println("The random integer values between 1 and 5 are: ");
    for(int i=0; i<10; i++){
      System.out.println(r.randomInteger(1,5));
    }

    System.out.println("The random double values between 1.0 and 5.0 are: ");
    for(int i=0; i<10; i++){
      System.out.println(r.randomDouble(1.0,5.0));
    }
  } //main method
} // random class
