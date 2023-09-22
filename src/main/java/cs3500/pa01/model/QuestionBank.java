package cs3500.pa01.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * class to represent a group of questions
 */
public class QuestionBank implements Model {
  private ArrayList<Question> allQuestions = new ArrayList<Question>();
  private ArrayList<Question> unsortedQuestions = new ArrayList<Question>();
  private ArrayList<Question> selectedRandomQuestions = new ArrayList<Question>();
  private ArrayList<Integer> randomsAlreadyUsed = new ArrayList<Integer>();
  private Random rand = new Random();

  /**
   * makes list of questions given a string of questions
   *
   * @param qanda a list of questions from a file
   */
  public void makeQuestionList(ArrayList<String> qanda) {
    for (String question : qanda) {
      Question temp =
          new Question(question.substring(question.indexOf("-") + 2, question.indexOf(":::")),
              question.substring(question.indexOf(":::") + 3, question.indexOf("*") - 1),
              question.substring(question.indexOf("*"), question.lastIndexOf("*") + 1));
      unsortedQuestions.add(temp);
    }
    this.sortQuestionList();
  }

  /**
   * sorts the question list based off of difficulty
   */
  private void sortQuestionList() {
    ArrayList<Question> easyQuestions = new ArrayList<Question>();
    for (Question diffQuestion : unsortedQuestions) {
      if (diffQuestion.difficulty.equalsIgnoreCase("*hard*")) {
        allQuestions.add(diffQuestion);
      } else {
        easyQuestions.add(diffQuestion);
      }
    }
    allQuestions.addAll(easyQuestions);
  }

  /**
   * selects random questions from a list
   *
   * @param questionAmount the amount of questions you want to study
   */
  public void selectRandomQuestions(int questionAmount) {
    ArrayList<Question> easyQuestions = new ArrayList<Question>();
    for (int i = 0; i < questionAmount; i++) {
      int temp = rand.nextInt(questionAmount);
      while (randomsAlreadyUsed.contains(temp)) {
        temp = rand.nextInt(questionAmount);
      }
      randomsAlreadyUsed.add(temp);
      if (allQuestions.get(temp).difficulty.equalsIgnoreCase("*easy*")) {
        easyQuestions.add(allQuestions.get(temp));
      } else {
        selectedRandomQuestions.add(allQuestions.get(temp));
      }
    }
    selectedRandomQuestions.addAll(easyQuestions);
  }

  /**
   * gets the arrayList of Questions
   *
   * @return the arrayList of Questions
   */
  public ArrayList<Question> getAllQuestions() {
    return allQuestions;
  }

  /**
   * gets the arrayList of selected Random Questions
   *
   * @return an arrayList of Questions
   */
  public ArrayList<Question> getSelectedRandomQuestions() {
    return selectedRandomQuestions;
  }
}
