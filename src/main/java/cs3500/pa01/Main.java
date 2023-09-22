package cs3500.pa01;

import cs3500.pa01.controller.Controller;
import cs3500.pa01.controller.ControllerImp;
import cs3500.pa01.filemaker.FileMakerMdSr;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This is the main driver of this project.
 */
public class Main {
  /**
   * Project entry point
   *
   * @param args - A relative or absolute path to a folder (directory) of markdown files
   *                  containing the notes you want to summarize
   *             - A flag to indicate how the summary document should be organized
   *             - An output path (relative or absolute) and filename of where to write the
   *                  study guide your program generates
   */
  public static void main(String[] args) throws IOException {
    if (args.length == 3) {
      Path startingDirectory;
      File pasterFile;
      FlagEnum fe;

      try {
        startingDirectory = Path.of(args[0]);
        pasterFile = new File(args[2]);
        fe = FlagEnum.valueOf(args[1].toUpperCase());
      } catch (Exception e) {
        throw new IllegalArgumentException("Illegal args");
      }

      if (!startingDirectory.toFile().exists()) {
        throw new IllegalArgumentException("Illegal args");
      }

      if (pasterFile.exists()) {
        throw new IllegalArgumentException("Illegal args");
      }

      FileWalkerMd pf = new FileWalkerMd();
      FileScanner fsc = new FileScanner();
      FileSorter fs = new FileSorter(fsc);
      FileMakerMdSr fmMd = new FileMakerMdSr();
      ModifiedSort mf = new ModifiedSort();
      CreatedSort cs = new CreatedSort();

      Files.walkFileTree(startingDirectory, pf);
      fs.sortFiles(fe, pf.pathFile);
      fmMd.writeToFile(Path.of(pasterFile.toPath() + ".md"), fsc.bracketedOrHastag.toString());
      fmMd.writeToFile(Path.of(pasterFile.toPath() + ".sr"), fsc.questions.toString());
    } else {
      Readable input = new InputStreamReader(System.in);
      Controller controller = new ControllerImp(input, System.out);
      controller.run();
    }
  }
}