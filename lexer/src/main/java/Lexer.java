import exceptions.BadTokenException;
import java.util.List;
import token.Token;

public interface Lexer {
  public List<Token> lex(String statement) throws BadTokenException;
}
