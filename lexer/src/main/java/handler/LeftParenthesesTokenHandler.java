package handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import token.Token;
import token.TokenType;

public class LeftParenthesesTokenHandler implements TokenHandler {
  private static final char LEFT_PARENTHESES_CHAR = '(';

  @Override
  public Optional<Token> handle(InputStream statement) throws IOException {
    statement.mark(1);
    char read = (char) statement.read();
    if (read == LEFT_PARENTHESES_CHAR)
      return Optional.of(
          new Token(TokenType.LEFT_PARENTHESES, String.valueOf(LEFT_PARENTHESES_CHAR)));
    statement.reset();
    return Optional.empty();
  }
}
