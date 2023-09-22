package cs3500.pa01.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileScannerSrTest {
  FileScannerSr fs;
  ArrayList<String> questionStringFileE;
  String q1;
  String q2;
  String file;

  @BeforeEach
  void init() {
    fs = new FileScannerSr();
    q1 = " - is computer science hard::: yes *hard*";
    q2 = " - are you happy?::: yes *hard*";
    file = "testData/fileE/hard.sr";
    questionStringFileE = new ArrayList<String>(Arrays.asList(q1, q2));
  }

  @Test
  public void testFileScannerSr() {
    fs.scanFile(file);
    assertEquals(questionStringFileE, fs.qanda);
  }
}