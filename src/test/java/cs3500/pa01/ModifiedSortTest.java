package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModifiedSortTest {
  File file1;
  File file2;
  File wrongfile3;
  ModifiedSort sortModified;

  @BeforeEach
  void init() {
    file1 = Path.of("testData/cs3500/c.md").toFile();
    file2 = Path.of("testData/cs3500/d.md").toFile();


    file1.setLastModified(200L);
    file2.setLastModified(300L);

    sortModified = new ModifiedSort();
  }

  @Test
  public void testCompareModifiedSort() {
    assertEquals(1, sortModified.compare(file2, file1));
    assertEquals(-1, sortModified.compare(file1, file2));
    assertEquals(0, sortModified.compare(file1, file1));
    assertEquals(0, sortModified.compare(file2, file2));

  }
}