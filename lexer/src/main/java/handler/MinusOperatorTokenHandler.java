package handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import token.Token;
import token.TokenType;

public class MinusOperatorTokenHandler implements TokenHandler {
  private static final char MINUS_CHAR = '-';

  @Override
  public Optional<Token> handle(InputStream statement) throws IOException {
    statement.mark(1);
    char read = (char) statement.read();
    if (read == MINUS_CHAR)
      return Optional.of(new Token(TokenType.MINUS_OPERATOR, String.valueOf(MINUS_CHAR)));
    statement.reset();
    return Optional.empty();
  }
}
