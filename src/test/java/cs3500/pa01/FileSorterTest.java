package cs3500.pa01;

import static cs3500.pa01.FlagEnum.CREATED;
import static cs3500.pa01.FlagEnum.FILENAME;
import static cs3500.pa01.FlagEnum.MODIFIED;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * class for FileSorter test
 */

class FileSorterTest {
  ArrayList<File> fileList1;
  File file1;
  File file2;
  File file3;
  File file4;

  FileSorter fs;
  FileScanner fsc;

  ArrayList<File> sortedFileList1ByName;
  ArrayList<File> sortedFileList2ByCreated;
  ArrayList<File> sortedFileList4ByModified;

  @BeforeEach
  void init() {
    file1 = new File("testData/cs3500/c.md");
    file2 = new File("testData/cs3500/d.md");

    fileList1 = new ArrayList<File>(Arrays.asList(file1, file2));
    sortedFileList1ByName = new ArrayList<File>(Arrays.asList(file1, file2));
    sortedFileList2ByCreated = new ArrayList<File>(Arrays.asList(file1, file2));
    sortedFileList4ByModified = new ArrayList<File>(Arrays.asList(file1, file2));
    fsc = new FileScanner();
    fs = new FileSorter(fsc);
  }

  @Test
  public void testSortFilesName() {
    fs.sortFiles(FILENAME, fileList1);
    assertEquals(sortedFileList1ByName, fileList1);
  }

  @Test
  public void testSortFilesCreated() {
    fs.sortFiles(CREATED, fileList1);
    assertEquals(sortedFileList2ByCreated, fileList1);
  }

  @Test
  public void testSortFilesModified() {
    fs.sortFiles(MODIFIED, fileList1);
    assertEquals(sortedFileList4ByModified, fileList1);
  }




}



