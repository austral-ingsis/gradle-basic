package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class PlusOperatorTokenHandler implements TokenHandler {
  private static final char PLUS_CHAR = '+';

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    char read = statement.peek();
    if (read == PLUS_CHAR) {
      statement.skipNChars(1);
      return Optional.of(new Token(TokenType.PLUS_OPERATOR, String.valueOf(PLUS_CHAR)));
    }
    return Optional.empty();
  }
}
