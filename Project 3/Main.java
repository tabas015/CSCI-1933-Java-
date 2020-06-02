// smi00903 & tabas015

public class Main {
    public static void main(String[] args) {
        // Add 5 elements to the String list

        // Uncomment line below to test LinkedLists
        //LinkedList<String> testString = new LinkedList<String>();
        ArrayList<String> testString = new ArrayList<String>();
        
        System.out.println("\nString List: ");
        testString.add("a");
        testString.add("b");
        testString.add("c");
        testString.add("d");
        testString.add("e");
        System.out.println(testString);

        // remove(element) test
        System.out.println("Removing Node with c...");
        testString.remove("c");
        System.out.println(testString);

        System.out.println("Removing Node at index 3...");
        testString.remove(3);
        System.out.println(testString);

        // add(index, element) test
        System.out.println("Adding c to index 2...");
        testString.add(2, "c");
        System.out.println(testString);

        System.out.println("Adding e to index 4...");
        testString.add(4, "e");
        System.out.println(testString);

        // contains() test
        System.out.println("Does testString contain k? " + testString.contains("k"));
        System.out.println("Does testString contain e? " + testString.contains("e"));
        // isEmpty() test
        System.out.println("Is testString empty? " + testString.isEmpty());
        // get() test
        System.out.println("The element at index 1 is " + testString.get(1));
        // indexOf() test
        System.out.println("The first index of b is " + testString.indexOf("b"));
        
        System.out.println("Adding b...");
        testString.add("b");
        System.out.println(testString);
        System.out.println("The last index of b is " + testString.lastIndexOf("b"));


        // set() test
        System.out.println("Setting index 1 to k...");
        testString.set(1, "k");
        System.out.println("Setting index 2 to j...");
        testString.set(2, "j");
        System.out.println("Setting index 3 to m...");
        testString.set(3, "m");

        System.out.println(testString);

        System.out.println("Sorting List Ascendingly...");
        testString.sort(true);
        System.out.println(testString);


        System.out.println("Sorting List Descendingly...");
        testString.sort(false);
        System.out.println(testString);

    }
}