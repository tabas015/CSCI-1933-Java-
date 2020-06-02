import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OwlPopulation {
    private String fileName;
    private Owl[] data;


    public void populateData() throws FileNotFoundException{
        File f = new File(fileName);
        Scanner scanner = new Scanner(f);

        int numLines = 0;
        while(scanner.hasNextLine()){
            numLines++;
            String s = scanner.nextLine();
        }
        scanner.close();

        data = new Owl[numLines];   //data is is allocated the exact amount of space it needs
        scanner = new Scanner(f);
        data = new Owl[numLines]; //data is is allocated the exact amount of space it needs
        scanner = new Scanner(f);

      // allocates data with a series of owls from the csv
        for (int i=0; i<numLines; i++) {
            String s = scanner.nextLine(); // get csv stuff
            String[] sArray = s.split(","); // put data into array

            int sArrayAge = Integer.parseInt(sArray[1]); // turn 2nd element (age) into int
            double sArrayWeight = Double.parseDouble(sArray[2]); // turn 3rd element (weight) into double
            data[i] = new Owl(sArray[0], sArrayAge, sArrayWeight);
        }
        scanner.close();
    }

        //TODO: Populate the data with owls constructed from the lines of the file given
    }

    public OwlPopulation(String fileName) throws FileNotFoundException{
        //TODO: Populate the class variables in OwlPopulation
    }

    public double averageAge(){

        int total = 0;

        for (int i=0; i<data.length; i++) {
            total += data[i].getAge();
        }
        return (total / data.length);
    }
        
    public Owl getYoungest(){
        Owl youngest = data[0]; // initialize lowest to first Owl
        int[] a = new int[data.length]; // store ages of Owls

    // First, make sure there's a definitive lowest age
        for (int i=0; i<data.length; i++) {
            a[i]=data[i].getAge();
        }
        Arrays.sort(a);
        if (a[0] == a[1]) {
            return null; // If there's no lowest age, return null
        }
        
        return null;
    }
     //If there is a definitive age...
    // Loop through all the ages of the population
        for (int i=0; i<data.length; i++) {
            if (data[i].getAge() < youngest.getAge()) { // If you find a lower age, change lower to that owl
                youngest = data[i];
            }
        }
        return youngest;
    }

    public Owl getHeaviest(){
        Owl heaviest = data[0]; // initialize lowest to first Owl
        double[] a = new double[data.length]; // store ages of Owls

    // First, make sure there's a definitive max weight
        for (int i=0; i<data.length; i++) {
            a[i]=data[i].getWeight();
        }
        Arrays.sort(a);
        if (a[data.length-1] == a[data.length-2]) {
            return null; // If there's no lowest weight, return null
        }

    // If there is a definitive weight...
    // Loop through all the weights of the population
        for (int i=0; i<data.length; i++) {
            if (data[i].getWeight() > heaviest.getWeight()) { // If you find a lower age, change lower to that owl
                heaviest = data[i];
            }
        }
        return heaviest;
    }
        
      
    public String toString(){
          
        String youngest = ("The youngest Owl is " + getYoungest().getName() + " at " + getYoungest().getAge() + " years old.");
      
        String heaviest = ("\nThe heaviest Owl is " + getHeaviest().getName() + " at " + getHeaviest().getAge() + " lbs.");
      
        String averageAge = ("\nThe average age of the populate is " + averageAge() + " years old.");
        return (youngest + heaviest + averageAge);
    }

        

    public boolean containsOwl(Owl other){
        //TODO: method you can implement as a helper function to your merge method
        return false;
    }
    public void merge(OwlPopulation other){
        Owl[] big;
        Owl[] small;

    // If self is bigger than other
        if (popSize() > other.popSize()) {
            big = getData();
            small = other.getData();
        }
        else {
            big = other.getData();
            small = getData();
        }

        int numToRemove = 0;
        Owl[] newOwl = new Owl[sizeOf() + other.sizeOf()];

    // Add info from big array
        for (int i=0; i<big.length; i++) {
            newOwl[i] = big[i];
        }
    // Add info from small array
        for (int i=0; i<small.length; i++) {
            newOwl[i+big.length] = small[i];
        }

        int[] x = new int[100];
        int z = 0;
    // Clean data in new array and get rid of duplicates
        for (int i=0; i<newOwl.length; i++) { // for big array
            for (int j=0; j<newOwl.length; j++) { // for small array
                if (newOwl[i].equals(newOwl[j])) {
          // Note which value j is duplicate
                    x[z] = j;
                    z++;
                    numToRemove++;
          //arrayRemove(big, i); // ERROR: OUT OF BOUNDS
          //i++; // we're shrinking big, so that messes with the loop bounds. We need to change something
        }
      }
    }
    // Now we need to shrink x to be the same size as numToRemove

    // Then remove the duplicates noted in x
    int[] removing = new int[numToRemove];
    for (int i=0; i<numToRemove; i++) {
      arrayRemove(newOwl, x[])
    }

    data = a;
        int [] firstArray = populateData("owlPopulation1.java")
        int [] secondArray = populateData("owlPopulation2.java")
        int length = firstArray.length + secondArray.length
        int[] mergedArray = newInt[length];


        int pos = 0;

        for (int element : firstArray{
            mergedArray[pos] = element;
            pos ++;
        }
        for (int element : firstArray{
            mergedArray[pos] = element;
            pos ++;
        }
        System.out.println(Arrays.toString(mergedArray));

        for(int i = 0; i < firstArray.length; i++){
            for(int j = 0; j < secondArray.length; j++){
                if(a[i] == b[j]){
                    firstArray = ArrayUtils.remove(firstArray, i); 
                    secondArray = ArrayUtils.remove(secondArray, i);
                }
            }
        }
                    
                    

    public int popSize(){
        return data.length;
    }
    
    public static void main(String[] args) {
        try {

            //The following should run when you are complete. Feel free to comment out as you see fit while you work.
            OwlPopulation pop1 = new OwlPopulation("owlPopulation1.csv");
            System.out.println(pop1);
            System.out.println(pop1.popSize());

            OwlPopulation pop2 = new OwlPopulation("owlPopulation2.csv");
            System.out.println(pop2);
            System.out.println(pop2.popSize());

            pop1.merge(pop2);
            System.out.println(pop1);
            System.out.println(pop1.popSize());

        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
        }
    }


}
