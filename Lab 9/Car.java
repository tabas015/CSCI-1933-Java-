public class Car extends Vehicle {
  // Instance Variables
  private String model;
  private double horsepower;

  // Constructor
  public Car (String model, double horsepower) {
    numVehicles += 1;
    this.model = model;
    this.horsepower = horsepower;
  }

  // Getters
  public String getModel() {return model;}
  public double getHorsepower() {return horsepower;}

  // Methods
  public void movingForward() { System.out.println("Car moving forwards"); }
  public void movingBackward() { System.out.println("Car moving backwards"); }

}
