// Insert.java
// insertion sort
// Revised 2/2020

public class Insert {

public static void insertionSort(int[] a) {
    int i, j, n;
    int counter = 0;

    for (i = 1; i < a.length; i++) {
        n = a[i];
        for (j = i-1; j >= 0 && n < a[j]; j--) {
            counter++;
            a[j+1] = a[j];
        }
        a[j+1] = n;
    }
    System.out.println("Iterations through inner loop: " + counter);
}  // insertionSort

public static void display(int[] a) {
    int i;
    for (i = 0; i < a.length; i++)
        System.out.println(a[i]);
}  // display

public static void main(String[] args) {
    int a[] = {4, 5, 2, 7, 6, 1, 3};
    int b[] = {1, 2, 3, 4, 5, 6, 7};
    int c[] = {7, 6, 5, 4, 3, 2, 1};

    System.out.println("Insertion sort ...");
    System.out.println("\nFirst array:");
    display(a);
    insertionSort(a);
    display(a);
    System.out.println("\nSecond array:");
    display(b);
    insertionSort(b);
    display(b);
    System.out.println("\nThird array:");
    display(c);
    insertionSort(c);
    display(c);
}

}  // Insert
