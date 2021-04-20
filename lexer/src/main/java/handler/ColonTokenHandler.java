package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class ColonTokenHandler implements TokenHandler {
  private static final char COLON_CHAR = ':';

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    char read = statement.peek();
    if (read == COLON_CHAR) {
      statement.skipNChars(1);
      return Optional.of(new Token(TokenType.COLON, String.valueOf(COLON_CHAR)));
    }
    return Optional.empty();
  }
}
