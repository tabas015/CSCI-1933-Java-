//Fahia Tabassum (tabas015)
// Ladan Abdi (abdix213)

import java.util.Scanner;


public class BattleboardGame {

    public static Scanner scanner;
    /**
     * Main function to call the controllers of the game and intiiate the board.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int mode;
        scanner = new Scanner(System.in);
        System.out.print("Hello welcome to BattleBoats!\nPlease enter 1 to play in Standard mode or enter 2 to play in Expert mode: ");
        mode = scanner.nextInt();
        while (mode != 1 && mode != 2) {
            System.out.println("Invalid Input");
            System.out.print("Please enter 1 to play in Standard mode or enter 2 to play in Expert mode: ");
            mode = scanner.nextInt();
        }
        BattleboatsBoard bb = new BattleboatsBoard(mode,scanner);
        bb.turns();
    }
}
