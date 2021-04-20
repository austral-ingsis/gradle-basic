package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class MinusOperatorTokenHandler implements TokenHandler {
  private static final char MINUS_CHAR = '-';

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    char read = statement.peek();
    if (read == MINUS_CHAR) {
      statement.skipNChars(1);
      return Optional.of(new Token(TokenType.MINUS_OPERATOR, String.valueOf(MINUS_CHAR)));
    }
    return Optional.empty();
  }
}
