package cs3500.pa01;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * scans all the different files and combines them with correct format
 */
public class FileScanner {
  public StringBuilder bracketedOrHastag = new StringBuilder();
  private StringBuilder temp = new StringBuilder();
  public StringBuilder questions = new StringBuilder();
  private ArrayList<String> qanda = new ArrayList<String>();
  private boolean inBracket = false;

  /**
   * Reads the contents from a file to a String
   *
   * @param allPaths all paths for every file that need to be scanned
   */
  public void fileScanner(ArrayList<String> allPaths) {
    for (String allPath : allPaths) {
      Path theFile = Path.of(allPath);
      Scanner input = null;
      try {
        input = new Scanner(theFile);
      } catch (IOException e) {
        e.printStackTrace();
      }

      while (input.hasNext()) {
        String line = input.nextLine();
        if (line.contains("#") && line.charAt(0) == '#') {
          bracketedOrHastag.append(line);
          bracketedOrHastag.append("\n");
        } else if (line.isEmpty()) {
          bracketedOrHastag.append("\n");
        } else {
          for (String word : line.split(" ")) {
            if (word.startsWith("[[") && !inBracket) {
              temp.append("- ");
              temp.append(word.substring(word.indexOf("[[") + 2));
              inBracket = true;
            }
            if (inBracket && !word.contains("]]") && !word.startsWith("[[")) {
              temp.append(" ");
              temp.append(word);
            }
            if (word.contains("]]")) {
              temp.append(" ");
              temp.append(word, 0, word.indexOf("]]"));
              temp.append("\n");
              inBracket = false;
            }
          }
          if (temp.indexOf(":::") == -1) {
            bracketedOrHastag.append(temp);
            temp = new StringBuilder();
          } else if (temp.toString().contains("\n")) {
            questions.append(temp.substring(0, temp.indexOf("\n")));
            questions.append(" *hard*");
            questions.append("\n");
            qanda.add(temp.toString());
            temp = new StringBuilder();
          }
        }
      }
    }
  }
}