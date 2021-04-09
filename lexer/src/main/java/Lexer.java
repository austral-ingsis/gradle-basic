import exceptions.BadTokenException;
import handler.Handler;
import handler.PrintScriptHandler;
import java.util.List;
import token.Token;

public class Lexer {

  private transient Handler statementHandler;

  public Lexer() {
    statementHandler = new PrintScriptHandler();
  }

  public List<Token> lex(String statement) throws BadTokenException {
    return statementHandler.handle(statement);
  }
}
