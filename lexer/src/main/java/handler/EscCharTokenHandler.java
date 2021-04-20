package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class EscCharTokenHandler implements TokenHandler {
  private static final char ESC_CHAR = ';';

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    char read = statement.peek();
    if (read == ESC_CHAR) {
      statement.skipNChars(1);
      return Optional.of(new Token(TokenType.ESC_CHAR, String.valueOf(ESC_CHAR)));
    }
    return Optional.empty();
  }
}
