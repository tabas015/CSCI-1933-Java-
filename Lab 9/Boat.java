public class Boat extends Vehicle {
  // Instance Variables
  private String model;
  private double horsepower;

  // Constructor
  public Boat (String model, double horsepower) {
    numVehicles += 1;
    this.model = model;
    this.horsepower = horsepower;
  }

  // Getters
  public String getModel() {return model;}
  public double getHorsepower() {return horsepower;}

  // Methods
  public void movingForward() { System.out.println("Boat moving forwards"); }
  public void movingBackward() { System.out.println("Boat moving backwards"); }
  public void hoistAnchor() { System.out.println("Boat hoisting anchor"); }
  public void dropAnchor() { System.out.println("Boat dropping anchor"); }

}
