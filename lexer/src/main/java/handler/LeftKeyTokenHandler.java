package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class LeftKeyTokenHandler implements TokenHandler {
  private static final char LEFT_KEY_CHAR = '{';

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    char read = statement.peek();
    if (read == LEFT_KEY_CHAR) {
      statement.skipNChars(1);
      return Optional.of(new Token(TokenType.LEFT_KEY, String.valueOf(LEFT_KEY_CHAR)));
    }
    return Optional.empty();
  }
}
