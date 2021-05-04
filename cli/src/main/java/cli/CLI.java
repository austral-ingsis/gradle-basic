package cli;

import interpreter.Interpreter;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Scanner;
import java.util.function.Consumer;

@SuppressWarnings("PMD")
public class CLI {

  public void interpret(File src, Consumer<String> lines) {
    Interpreter interpreter = new Interpreter(lines);
    try {
      Scanner scanner = new Scanner(src);
      StringBuilder builder = new StringBuilder();
      while (scanner.hasNextLine()) {
        builder.append(scanner.nextLine());
      }
      String statement = builder.toString();
      while (!statement.equals("")) {
        if (statement.length() >= 2 && statement.startsWith("if")) {
          int indexRightKey = statement.indexOf('}');
          if (indexRightKey == -1) {
            throw new InvalidAlgorithmParameterException();
          }
          if (statement.substring(indexRightKey + 1).startsWith("else")) {
            int indexElseRightKey = statement.indexOf('}', indexRightKey + 1);
            if (indexElseRightKey == -1) {
              throw new InvalidAlgorithmParameterException();
            }
            interpreter.interpret(statement.substring(0, indexElseRightKey + 1));
            statement = statement.substring(indexElseRightKey + 1);
          } else {
            interpreter.interpret(statement.substring(0, indexRightKey + 1));
            statement = statement.substring(indexRightKey + 1);
          }
        } else {
          int indexEscChar = statement.indexOf(';');
          if (indexEscChar == -1) {
            throw new InvalidAlgorithmParameterException();
          }
          interpreter.interpret(statement.substring(0, indexEscChar + 1));
          statement = statement.substring(indexEscChar + 1);
        }
      }
      scanner.close();
    } catch (FileNotFoundException | InvalidAlgorithmParameterException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
