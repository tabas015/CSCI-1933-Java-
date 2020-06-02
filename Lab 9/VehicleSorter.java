// Zachary S & Fahia T
public class VehicleSorter {

	public static void main(String[] args) {
		Vehicle[] vehicles = new Vehicle[5];

		vehicles[0] = new Car("Ford Mustang GT", 425.5);
		vehicles[1] = new Boat("Catamaran", 2.1);
		vehicles[2] = new Helicopter("Boeing CH-47 Chinook", 2200.0);
		vehicles[3] = new Boat("Pontoon", 165.5);
		vehicles[4] = new Car("Nissan Z 370", 332);

		// Milestone 1
		System.out.println("Milestone 1: ");
		Drivable b = new Bike();
		b.movingForward();
		Scooter s = new Scooter();
		s.movingBackward();

		// Milestone 2
		System.out.println("\nMilestone 2: ");
		// Gotta do a typecast because the compiler sees vehicles[2] as a Vehicle, not Helicopter
		((Helicopter)vehicles[2]).movingUp();
		vehicles[3].movingForward();

		// Milestone 3
		System.out.println("\nMilestone 3: ");
		vehicles = sortVehicles(vehicles);
		for (Vehicle v : vehicles) {
			System.out.println(v);
		}
	} // Main

	public static Vehicle[] sortVehicles(Vehicle[] list) {
		boolean swapped = true;
		int counter = 0;
		Vehicle temp;

		// bubbleSort
		for (int i = 0; i < list.length && swapped == true; i++) {
			swapped = false;
			for (int j = 1; j < list.length - i; j++) {
				counter++;

				if (list[j].compareTo(list[j-1]) == 1) {
					swapped = true;
					temp = list[j];
					list[j] = list[j-1];
					list[j-1] = temp;
				}
			}
		}

		return list;
	} // sortVehicles

} // Class
