// SortTest.java
// Compares performance of Bubble, Insertion, Selection sorts
// Creates randomly sized arrays (up to length 30)
// and displays the number of inner loop iterations to
// show the relative performance of the three basic sorts
// Revised 2/2019


public class SortTest {

public static int[] clone(int[] a) {
    int[] ar = new int[a.length];
    for (int i = 0; i < ar.length; i++)
        ar[i] = a[i];
    return ar;
}

public static void main(String[] args) {
    int[] a;
    int[] copy;
    a = new int[(int) (Math.random() * 40)];
    
    for (int i = 0; i < a.length; i++)
        a[i] = (int) (30 * Math.random());
    System.out.println("The array to start looks like this: ");
    Bubble.display(a);
    System.out.print("\nBubble sort: ");
    copy = clone(a);
    Bubble.bubbleSort(copy);
    Bubble.display(copy);
    System.out.print("\nInsertion sort: ");
    copy = clone(a);
    Insert.insertionSort(copy);
    Insert.display(copy);
    System.out.print("\nSelection sort: ");
    copy = clone(a);
    Select.selectionSort(copy);
    Select.display(copy);
}
}
    
