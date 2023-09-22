package cs3500.pa01.model;

import java.util.ArrayList;

/**
 * class that counts the difficulty
 */
public class DifficultyQuestionCount {
  private int hardQuestions;
  private int easyQuestions;

  /**
   * counts the amount of easy questions and hard questions
   *
   * @param allQuestions all the questions in the file
   */
  public void countDifficulty(ArrayList<Question> allQuestions) {
    for (Question diffQuestion : allQuestions) {
      if (diffQuestion.difficulty.equals("*hard*")) {
        hardQuestions += 1;
      } else {
        easyQuestions += 1;
      }
    }
  }

  /**
   * gets the hard questions
   *
   * @return all hard questions
   */
  public int getHardQuestions() {
    return hardQuestions;
  }

  /**
   * gets the easy questions
   *
   * @return all the easy questions
   */
  public int getEasyQuestions() {
    return easyQuestions;
  }
}
