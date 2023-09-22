package cs3500.pa01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Comparator;

/**
 * class to sort a list of files by modified date
 */
public class ModifiedSort implements Comparator<File> {
  /**
   * compares two files
   *
   * @param f1 the first object to be compared.
   * @param f2 the second object to be compared.
   * @return integer for compare
   */
  public int compare(File f1, File f2) {
    FileTime firstTime = null;
    FileTime secondTime = null;
    try {
      BasicFileAttributes fileAttributes1;
      fileAttributes1 = Files.readAttributes(f1.toPath(), BasicFileAttributes.class);
      firstTime = fileAttributes1.lastModifiedTime();
    } catch (IOException e) {
      System.out.println("can't get attributes of file");
    }
    try {
      BasicFileAttributes fileAttributes2;
      fileAttributes2 = Files.readAttributes(f2.toPath(), BasicFileAttributes.class);
      secondTime = fileAttributes2.lastModifiedTime();
    } catch (IOException e) {
      System.out.println("can't get attributes of file");
    }
    return firstTime.compareTo(secondTime);
  }
}

