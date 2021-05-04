import cli.CLI;
import java.io.File;

public class Main {
  static CLI cli = new CLI();

  public static void main(String[] args) {
    cli.interpret(
        new File("cli/src/main/java/print-statement/1.0/string-and-number-concat/main.ps"),
        System.out::println);
  }
}
