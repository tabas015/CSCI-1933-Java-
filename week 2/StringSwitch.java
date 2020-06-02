// StringSwitch.java
// Revised 1/2020
// Mutually exclusive *String* cases implemented with a switch. 
// Values for the switch expression can be integer, String or enum
// Here they are String

public class StringSwitch {

public static void main(String[] args) {
    if (args.length != 0) {
        switch (args[0]) { // recall:  args[0] is a String
        case "0": System.out.println("Your number is 'zero'");
                break;  // the breaks are normally always needed
        case "1": System.out.println("Your number is 'one'");
                break;
        case "2": System.out.println("Your number is 'two'");
                break;
        case "3": System.out.println("Your number is 'three'");
                break;
        case "4": System.out.println("Your number is 'four'");
                break;
        case "5": System.out.println("Your number is 'five'");
                break;
        default: System.out.println("The number is outside of the range 0 - 5");
        }
    } // if
}  // main method
}  // StringSwitch class
