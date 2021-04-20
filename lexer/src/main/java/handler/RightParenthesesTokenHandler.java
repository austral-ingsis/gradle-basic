package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class RightParenthesesTokenHandler implements TokenHandler {
  private static final char RIGHT_PARENTHESES_CHAR = ')';

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    char read = statement.peek();
    if (read == RIGHT_PARENTHESES_CHAR) {
      statement.skipNChars(1);
      return Optional.of(
          new Token(TokenType.RIGHT_PARENTHESES, String.valueOf(RIGHT_PARENTHESES_CHAR)));
    }
    return Optional.empty();
  }
}
