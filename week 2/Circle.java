// Circle.java
// An approach to the recommended "Homework" to create a class and object instances
// to represnet circles
// main() test driver included below

public class Circle {

    // attributes

    private double radius;
    public static final double PI = 3.1415926;

    // constructors

    public Circle() {}

    public Circle(double r) { radius = r; }

    // selectors

    public double getRadius() { return radius; }

    public void setRadius(double r) { radius = r; }

    // operators

    public double getDiameter() { return 2 * radius; }

    public double getArea() { return PI * radius * radius; }

    public double getCircumference() { return 2 * PI * radius; }
 
    public double addArea(Circle anotherCircle) {
        return this.getArea() + anotherCircle.getArea();  }

    public double addCircumference(Circle anotherCircle) {
        return this.getCircumference() + anotherCircle.getCircumference();  }

    public String toString() { return "" + radius; }

    public boolean equals(Object anotherObject) {
        Circle temp;
        boolean same = false;
        if (anotherObject instanceof Circle) {
          temp = (Circle) anotherObject;
          if (temp.getRadius() == radius) 
            same = true;
        }
        return same;
    }  // equals

    public static void main(String[] args) {
        Circle c1 = new Circle(1.0);
        Circle c2 = new Circle(2.0);
        System.out.println("c1 toString() value is: " + c1);
        System.out.println("c2 toString() value is: " + c2);
        System.out.println("c1 equals c1? " + c1.equals(c1));
        System.out.println("c1 equals c2? " + c1.equals(c2));
        System.out.println("c1 radius is: " + c1.getRadius() + 
                           "; c1 area is: " + c1.getArea() + 
                           "; c1 area added to c2 is: " + c1.addArea(c2));
        System.out.println("c2 radius is: " + c2.getRadius() + 
                           "; c2 area is: " + c2.getArea() + 
                           "; c2 area added to c2 is: " + c2.addArea(c2));
    }  // main
}  // Circle
        

          
          

