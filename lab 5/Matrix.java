
// Fahia Tabassum

public class Matrix {
  private int nrows;
  private int ncols;
  private int[][] matrix;

  // Default Constructor
  public Matrix (int nrows, int ncols) {
    this.nrows = nrows;
    this.ncols = ncols;
    matrix = new int[nrows][ncols];
  }

  // Optional Constructor
  public Matrix (int[][] arr) {
    for (int i=0; i<arr.length; i++) {
      for (int j=0; j<arr[i].length; j++) {
        ncols = arr.length;
        nrows = arr[i].length;
      }
    }
    matrix = new int[ncols][nrows];
    matrix = arr;
  }

  // METHODS
  public Matrix transpose() {
    Matrix newMatrix = new Matrix(ncols, nrows);

    for (int i=0; i<nrows-1; i++) {
      for (int j = 0; j<ncols-1; j++) {
        newMatrix.matrix[j][i] = this.matrix[i][j];
      }
    }
    return newMatrix;
  }

  public String toString() {
    String output = "";
    for (int i=0; i<nrows-1; i++) {
      output += "[";
      for (int j=0; j<ncols-1; j++) {
        output += matrix[i][j];
        if (j != ncols-2)
          output += ", ";
      }
      output += "]\n";
    }
    return output;
  }

  // MAIN
  public static void main(String[] args) {
    int nrows = 3;
    int ncols = 4;
    int[][] a = new int[nrows][ncols];

    // Allocate 2D array
    for (int i=0; i<nrows; i++) {
      for (int j=0; j<ncols; j++) {
        a[i][j] = j;
      }
    }
    Matrix m = new Matrix(a); // Create Matrix based on array
    System.out.println("Original: ");
    System.out.println(m);

    System.out.println("Tranposed: ");
    m = m.transpose();
    System.out.println(m);

  }
}
