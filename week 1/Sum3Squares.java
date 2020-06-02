// Sum3Squares.java
// Revised 1/2020
// Computes the sum of the squares of ints evenly divisible by 3 
// between a lower and upper bound entered at the command line

public class Sum3Squares {

    public static void main(String[] args) {
        
        int low;
        int high;
        int sum;

        if (args.length != 2)
          System.out.println("Wrong number of arguments supplied.");
        else {
          low = Integer.parseInt(args[0]);
          high = Integer.parseInt(args[1]);
          sum = 0;
          low--;
          while (low < high) {
            low++;
            if (low % 3 == 0)
              sum += Math.pow(low, 2); 
          }
          System.out.println("The sum of the squares of ints evenly divisible by 3" +
              " between " + args[0] + " and " + args[1] + " (inclusive) is: " + sum);
        }
    }  // main

}  // Sum3Squares
          
