// Select.java
// selection sort
// Source originally derived from Wikipedia "selection sort" page 9/3/2013
// Revised 2/2020

public class Select {
  public static void selectionSort(Book[] a) {
    int i, j, minIndex, temp;
    int counter = 0;

    for (i = 0; i < a.length - 1; i++) {
      minIndex = i;
      for (j = i+1; j < a.length; j++) {
        counter++;
        if (a[j] < a[minIndex])
          minIndex = j;
      }
      temp = a[minIndex];
      a[minIndex] = a[i];
      a[i] = temp;
    }
    System.out.println("Iterations through inner loop: " + counter);

  }  // selectionSort

  public static void display(int[] a) {
    int i;
    for (i = 0; i < a.length; i++)
      System.out.println(a[i]);
  }  // display
}  // Select
