//Fahia Tabassum (tabas015)
// Ladan Abdi (abdix213)
import java.util.Scanner;

/**
 * A class to handle the location and orientation of a ship.
 */
class shipLocation {

    /**
     * the X coordinate.
     */
    public int x;
    /**
     * The y coordinate.
     */
    public int y;
    /**
     * The orientation of the ship.
     */
    public int orientation; //1 for horizontal

    /**
     * Constructor for the location of the ship.
     *
     *  @param x the x coordinate
     *  @param y the y coordinate
     *  @param orientation the orientation of the ship
     */
    public shipLocation(int x, int y, int orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

}

/**
 * The board initializer and game controller.
 */
public class BattleboatsBoard {

    /**
     * Scanner to read input.
     */
    Scanner scanner;
    /**
     * Number of rows of the board.
     */
    final private int row;
    /**
     * Number of columns of the board.
     */
    final private int col;
    /**
     * The board 2D array.
     */
    private int[][] board;

    /**
     * Modes whether classes or expert.
     */
    final private int mode;

    /**
     * Number of turns.
     */
    private int turnCount = 0;
    /**
     * Total shots.
     */
    private int totalShots = 0;

    /**
     * Number of ships.
     */
    private int shipsCount = 0;
    /**
     * Number of drones used.
     */
    private int droneUsed;

    /**
     * Number of missel used.
     */
    private int misselUsed;

    /**
     * The lengths of the ships needed for the current mode.
     */
    final private int[] shipLengths;

    /**
     * Constructor to initiate the board class.
     *
     * @param md mode of the game
     *  @param sc scanner to scan input
     */
    public BattleboatsBoard(int md, Scanner sc) {
        scanner = sc;
        mode = md;
        if (mode == 1) {
            // standard mode
            row = col = 8;
            shipsCount = 5;
            shipLengths = new int[shipsCount];
            // lengths defined in the document
            shipLengths[0] = 5;
            shipLengths[1] = 4;
            shipLengths[2] = 3;
            shipLengths[3] = 3;
            shipLengths[4] = 2;
        } else {
            // expert mode
            row = col = 12;
            shipsCount = 10;
            shipLengths = new int[shipsCount];
            // lengths defined in the document
            shipLengths[0] = 5;
            shipLengths[1] = 5;
            shipLengths[2] = 4;
            shipLengths[3] = 4;
            shipLengths[4] = 3;
            shipLengths[5] = 3;
            shipLengths[6] = 3;
            shipLengths[7] = 3;
            shipLengths[8] = 2;
            shipLengths[9] = 2;
        }
        // initiate the board to be 0 (unexplored)
        board = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = 0;
            }
        }

