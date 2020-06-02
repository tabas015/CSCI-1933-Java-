// Names:  Fahia Tabassum (tabas015) & Ladan Abdi (abdix213)


import java.util.Random;

public class MyMaze{
    Cell[][] maze;
    //More convenient access rather than maze.length and maze[0].length
    int rows, cols;

    public MyMaze(int rows, int cols) {
        maze = new Cell[rows][cols];

        //Create 2D array of Cell
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                maze[i][j] = new Cell();

        this.rows = rows;
        this.cols = cols;
    }

    /**
     * Create CellPos object corresponding to cell at i, j (if not already visited and i, j are valid)
     * @param i The row to check
     * @param j The column to check
     * @return null or CellPos with the cell at i, j
     */
    private CellPos at(int i, int j) {
        if (i < 0 || i >= rows) return null;
        if (j < 0 || j >= cols) return null;
        if (maze[i][j].getVisited()) return null;
        return new CellPos(i, j);
    }

    /**
     * Make a masze of size rows x cols
     * @param rows The number of rows
     * @param cols The number of columns
     * @return newly generated maze
     */
    public static MyMaze makeMaze(int rows, int cols) {
        //Create a blank maze
        MyMaze maze = new MyMaze(rows, cols);
        Random rnd = new Random();
        int xOff[] = {0, 1, 0, -1, 0, 1, 0};    //Repeat first 3 so can use 4 consecutive pairs
        int yOff[] = {-1, 0, 1, 0, -1, 0, 1};   //Ditto

        StackGen<CellPos> stack = new Stack1Gen<>();
        // Start at 0, 0
        CellPos curr = maze.at(0, 0);
        curr.visit();
        stack.push(curr);

        // While maze is not full
        while (!stack.isEmpty()) {
            curr = stack.top();
            // Start with random ordinal direction
            int index = rnd.nextInt(4);
            CellPos next = null;
            // Consider all 4 ordinal directions (starting at random initial)
            for (int i = 0; i < 4; i++) {
                next = maze.at(curr.i + yOff[index + i], curr.j + xOff[index + i]);
                if (next != null) break;
            }
            // No neighbors
            if (next == null) {
                stack.pop();
            } else {
                //We have visited this cell now
                next.visit();
                stack.push(next);

                //Check left and right
                if (curr.j > next.j) {
                    next.setRight();
                }
                if (next.j > curr.j) {
                    curr.setRight();
                }

                //Check up and down
                if (curr.i > next.i) {
                    next.setBottom();
                }
                if (next.i > curr.i) {
                    curr.setBottom();
                }
            }
        }

        // Mark all the maze as unvisited
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                maze.maze[i][j].setVisited(false);

        // Mark the exit
        maze.maze[rows - 1][cols - 1].setRight(false);
        return maze;
    }

    /**
     * Display the maze
     * @param path Display the visited status or not?
     */
    public void printMaze(boolean path) {
        // Mark top line
        for (int j = 0; j < cols; j++) {
            System.out.print("|---");
        }
        System.out.println("|");

        // Display each row
        for (int i = 0; i < rows; i++) {
            // Mark left side (special case 0, 0)
            System.out.print(i != 0 ? "|" : " ");

            // Display each cell
            for (int j = 0; j < cols; j++) {
                Cell cell = maze[i][j];

                // Is cell visited?
                if (cell.getVisited() & path) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
                // Does the cell have right wall
                if (cell.getRight()) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();

            System.out.print("|");

            // Display the bottom of each cell
            for (int j = 0; j < cols; j++) {
                Cell cell = maze[i][j];
                if (cell.getBottom()) {
                    System.out.print("---|");
                } else {
                    System.out.print("   |");
                }
            }
            System.out.println();
        }
    }

    /* TODO: Solve the maze using the algorithm found in the writeup. */
    public void solveMaze() {
        QGen<CellPos> q = new Q1Gen<>();

        // Create a Queur starting at 0, 0
        CellPos curr = at(0, 0);
        curr.visit();
        q.add(curr);
        CellPos other = null;

        // While we have more in the queue
        while (q.length() != 0) {
            curr = q.remove();
            // If we reach the end point then stop
            if (curr.i == rows - 1 && curr.j == cols - 1) {
                break;
            }

            other = at(curr.i, curr.j - 1);
            // Check to the left, and there is a gap
            if (other != null && other.right()) {
                other.visit();
                q.add(other);
            }

            other = at(curr.i, curr.j + 1);
            // Check to the right, and there is a gap
            if (other != null && curr.right()) {
                other.visit();
                q.add(other);
            }

            other = at(curr.i - 1, curr.j);
            // Check above, and there is a gap
            if (other != null && other.bottom()) {
                other.visit();
                q.add(other);
            }

            other = at(curr.i + 1, curr.j);
            // Check below, and there is a gap
            if (other != null && curr.bottom()) {
                other.visit();
                q.add(other);
            }

        }
    }

    public static void main(String[] args){
        /* Any testing can be put in this main function */
        MyMaze maze = makeMaze(5, 20);
        maze.solveMaze();
        maze.printMaze(true);
    }

    private class CellPos {
        public int i, j;
        public Cell cell;

        /**
         * Create a cell and store the position it was it
         * @param i The row
         * @param j The column
         */
        public CellPos(int i, int j) {
            cell = maze[i][j];
            this.i = i;
            this.j = j;
        }

        // Can we move right
        public boolean right() {
            return !cell.getRight();
        }

        // Can we move down
        public boolean bottom() {
            return !cell.getBottom();
        }

        // We open door to the right
        public void setRight() {
            cell.setRight(false);
        }

        // We open door at the bottom
        public void setBottom() {
            cell.setBottom(false);
        }

        // Mark cell as visited
        public void visit() {
            cell.setVisited(true);
        }
    }
}
