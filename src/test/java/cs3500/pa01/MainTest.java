package cs3500.pa01;

import static cs3500.pa01.Main.main;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * class for Main test
 */
class MainTest {
  String validArg1;
  String validArg2;
  String validArg3;

  String invalidArg1;
  String invalidArg2;
  String invalidArg3;
  String[] validArgs;
  String[] invalidArgs;
  String[] emptyArgs;

  @BeforeEach
  void init() {
    validArg1 = "testData/cs3500";
    validArg2 = "filename";
    validArg3 = "testData/fileE/e";

    invalidArg1 = "testData/cs3510";
    invalidArg2 = "3";
    invalidArg3 = "testData/cs3510/e";

    validArgs = new String[] {validArg1, validArg2, validArg3};
    invalidArgs = new String[] {invalidArg1, invalidArg2, invalidArg3};
    emptyArgs = new String[] {};
  }

  @Test
  public void invalidArgs() {
    assertThrows(RuntimeException.class, () -> main(invalidArgs));
  }

  @Test
  public void invalidArgsPath() {
    assertThrows(IllegalArgumentException.class,
        () -> main(new String[] {invalidArg1, validArg2, validArg3}));
  }

  @Test
  public void invalidArgsFlag() {
    assertThrows(IllegalArgumentException.class,
        () -> main(new String[] {validArg1, invalidArg2, validArg3}));
  }

  @Test
  public void invalidArgsNotEnough() {
    assertThrows(NullPointerException.class,
        () -> main(new String[] {validArg1, validArg3}));
  }


  @Test
  public void validArgsTest() {
    try {
      main(validArgs);
    } catch (Exception e) {
      fail();
    }
  }
}