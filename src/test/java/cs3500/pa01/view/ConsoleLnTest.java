package cs3500.pa01.view;

import static cs3500.pa01.Main.main;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * class for controller console line test
 */
class ConsoleLnTest {
  String phrase1;
  String phrase2;
  ConsoleLn view;
  Appendable mock;
  Appendable errors;

  @BeforeEach
  void init() throws IOException {
    phrase1 = "\n";
    phrase2 = "Welcome User!" + "\n" + "Feed me a file path!" + "\n";
    mock = new StringBuilder();
    view = new ConsoleLn(mock);
    errors = new MockAppendable();
  }

  @Test
  public void testPrintMethod() throws IOException {
    view.print("");
    assertEquals(mock.toString(), phrase1);
    view.print("Welcome User!" + "\n" + "Feed me a file path!");
    assertEquals(mock.toString(), phrase1 + phrase2);
  }

  @Test
  public void testMockAppendable() {
    assertThrows(IOException.class,
        () -> errors.append("hello"));
  }
}