// Bubble.java
// bubble sort
// Revised 2/2020

public class Bubble {

public static void bubbleSort(int[] a) {
    int i, j, temp;
    boolean swapped = true;
    int counter = 0;

    for (i = 0; i < a.length && swapped == true; i++) {
        swapped = false;
        for (j = 1; j < a.length - i; j++) {
            counter++;
            if (a[j] < a[j-1]) {
              swapped = true;
              temp = a[j];
              a[j] = a[j-1];
              a[j-1] = temp;
            }
        }
    }
    System.out.println("Iterations through inner loop: " + counter) ;
}  // bubbleSort

public static void display(int[] a) {
    int i;
    for (i = 0; i < a.length; i++)
        System.out.println(a[i]);
}  // display

public static void main(String[] args) {
    int a[] = {4, 5, 2, 7, 6, 1, 3};
    int b[] = {1, 2, 3, 4, 5, 6, 7};
    int c[] = {7, 6, 5, 4, 3, 2, 1};

    System.out.println("Bubble sort ...");
    System.out.println("\nFirst array:");
    display(a);
    bubbleSort(a);
    display(a);
    System.out.println("\nSecond array:");
    display(b);
    bubbleSort(b);
    display(b);
    System.out.println("\nThird array:");
    display(c);
    bubbleSort(c);
    display(c);
}

} // Bubble
