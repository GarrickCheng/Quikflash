package cs3500.pa01;


import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * walks the files with a given task
 */
public class FileWalkerMd implements FileVisitor<Path> {
  ArrayList<File> pathFile = new ArrayList<File>();
  /**
   * handles what happens when you visit a file
   *
   * @param file
   *          a reference to the file
   * @param attr
   *          the file's basic attributes
   *
   * @return a list of the files that ends with md
   */

  public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
    Path currFile = file;

    if (file.getFileName().toString().endsWith(".md")) {
      pathFile.add(currFile.toFile());
    }

    return CONTINUE;
  }

  /**
   * handles what happens after you visit a file
   *
   * @param dir a reference to the directory
   * @param exec
   *          {@code null} if the iteration of the directory completes without
   *          an error; otherwise the I/O exception that caused the iteration
   *          of the directory to complete prematurely
   *
   * @return continue to the next file
   */
  public FileVisitResult postVisitDirectory(Path dir, IOException exec) {
    return CONTINUE;
  }

  /**
   * handles what happens before you visit a file
   *
   * @param dir
   *          a reference to the directory
   * @param attrs
   *          the directory's basic attributes
   *
   * @return continue to the next file
   * @throws IOException throws io exception
   */
  public FileVisitResult preVisitDirectory(Path dir,
                                           BasicFileAttributes attrs) throws IOException {
    return CONTINUE;
  }

  /**
   * handles what happens if it fails to visit a file
   *
   * @param file
   *          a reference to the file
   * @param exc
   *          the I/O exception that prevented the file from being visited
   *
   * @return continue to the next file
   */
  public FileVisitResult visitFileFailed(Path file, IOException exc) {
    return CONTINUE;
  }
}

// create instance of it and give it paths