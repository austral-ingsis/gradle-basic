package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class RightKeyTokenHandler implements TokenHandler {
  private static final char RIGHT_KEY_CHAR = '}';

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    char read = statement.peek();
    if (read == RIGHT_KEY_CHAR) {
      statement.skipNChars(1);
      return Optional.of(new Token(TokenType.RIGHT_KEY, String.valueOf(RIGHT_KEY_CHAR)));
    }
    return Optional.empty();
  }
}
