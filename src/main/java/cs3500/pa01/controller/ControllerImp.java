package cs3500.pa01.controller;

import cs3500.pa01.model.DifficultyQuestionCount;
import cs3500.pa01.model.FileContentEditor;
import cs3500.pa01.model.FileScannerSr;
import cs3500.pa01.model.Model;
import cs3500.pa01.model.Question;
import cs3500.pa01.model.QuestionBank;
import cs3500.pa01.view.ConsoleLn;
import cs3500.pa01.view.View;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;

/**
 * class for the controller implementation. drives entire study session
 */
public class ControllerImp implements Controller {
  private Readable input;
  private View view;
  private FileScannerSr scanInput;
  private QuestionBank qb;
  private FileContentEditor fe;
  private DifficultyQuestionCount qc;
  private Model model;

  /**
   * constructor for testing
   *
   * @param input something that is readable
   * @param output something that is appendable for testing
   */
  public ControllerImp(Readable input, Appendable output) throws IOException {
    this.input = Objects.requireNonNull(input);
    this.view = new ConsoleLn(output);
  }

  /**
   * runs the content in the controller points to the model and the view
   */
  @Override
  public void run() throws IOException {
    //testData/fileE/e.sr -> file for console
    scanInput = new FileScannerSr();
    qb = new QuestionBank();
    fe = new FileContentEditor();
    qc = new DifficultyQuestionCount();

    int questionsCompleted = 0;
    int easyToHard = 0;
    int hardToEasy = 0;


    // asks user for file
    view.print("\n" + "Welcome User!" + "\n" + "Feed me a file path!");
    Scanner s = new Scanner(input);
    String inputFile = null;
    if (s.hasNext()) {
      inputFile = s.next();
    }
    while (!Path.of(inputFile).toFile().exists()) {
      view.print("This file does not exist try again :)");
      inputFile = s.next();
    }
    scanInput.scanFile(inputFile);
    qb.makeQuestionList(scanInput.qanda);

    // asks user for how many questions
    view.print("\n" + "How many questions would you like to review?");
    String questionAmount = s.next();
    while (!(Integer.parseInt(questionAmount) >= 1)
        || Integer.parseInt(questionAmount) > qb.getAllQuestions().size()) {
      view.print("Please enter a valid amount of questions :)");
      questionAmount = s.next();
    }
    qb.selectRandomQuestions(Integer.parseInt(questionAmount));

    // asks user questions
    for (Question diffQuestion : qb.getSelectedRandomQuestions()) {
      questionsCompleted += 1;
      view.print("\n" + diffQuestion.getQuestion() + "\n" + "1.easy 2.hard 3.answer");
      String userAnswer = s.next();
      while (!userAnswer.equalsIgnoreCase("easy")
          && !userAnswer.equalsIgnoreCase("hard")
          && !userAnswer.equalsIgnoreCase("answer")) {
        view.print("Please choose from given options!");
        userAnswer = s.next();
      }
      if (userAnswer.equalsIgnoreCase("easy") && diffQuestion.difficulty.equals("*hard*")) {
        diffQuestion.difficulty = "*easy*";
        hardToEasy += 1;
      } else if (userAnswer.equalsIgnoreCase("easy")) {
        diffQuestion.difficulty = "*easy*";
      }
      if (userAnswer.equalsIgnoreCase("hard") && diffQuestion.difficulty.equals("*easy*")) {
        diffQuestion.difficulty = "*hard*";
        easyToHard += 1;
      } else if (userAnswer.equalsIgnoreCase("hard")) {
        diffQuestion.difficulty = "*hard*";
      }
      if (userAnswer.equalsIgnoreCase("answer")) {
        view.print(diffQuestion.getAnswer());
      }
    }

    fe.fileEditor(qb.getAllQuestions(), Path.of(inputFile).toFile());

    qc.countDifficulty(qb.getAllQuestions());

    view.print("\n");
    view.print("you answered " + questionsCompleted + " questions.");
    view.print(easyToHard + " questions went from easy to hard.");
    view.print(hardToEasy + " questions went from hard to easy");
    view.print("Current counts in Question Bank:");
    view.print(qc.getHardQuestions() + " Hard Questions");
    view.print(qc.getEasyQuestions() + " Easy Questions");
  }
}
