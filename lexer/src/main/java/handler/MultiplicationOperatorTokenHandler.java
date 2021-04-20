package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class MultiplicationOperatorTokenHandler implements TokenHandler {
  private static final char MULTIPLICATION_CHAR = '*';

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    char read = statement.peek();
    if (read == MULTIPLICATION_CHAR) {
      statement.skipNChars(1);
      return Optional.of(
          new Token(TokenType.MULTIPLICATION_OPERATOR, String.valueOf(MULTIPLICATION_CHAR)));
    }
    return Optional.empty();
  }
}
