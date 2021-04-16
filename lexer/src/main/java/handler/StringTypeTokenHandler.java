package handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import token.Token;
import token.TokenType;

public class StringTypeTokenHandler implements TokenHandler {
  private static final String STRING_TYPE = "string";
  private static final char SPACE_CHAR = ' ';

  @Override
  public Optional<Token> handle(InputStream statement) throws IOException {
    statement.mark(STRING_TYPE.length() + 1);
    if (new String(statement.readNBytes(STRING_TYPE.length())).equals(STRING_TYPE)
        && (char) statement.read() == SPACE_CHAR)
      return Optional.of(new Token(TokenType.STRING_TYPE, STRING_TYPE));
    statement.reset();
    return Optional.empty();
  }
}
