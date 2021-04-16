package handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import token.Token;
import token.TokenType;

public class PlusOperatorTokenHandler implements TokenHandler {
  private static final char PLUS_CHAR = '+';

  @Override
  public Optional<Token> handle(InputStream statement) throws IOException {
    statement.mark(1);
    char read = (char) statement.read();
    if (read == PLUS_CHAR)
      return Optional.of(new Token(TokenType.PLUS_OPERATOR, String.valueOf(PLUS_CHAR)));
    statement.reset();
    return Optional.empty();
  }
}
