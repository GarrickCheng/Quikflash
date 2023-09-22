package cs3500.pa01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Comparator;

/**
 *  sorts the files based off of creation time
 */
public class CreatedSort implements Comparator<File> {
  /**
   * compares two files' creation time
   *
   * @param f1 the first file to be compared.
   * @param f2 the second file to be compared.
   * @return the comparator to compare two files and sort them
   */
  public int compare(File f1, File f2) {
    FileTime firstTime = null;
    FileTime secondTime = null;
    try {
      BasicFileAttributes fileAttributes1 = Files.readAttributes(f1.toPath(),
          BasicFileAttributes.class);
      firstTime = fileAttributes1.creationTime();
    } catch (IOException e) {
      System.out.println("can't get attributes of file");
    }
    try {
      BasicFileAttributes fileAttributes2 = Files.readAttributes(f2.toPath(),
          BasicFileAttributes.class);
      secondTime = fileAttributes2.creationTime();
    } catch (IOException e) {
      System.out.println("can't get attributes of file");
    }
    return firstTime.compareTo(secondTime);
  }
}
