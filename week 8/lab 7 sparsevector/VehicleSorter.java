public class VehicleSorter {
	public static void main(String[] args) {
		Vehicle[] vehicles = new Vehicle[5];

		/*	TODO:
			Add vehicle objects of different types to your array. e.g.

			vehicles[0] = new Car("Ford Mustang GT", 425.5);
			... etc ...

			Make sure your list is not in sorted order when you create it!
		*/

		sortVehicles(vehicles);

		for (Vehicle v : vehicles) {
			System.out.println(v);
		}
	}

	public static void sortVehicles(Vehicle[] list) {
		/*	TODO:
			Implement some type of sorting algorithm using the compareTo method in the vehicle class.

			You MAY NOT use any of Java's built in sorting algorithms. It does not matter which 
			algorithm you choose, as long as it is stable.
		*/
	}
}