// Switch.java
// Mutually exclusive cases implemented with a *switch* construct
// Updated 2/2020

// How would this be done with *if* statements instead?  Try it.
// Would the ifs be nested or non-nested, and would it make a 
// difference whether they would be nested or not?

// What happens if one or more of the "break" statements are removed?
// When would you want to remove a break, if ever?
// Why should a "default" case always be part of a switch?
// Would you be able to mimic the behavior of the switch that
// is missing breaks with an if construct?

public class Switch {

public static void main(String[] args) {
    int i;
    if (args.length != 0) {
        i = Integer.valueOf(args[0]); // get integer value of args[0]
        switch (i) {  // i must be a scalar valued expression
                      // char or String will also work
        case 0: System.out.println("Your number is 'zero'");
                break;  // the breaks are normally always needed
        case 1: System.out.println("Your number is 'one'");
                break;
        case 2: System.out.println("Your number is 'two'");
                break;
        case 3: System.out.println("Your number is 'three'");
                break;
        case 4: System.out.println("Your number is 'four'");
                break;
        case 5: System.out.println("Your number is 'five'");
                break;
        default: System.out.println("The number is ouside of the range 0 - 5");
        }
    } // if
}  // main method
}  // Switch class
