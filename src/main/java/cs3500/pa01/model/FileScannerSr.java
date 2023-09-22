package cs3500.pa01.model;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * scans all the different files and combines them with correct format
 */
public class FileScannerSr {
  private StringBuilder temp = new StringBuilder();
  public ArrayList<String> qanda = new ArrayList<String>();
  private boolean inQuestion;

  /**
   * Reads the contents from a file to a String
   *
   * @param srFile path of the file given by the user
   */
  public void scanFile(String srFile) {
    Path theFile = Path.of(srFile);
    Scanner input = null;
    try {
      input = new Scanner(theFile);
    } catch (IOException e) {
      e.printStackTrace();
    }

    while (input.hasNext()) {
      String line = input.nextLine();
      for (String word : line.split(" ")) {
        if (word.startsWith("-")) {
          inQuestion = true;
        }
        if (inQuestion) {
          temp.append(" ");
          temp.append(word);
        }
        if (word.equals("*hard*") || word.equals("*easy*")) {
          inQuestion = false;
        }
        if (!inQuestion) {
          qanda.add(temp.toString());
          temp = new StringBuilder();
        }
      }
    }
  }
}