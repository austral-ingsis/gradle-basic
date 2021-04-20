package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class LeftParenthesesTokenHandler implements TokenHandler {
  private static final char LEFT_PARENTHESES_CHAR = '(';

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    char read = statement.peek();
    if (read == LEFT_PARENTHESES_CHAR) {
      statement.skipNChars(1);
      return Optional.of(
          new Token(TokenType.LEFT_PARENTHESES, String.valueOf(LEFT_PARENTHESES_CHAR)));
    }
    return Optional.empty();
  }
}
