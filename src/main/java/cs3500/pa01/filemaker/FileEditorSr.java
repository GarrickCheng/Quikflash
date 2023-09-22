package cs3500.pa01.filemaker;

import cs3500.pa01.model.FileScannerSr;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * class to edit the existing question file
 */
public class FileEditorSr implements FileMaker {
  /**
   * Writes the given String to the given filepath.
   *
   * @param file     where to write the contents
   * @param contents contents to write to the file
   */
  @Override
  public void writeToFile(Path file, String contents) {

    byte[] data = contents.getBytes();

    try {
      Files.write(file, data);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}