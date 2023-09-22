package cs3500.pa01.model;

/**
 * represents a question
 */
public class Question implements Model {
  private String question;
  private String answer;
  public String difficulty;

  /**
   * constructor for question
   *
   * @param question the question portion of the string
   * @param answer the answer portion of the string
   * @param difficulty the difficulty portion of the string
   */
  Question(String question, String answer, String difficulty) {
    this.question = question;
    this.answer = answer;
    this.difficulty = difficulty;
  }

  /**
   * converts a question to a string
   *
   * @return a string with the question answer and difficulty
   */
  public String toString() {
    return question + answer + difficulty;
  }

  /**
   * returns the question of a string
   *
   * @return the question portion
   */
  public String getQuestion() {
    return question;
  }

  /**
   * returns the answer of a string
   *
   * @return the answer portion
   */
  public String getAnswer() {
    return answer;
  }
}
