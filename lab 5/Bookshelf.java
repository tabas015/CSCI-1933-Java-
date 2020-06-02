// TODO: Make a sorting algorithm

public class Bookshelf {
  private Book[] book_array;
  private int nextEmpty;

  // Constructor
  public Bookshelf() {
    // Initialize book array with size 20
    book_array = new Book[20];
    nextEmpty = 0;

  }
  // 2nd Constructor, if you want a specific Bookshelf size
  public Bookshelf(int array_size) {
    book_array = new Book[array_size];
    nextEmpty = 0;
  }

  // METHODS
  // Adds a book to the bookshelf if there's space
  public boolean add(Book newBook) {
    if (nextEmpty != book_array.length) {
      book_array[nextEmpty] = newBook;
      nextEmpty++;
      return true;
    }
    // Else, return false
    return false;
  }

  // Return an array of books by the author
  public Bookshelf getBooksByAuthor(String author) {
    int n_author = 0;

    // Find number of books by the author
    for (int i=0; i<book_array.length; i++) {
      if (book_array[i].getAuthor().equals(author)) {
        n_author++;
      }
    }
    // Book[] byAuthor = new Book[n_author];
    Bookshelf byAuthor = new Bookshelf(n_author);
    int z = 0; // Independent counter
    // Find number of books by the author
    for (int i=0; i<book_array.length; i++) {
      if (book_array[i].getAuthor().equals(author)) {
        //byAuthor[z] = book_array[i];
        byAuthor.add(book_array[i]);
        //z++;
      }
    }
    return byAuthor;
  }

  // Bubble sort
  public void sort(char sortBy) {
    int i, j;
    Book temp;
    boolean swapped = true;
    int counter = 0;

    for (i = 0; i < book_array.length && swapped == true; i++) {
      swapped = false;
      for (j = 1; j < book_array.length - i; j++) {
        counter++;
        if (book_array[j].compareTo(book_array[j-1], sortBy) <= 0){
          swapped = true;
          temp = book_array[j];
          book_array[j] = book_array[j-1];
          book_array[j-1] = temp;
        }
      }
    }
  }


  // Build and return a string of all the books
  public String toString() {
    // Format: Name, Author, Rating
    String output = "";
    for (int i=0; i<book_array.length; i++) {
      output += book_array[i].getTitle();
      output += ", ";
      output += book_array[i].getAuthor();
      output += ", ";
      output += book_array[i].getRating();
      output += "\n";
    }
    return output;
  }

  // MAIN
  public static void main(String[] args) {
    try {
      // Create Bookshelf from file
      String fileName = "bookinput.txt";
      BookshelfReader r = new BookshelfReader();
      Bookshelf b = r.readBooksFromFile(fileName);
      r.writeShelfToFile(b, "output.txt");


      // GetByAuthor Tests
      Bookshelf bestBooks = b.getBooksByAuthor("Tolkien");
      System.out.println("Books by Tolkien: ");
      System.out.println(b.getBooksByAuthor("Tolkien"));
      r.writeShelfToFile(bestBooks, "bestBooks.txt");



      // toString tests
      System.out.println("Sorted by rating: ");
      System.out.println(b);
      b.sort('t');
      System.out.println("Sorted by title: ");
      System.out.println(b);
    }
    catch (Exception e) {
      System.out.println("Error");
    }
  }
}
