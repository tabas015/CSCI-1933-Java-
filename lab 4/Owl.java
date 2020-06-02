import java.util.Scanner;
public class Owl{
  private String name;
  private int age;
  private double weight;
  public Owl(String name, int age, double weight) {

    this.name = name;
    this.age = age;
    this.weight = weight;
  }
  public boolean equals(Owl other) {
    if (name.equals(other.name) && this.age == other.age && this.weight == other.weight){
      return true;
    }
    else
      return false;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age){
    this.age = age;
  }
  public double getWeight(){
    return weight;
  }
  public void setWeight(double weight) {
    this.weight = weight;
  }
  public static void main(String[] args) {
    Owl owlOne = new Owl("Zillu",2,75);
    Owl owlTwo = new Owl("Willu",3,85);

    System.out.println("owlOne.equals(owlTwo) = " + owlOne.equals(owlTwo));
    owlTwo.setName("Zillu");
    owlOne.setAge(3);
    owlTwo.setWeight(75);
    System.out.println("owlOne.equals(owlTwo) = " + owlOne.equals(owlTwo));
  }

}
  