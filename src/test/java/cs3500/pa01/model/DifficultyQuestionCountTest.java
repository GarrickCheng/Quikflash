package cs3500.pa01.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test for difficuly question count class
 */
class DifficultyQuestionCountTest {
  Question q1;
  Question q2;
  Question q3;
  Question q4;
  ArrayList<Question> allQuestions;
  DifficultyQuestionCount tester;

  @BeforeEach
  void init() {
    q1 = new Question("Is computer science hard", "yes", "*hard*");
    q2 = new Question("How much money you got", "a lot", "*easy");
    q3 = new Question("How many problems you got", "a lot", "*hard*");
    q4 = new Question("Are you happy?", "yes", "*hard");

    allQuestions = new ArrayList<Question>(Arrays.asList(q1, q2, q3, q4));
    tester = new DifficultyQuestionCount();
  }

  @Test
  public void testCountDifficulty() {
    tester.countDifficulty(allQuestions);
    assertEquals(2, tester.getEasyQuestions());
    assertEquals(2, tester.getHardQuestions());
  }
}