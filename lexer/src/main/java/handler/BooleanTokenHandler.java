package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class BooleanTokenHandler implements TokenHandler {
  private static final String TRUE = "true";
  private static final String FALSE = "false";

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    Optional<Token> result = checkBoolean(statement, TRUE);
    if (result.isPresent()) return result;
    return checkBoolean(statement, FALSE);
  }

  private Optional<Token> checkBoolean(CharacterStream statement, String token) {
    String read = statement.peekNChars(token.length());
    if (read.equals(token)) {
      statement.skipNChars(token.length());
      return Optional.of(new Token(TokenType.BOOLEAN, token));
    }
    return Optional.empty();
  }
}
