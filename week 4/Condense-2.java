// Condense.java
// February 2019
// Compresses and array of ints where -1 means an empty location
// Uses no extra space (except a temp scaler), runs in linear time,
// and is stable--maintaining the original order of the non -1 data
 
public class Condense {
  
    public static void condense(int[] a) {
        // moves all -1 elements to end of the array

        int firstOpen = 0;
        int temp;  // holds current array value; 
                   // needed when there are no -1's
                   // near the top, and elements are 
                   // not moved up; eliminates the
                   // need to treat moved values
                   // any differently from values that 
                   // are not moved;
                   // use of temp eliminates need to 
                   // set remaining open elements to -1
                   // in a separate loop when all done

        for (int i = 0; i < a.length; i++) {
            if (a[i] != -1) {
              temp = a[i];
              a[i] = -1;  // overwritten in next line when
                          // old location and new location
                          // are the same
              a[firstOpen++] = temp;
            }  // if
        }  // for

    }  // condense

    public static void main(String[] args) {

        int[] a = {-1, 4, -1, -1, 2, 5, -1, 3, -1};
        condense(a);
        for(int i = 0; i < a.length; i++) {
            System.out.println("index " + i + " is " + a[i]);
        }
    }
}  // Condense
