package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class EqualsTokenHandler implements TokenHandler {
  private static final char EQUALS_CHAR = '=';

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    char read = statement.peek();
    if (read == EQUALS_CHAR) {
      statement.skipNChars(1);
      return Optional.of(new Token(TokenType.EQUALS, String.valueOf(EQUALS_CHAR)));
    }
    return Optional.empty();
  }
}
