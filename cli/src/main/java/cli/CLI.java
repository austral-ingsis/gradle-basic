package cli;

import interpreter.Interpreter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.Consumer;

@SuppressWarnings("PMD")
public class CLI {

  public void interpret(File src, Consumer<String> lines) {
    Interpreter interpreter = new Interpreter(lines);
    try {
      Scanner scanner = new Scanner(src);
      while (scanner.hasNextLine()) {
        String statement = scanner.nextLine();
        if (statement.length() >= 2 && statement.startsWith("if")) {
          StringBuilder builder = new StringBuilder(statement);
          while ((statement.indexOf('}') == -1 || statement.contains("else"))
              && scanner.hasNext()) {
            builder.append(scanner.nextLine());
          }
          interpreter.interpret(builder.toString());
        } else {
          interpreter.interpret(statement);
        }
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
