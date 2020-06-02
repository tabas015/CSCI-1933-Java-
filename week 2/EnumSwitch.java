// EnumSwitch.java
// Revised 1/2020
// Values for switch expressions can be int, char, String, enum.
// Here they are enum

public class EnumSwitch {

    public enum Values {ZERO, ONE, TWO, THREE, FOUR, FIVE};

public static void main(String[] args) {
    Values v = Values.FOUR;    
    switch (v) { //  v is an enumerated typs
        case ZERO: System.out.println("Your number is 'zero'");
                break;  // the breaks are normally always needed
        case ONE: System.out.println("Your number is 'one'");
                break;
        case TWO: System.out.println("Your number is 'two'");
                break;
        case THREE: System.out.println("Your number is 'three'");
                break;
        case FOUR: System.out.println("Your number is 'four'");
                break;
        case FIVE: System.out.println("Your number is 'five'");
                break;
        default: System.out.println("The number is outside of the range 0 - 5");
    }
}  // main method
}  // EnumSwitch class
