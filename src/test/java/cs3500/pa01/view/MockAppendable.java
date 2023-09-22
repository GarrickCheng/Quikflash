package cs3500.pa01.view;

import java.io.IOException;

/**
 * mock appendable class for testing
 */
public class MockAppendable implements Appendable {

  /**
   * constructor is empty for tests
   */
  public MockAppendable() {

  }

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("File is broken");
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("File is broken");
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("File is broken");
  }
}
