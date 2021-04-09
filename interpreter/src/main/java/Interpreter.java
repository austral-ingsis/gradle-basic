import exceptions.BadTokenException;

public class Interpreter {
  private Lexer lexer;
  private Parser parser;

  public Interpreter() {
    this.lexer = new Lexer();
    this.parser = new Parser();
  }

  public void interpret(String statement, ExecutionMode executionMode) throws BadTokenException {
    executionMode.execute(parser.parse(lexer.lex(statement)));
  }
}
