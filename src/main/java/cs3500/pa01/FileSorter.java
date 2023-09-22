package cs3500.pa01;


import static cs3500.pa01.FlagEnum.CREATED;
import static cs3500.pa01.FlagEnum.FILENAME;
import static cs3500.pa01.FlagEnum.MODIFIED;

import cs3500.pa01.model.FileScannerSr;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * sorts the files in the list of files based on the sort type
 */
public class FileSorter {
  private FileScanner fsc;

  public FileSorter(FileScanner fsc) {
    this.fsc = fsc;
  }

  /**
   * sorts a list of files depending on the sort type
   *
   * @param sortType the second argument in the command line. decides how to sort the list of files
   * @param files a list of files to be sorted
   */
  public void sortFiles(FlagEnum sortType, ArrayList<File> files) {
    if (sortType.equals(FILENAME)) {
      ArrayList<String> nameFileList = new ArrayList<String>();
      for (File diffFile : files) {
        nameFileList.add(diffFile.getPath());
      }
      nameFileList.sort((path1, path2) -> {
        String fileName1 = getFileName(path1);
        String fileName2 = getFileName(path2);
        return fileName1.compareTo(fileName2);
      });
      fsc.fileScanner(nameFileList);
    }

    if (sortType.equals(CREATED)) {
      files.sort(new CreatedSort());
      ArrayList<String> createdFileList = new ArrayList<String>();
      for (File diffFile : files) {
        createdFileList.add(diffFile.getPath());
      }
      fsc.fileScanner(createdFileList);
      System.out.println(files);
    }

    if (sortType.equals(MODIFIED)) {
      files.sort(new ModifiedSort());
      ArrayList<String> modifiedFileList = new ArrayList<String>();
      for (File diffFile : files) {
        modifiedFileList.add(diffFile.getPath());
      }
      fsc.fileScanner(modifiedFileList);
      System.out.println(files);
    }
  }

  /**
   * gets the file name from the path
   *
   * @param path the path to the file in string
   * @return the name of the file in string
   */
  public static String getFileName(String path) {
    int lastSlashIndex = path.lastIndexOf("/");
    if (lastSlashIndex != -1 && lastSlashIndex < path.length() - 1) {
      return path.substring(lastSlashIndex + 1);
    }
    return path;
  }
}


