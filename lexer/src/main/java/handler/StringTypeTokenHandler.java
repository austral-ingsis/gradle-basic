package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class StringTypeTokenHandler implements TokenHandler {
  private static final String STRING_TYPE = "string";
  private static final char SPACE_CHAR = ' ';

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    String read = statement.peekNChars(STRING_TYPE.length() + 1);
    if (read.equals(STRING_TYPE + SPACE_CHAR)) {
      statement.skipNChars(STRING_TYPE.length() + 1);
      return Optional.of(new Token(TokenType.STRING_TYPE, STRING_TYPE));
    }
    return Optional.empty();
  }
}
