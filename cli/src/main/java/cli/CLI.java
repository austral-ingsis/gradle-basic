package cli;

import interpreter.Interpreter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import utils.Printer;

@SuppressWarnings("PMD")
public class CLI {

  public void interpret(File src, Printer printer) {
    Interpreter interpreter = new Interpreter(printer);
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
