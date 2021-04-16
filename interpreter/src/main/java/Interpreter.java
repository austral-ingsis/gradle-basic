import exceptions.BadTokenException;

public class Interpreter {
  private final transient Lexer lexer;
  private final transient Parser parser;

  public Interpreter() {
    this.lexer = new PrintScriptLexer();
    this.parser = new Parser();
  }

  public void interpret(String statement, ExecutionMode executionMode) throws BadTokenException {
    executionMode.execute(parser.parse(lexer.lex(statement)));
  }
}
