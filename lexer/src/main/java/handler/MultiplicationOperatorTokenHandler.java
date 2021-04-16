package handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import token.Token;
import token.TokenType;

public class MultiplicationOperatorTokenHandler implements TokenHandler {
  private static final char MULTIPLICATION_CHAR = '*';

  @Override
  public Optional<Token> handle(InputStream statement) throws IOException {
    statement.mark(1);
    char read = (char) statement.read();
    if (read == MULTIPLICATION_CHAR)
      return Optional.of(
          new Token(TokenType.MULTIPLICATION_OPERATOR, String.valueOf(MULTIPLICATION_CHAR)));
    statement.reset();
    return Optional.empty();
  }
}
