package handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import token.Token;
import token.TokenType;

public class RightParenthesesTokenHandler implements TokenHandler {
  private static final char RIGHT_PARENTHESES_CHAR = ')';

  @Override
  public Optional<Token> handle(InputStream statement) throws IOException {
    statement.mark(1);
    char read = (char) statement.read();
    if (read == RIGHT_PARENTHESES_CHAR)
      return Optional.of(
          new Token(TokenType.RIGHT_PARENTHESES, String.valueOf(RIGHT_PARENTHESES_CHAR)));
    statement.reset();
    return Optional.empty();
  }
}
