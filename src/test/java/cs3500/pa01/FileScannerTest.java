package cs3500.pa01;

import static cs3500.pa01.Main.main;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * class for file scanner test
 */
class FileScannerTest {
  String fileC;
  String fileD;
  ArrayList<String> files;
  FileScanner fs;

  @BeforeEach
  void init() {
    fileC = "testData/cs3500/c.md";
    fileD = "testData/cs3500/d.md";

    files = new ArrayList<String>(Arrays.asList(fileC, fileD));
    fs = new FileScanner();
    fs.fileScanner(files);
  }

  @Test
  public void invalidArgsSecondPath() {
    assertThrows(RuntimeException.class,
        () -> main(new String[] {}));
    //assertEquals();
  }
}