package cs3500.pa01.view;

import java.io.IOException;

/**
 * class to represent the commandline view
 */
public class ConsoleLn implements View {
  Appendable output;

  /**
   * Constructor for ConsoleLn
   *
   * @param output an appendable
   * @throws IOException exception
   */
  public ConsoleLn(Appendable output) throws IOException {
    this.output = output;
  }

  /**
   * prints the given string in the console
   *
   * @param s the string to be printed in the console
   */
  public void print(String s) throws IOException {
    output.append(s + "\n");
  }
}
