package handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import token.Token;
import token.TokenType;

public class VariableKeywordTokenHandler implements TokenHandler {
  private static final String VARIABLE_KEYWORD = "let";
  private static final char SPACE_CHAR = ' ';

  @Override
  public Optional<Token> handle(InputStream statement) throws IOException {
    statement.mark(VARIABLE_KEYWORD.length() + 1);
    if (new String(statement.readNBytes(VARIABLE_KEYWORD.length())).equals(VARIABLE_KEYWORD)
        && (char) statement.read() == SPACE_CHAR)
      return Optional.of(new Token(TokenType.VARIABLE_KEYWORD, VARIABLE_KEYWORD));
    statement.reset();
    return Optional.empty();
  }
}
