package cs3500.pa01.controller;


import static cs3500.pa01.Main.main;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerImpTest {
  Readable testProgramInput;
  StringBuilder programOutput;
  ControllerImp controller;
  String expectedOutput;

  @BeforeEach
  void init() throws IOException {
    testProgramInput = new StringReader("testData/fileE/f.sr"
    + "\n"
    + "1"
    + "\n"
    + "easy");
    expectedOutput = "\n" + "Welcome User!" + "\n" + "Feed me a file path!\n"
        + "\n"
        + "How many questions would you like to review?"
        + "\n" + "\n"
        + "is computer science hard\n"
        + "1.easy 2.hard 3.answer"
        + "\n"
        + "\n"
        + "\n"
        + "you answered 1 questions.\n"
        + "0 questions went from easy to hard.\n"
        + "0 questions went from hard to easy\n"
        + "Current counts in Question Bank:\n"
        + "0 Hard Questions\n"
        + "1 Easy Questions\n";
    programOutput = new StringBuilder();
    controller = new ControllerImp(testProgramInput, programOutput);
  }

  @Test
  public void testRun() throws IOException {
    controller.run();
    assertEquals(expectedOutput, programOutput.toString());
  }
}