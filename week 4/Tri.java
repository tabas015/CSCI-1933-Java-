// Tri.java
// Revised 2/2020
// Method to determine if a square matix is upper triangular
// A matrix is upper triangular if all elements below the
// main diagonal are 0.  The main diagonal is the elements
// (0, 0), (1, 1), (2, 2) ...

public class Tri {
    public static boolean isUpperTriangular(int[][] m) {
        for(int row = 1; row < m.length; row++)
            for(int col = 0; col < row; col++)
                if (m[row][col] != 0)
                  return false;
        return true;
    }
    
    public static void main(String[] args) {
        int[][] m1 = {{1, 1, 1}, {0, 1, 1}, {0, 0, 4}};
        int[][] m2 = {{1, 1, 1}, {1, 1, 1}, {0, 0, 0}};
        System.out.println("m1: " + isUpperTriangular(m1));
        System.out.println("m2: " + isUpperTriangular(m2));
    }
}
