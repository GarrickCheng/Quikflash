package cs3500.pa01.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test for question class
 */
class QuestionTest {
  Question q1;
  Question q2;

  @BeforeEach
  void init() {
    q1 = new Question("Is computer science hard", "yes", "*hard*");
    q2 = new Question("How much money you got", "a lot", "*easy*");
  }

  @Test
  public void testToString() {
    assertEquals("Is computer science hardyes*hard*", q1.toString());
    assertEquals("How much money you gota lot*easy*", q2.toString());
    assertEquals("Is computer science hard", q1.getQuestion());
    assertEquals("a lot", q2.getAnswer());
    assertEquals("*easy*", q2.difficulty);
  }
}