package cs3500.pa01.filemaker;

import java.io.File;
import java.nio.file.Path;

/**
 * interface for creating files
 */
public interface FileMaker {
  public void writeToFile(Path file, String contents);
}
