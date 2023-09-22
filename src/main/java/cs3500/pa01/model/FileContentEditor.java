package cs3500.pa01.model;

import cs3500.pa01.filemaker.FileEditorSr;
import java.io.File;
import java.util.ArrayList;

/**
 * class to edit the contents of the question file
 */
public class FileContentEditor {
  private StringBuilder questions = new StringBuilder();

  /**
   * edits the content of the file
   *
   * @param changedDifficulties all the questions with the changed difficulties
   * @param questionFile the question file
   */
  public void fileEditor(ArrayList<Question> changedDifficulties, File questionFile) {
    questionFile.delete();
    for (Question diffQuestion : changedDifficulties) {
      questions.append("- ");
      questions.append(diffQuestion.getQuestion());
      questions.append(":::");
      questions.append(diffQuestion.getAnswer());
      questions.append(" ");
      questions.append(diffQuestion.difficulty);
      questions.append("\n");
    }
    FileEditorSr fm = new FileEditorSr();
    fm.writeToFile(questionFile.toPath(), questions.toString());
  }
}
