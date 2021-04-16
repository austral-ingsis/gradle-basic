package handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import token.Token;
import token.TokenType;

public class NumberTypeTokenHandler implements TokenHandler {
  private static final String NUMBER_TYPE = "number";
  private static final char SPACE_CHAR = ' ';

  @Override
  public Optional<Token> handle(InputStream statement) throws IOException {
    statement.mark(NUMBER_TYPE.length() + 1);
    if (new String(statement.readNBytes(NUMBER_TYPE.length())).equals(NUMBER_TYPE)
        && (char) statement.read() == SPACE_CHAR)
      return Optional.of(new Token(TokenType.NUMBER_TYPE, NUMBER_TYPE));
    statement.reset();
    return Optional.empty();
  }
}
