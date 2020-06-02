public class Helicopter extends Vehicle {
  // Instance Variables
  private String model;
  private double horsepower;

  // Constructor
  public Helicopter (String model, double horsepower) {
    numVehicles += 1;
    this.model = model;
    this.horsepower = horsepower;
  }

  // Getters
  public String getModel() {return model;}
  public double getHorsepower() {return horsepower;}

  // Methods
  public void movingForward() { System.out.println("Helicopter moving forwards"); }
  public void movingBackward() { System.out.println("Helicopter moving backwards"); }
  public void movingUp() { System.out.println("Helicopter moving up"); }
  public void movingDown() { System.out.println("Helicopter moving down"); }

}
