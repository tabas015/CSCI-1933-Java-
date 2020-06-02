

import java.util.Scanner;  // Import the Scanner clas
import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.PrintWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileNotFoundException;  // Import this class to handle errors

public class BookshelfReader {

  // Gets books and makes a Bookshelf object
  public static Bookshelf readBooksFromFile(String fileName) throws FileNotFoundException{
    File f = new File(fileName);
    Scanner scanLines = new Scanner(f);
    Scanner reader = new Scanner(f);

    // Find out how many books we're adding
    int numLines = 0;
    while(scanLines.hasNextLine()){
        numLines++;
        String s = scanLines.nextLine();
    }
    scanLines.close();
    Bookshelf b = new Bookshelf(numLines);

    while (reader.hasNextLine()) {
      String data = reader.nextLine(); // Get CSV stuff
      // Split data into 3 parts
      String[] sArray = data.split(","); // Put data into array

      // Delete Whitespace
      /*
      // Deletes all whitespace
      sArray[0] = sArray[0].replaceAll("\\s+","");
      sArray[1] = sArray[1].replaceAll("\\s+","");
      sArray[2] = sArray[2].replaceAll("\\s+","");
      */
      sArray[1] = sArray[1].substring(1); // Deletes first character

      Book currentBook = new Book(sArray[0], sArray[1], Double.parseDouble(sArray[2]));

      b.add(currentBook); // add it to the Bookshelf
    }
    reader.close();
    b.sort('r'); // Sort by rating
    return b;
  }

  // Takes Bookshelf and writes to to a file
  public static void writeShelfToFile(Bookshelf b, String fileName) throws IOException{
    FileWriter fileWriter = new FileWriter(fileName);
    PrintWriter printWriter = new PrintWriter(fileWriter);
    printWriter.print(b);
    printWriter.close();
  }
}