        // generate random boats
        placeBoats();
    }

    /**
     * Function used to generate the location of the ships on the board.
     */
    final public void placeBoats() {
        int length;
        int[] arrayLength = new int[1];
        shipLocation[] locs;
        shipLocation randomLocation;
        for (int s = 0; s < shipLengths.length; s++) {
            arrayLength[0] = 0;
            length = shipLengths[s];
            locs = getAllValidLocations(length, arrayLength);
            randomLocation = locs[(int) Math.floor(Math.random() * arrayLength[0])];
            setBoat(length, randomLocation);
        }
    }

    /**
     * Set the boat on its location defined in the shipLocation parameter
     *
     *  shipLen the ship length
     *  loc the ship location parameter
     */
    private void setBoat(int shipLen, shipLocation loc) {
        if (loc.orientation == 1) {
            for (int i = loc.x; i < loc.x + shipLen; i++) {
                board[i][loc.y] = shipLen;
            }
        } else {
            for (int i = loc.y; i < loc.y + shipLen; i++) {
                board[loc.x][i] = shipLen;
            }
        }
    }

    /**
     * get all the valid locations that the ship can fit in
     *
     * @param shipLen the length if the ship
     * @param arrayLength the output array length (This is an array, As single
     * Integers are immutable)
     * @return the valid locations that the ship can fit in array.
     */
    private shipLocation[] getAllValidLocations(int shipLen, int[] arrayLength) {
        shipLocation[] locs = new shipLocation[row * col * 2];
        // get all horizontal
        for (int i = 0; i <= row - shipLen; i++) {
            for (int j = 0; j < col; j++) {
                if (validLocation(i, j, 1, shipLen)) {
                    locs[arrayLength[0]++] = new shipLocation(i, j, 1);
                }
            }
        }
        // get all vertical
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= col - shipLen; j++) {
                if (validLocation(i, j, 2, shipLen)) {
                    locs[arrayLength[0]++] = new shipLocation(i, j, 2);
                }
            }
        }

        return locs;
    }

    /**
     * Check if the location is valid for this ship.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param orien the orientation
     * @param len the length of the ship
     * @return true if the ship fits in this location
     */
    private boolean validLocation(int x, int y, int orien, int len) {
        if (orien == 1) {
            // horizontal
            for (int i = x; i < x + len; i++) {
                if (board[i][y] != 0) {
                    return false;
                }
            }
            return true;
        } else {
            // vertical
            for (int i = y; i < y + len; i++) {
                if (board[x][i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Control the turns of the player by getting niput from the user and act
     * upon it.
     */
    public void turns() {
        boolean gameOver = false;
        int turnX;
        int turnY;
        String decision = null;
        int check;
        while (!gameOver) {
            check = 0;
            System.out.print("Enter 1 to hit, 2 to drone, 3 to missel, 4 to print board: ");
            turnX = scanner.nextInt();
            if (turnX == 4) {
                // print
                display();
                continue;
            } else if (turnX == 2) {
                // drone
                if (mode == 1) {
                    if (droneUsed > 0) {
                        System.out.println("You have used max number of drone");
                        continue;
                    }
                } else if (mode == 2) {
                    if (droneUsed > 1) {
                        System.out.println("You have used max number of drone");
                        continue;
                    }
                }
                drone();
                droneUsed++;
            } else if (turnX == 3) {
                //missel
                if (mode == 1) {
                    if (misselUsed > 0) {
                        System.out.println("You have used max number of missels");
                        continue;
                    }
                } else if (mode == 2) {
                    if (misselUsed > 1) {
                        System.out.println("You have used max number of missels");
                        continue;
                    }
                }
                this.missile();
                misselUsed++;
            } else if (turnX == 1) {
                // hit
                System.out.print("Enter your coordinates: ");
                turnX = scanner.nextInt();
                turnY = scanner.nextInt();
                totalShots++;
                if (turnX < 0 || turnX >= row || turnY < 0 || turnY >= col
                        || board[turnX][turnY] < 0) {
                    decision = "penalty";
                } else if (board[turnX][turnY] == 0) {
                    decision = "miss";
                    board[turnX][turnY] = -1; // -1 for miss 
                } else if (board[turnX][turnY] > 0) {
                    decision = "hit";
                    if (isSunk(turnX, turnY)) {
                        decision = "sunk";
                    }
                    board[turnX][turnY] = -2; // -2 for hit
                }
                // ptint the output of the hit move
                System.out.println("Turn " + turnCount + ": " + "user selects ( " + turnX + "," + turnY + ") and " + decision);
                if (decision.equals("penalty")) {
                    turnCount++;
                    System.out.println("Turn " + turnCount + ": skipped");
                    continue;
                }
            }
            turnCount++;
            print();
            // check if the game is over.
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] > 0) {
                        check++;
                    }
                }
            }
            if (check == 0) {
                System.out.println("You have hit all target with " + turnCount
                        + " turns and " + totalShots + " shots");
                gameOver = true;
            }
        }

    }

    /**
     * Do the drone action.
     */
    public void drone() {
        int target = 0;
        int previous = -12; // any invalid number
        String choice;
        int number;
        System.out.print("Please enter r for droning a row or c for a column: ");
        choice = scanner.nextLine(); // to neglect the extra new line charcter
        choice = scanner.nextLine();
        while (choice.charAt(0) != 'c' && choice.charAt(0) != 'r') {
            System.out.println("Invalid input.");
            System.out.print("Please enter r for droning a row or c for a column: ");
            choice = scanner.nextLine();
        }
        boolean iscol = (choice.charAt(0) == 'c');

        System.out.print("Please enter the number of row or column: ");
        number = scanner.nextInt();

        while ((iscol && (number >= col)) || (!iscol && (number >= row)) || number < 0) {
            System.out.println("Invalid input.");
            System.out.print("Please enter the number of row or column: ");
            number = scanner.nextInt();
        }
        // start counting the number of the targets.
        if (iscol) {
            for (int i = 0; i < row; i++) {
                if (board[i][number] != previous && board[i][number] > 0) {
                    target++;
                    previous = board[i][number];
                }
            }
        } else {
            for (int i = 0; i < col; i++) {
                if (board[number][i] != previous && board[number][i] > 0) {
                    target++;
                    previous = board[number][i];
                }
            }
        }

        System.out.println("Drone has scanned " + target + " active "
                + "targets in the area");
    }

    /**
     * Do the fire action on this coordinates.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void fire(int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col
                || board[x][y] < 0) {
            // invalid spot to hit
            return;
        } else if (board[x][y] == 0) {
            board[x][y] = -1; // -1 for miss 
        } else if (board[x][y] > 0) {
            board[x][y] = -2; // -2 for hit
        }
    }

    /**
     * Do the missel action.
     */
    public void missile() {
        System.out.print("Where would you like to fire missile?, Enter valid coordinates: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if (x < 0 || x > row || y < 0 || y > col) {
            System.out.println("Invalid input.");
            System.out.print("Where would you like to fire missile?, Enter valid coordinates: ");
            x = scanner.nextInt();
            y = scanner.nextInt();
        }
        // fire at the 9 spots around the chosen spot.
        fire(x, y);
        fire(x + 1, y);
        fire(x - 1, y);
        fire(x, y + 1);
        fire(x, y - 1);
        fire(x + 1, y + 1);
        fire(x - 1, y - 1);
        fire(x + 1, y - 1);
        fire(x - 1, y + 1);

    }

    /**
     * Print the unexplored array board.
     */
    public void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == -1) {
                    System.out.print("O ");
                } else if (board[i][j] == -2) {
                    System.out.print("X ");
                } else {
                    System.out.print("- ");

                }
            }
            System.out.println("");
        }
    }

    /**
     * Display the board with the enemies on it.
     */
    public void display() {
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                System.out.printf("%2d ", board[x][y]);
            }
            System.out.println("");
        }

    }

    /**
     * get board 2D array.
     *
     * @return 2D array representing the board.
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * Returns true if the selected ship is sunk.
     *
     * @param turnX the x coordinate of the ship to be scanned
     * @param turnY the y coordinate of the ship to be scanned
     * @return
     */
    private boolean isSunk(int turnX, int turnY) {
        int currentShip = board[turnX][turnY];
        for (int i = 1; i < currentShip; i++) {
            if (((turnX + i >= row) ? false : currentShip == board[turnX + i][turnY])
                    || ((turnX - i < 0) ? false : currentShip == board[turnX - i][turnY])
                    || ((turnY + i >= col) ? false : currentShip == board[turnX][turnY + i])
                    || ((turnY - i < 0) ? false : currentShip == board[turnX][turnY - i])
                    || ((turnX + i >= row || turnY + i >= col) ? false : currentShip == board[turnX + i][turnY + i])
                    || ((turnX - i < 0 || turnY - i < 0) ? false : currentShip == board[turnX - i][turnY - i])
                    || ((turnX + i >= row || turnY - i < 0) ? false : currentShip == board[turnX + i][turnY - i])
                    || ((turnX - i < 0 || turnY + i >= col) ? false : currentShip == board[turnX - i][turnY + i])) {
                return false;
            }
        }
        return true;
    }

}
