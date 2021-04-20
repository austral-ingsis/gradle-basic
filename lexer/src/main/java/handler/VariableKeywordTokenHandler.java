package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class VariableKeywordTokenHandler implements TokenHandler {
  private static final String VARIABLE_KEYWORD = "let";
  private static final char SPACE_CHAR = ' ';

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    String read = statement.peekNChars(VARIABLE_KEYWORD.length() + 1);
    if (read.equals(VARIABLE_KEYWORD + SPACE_CHAR)) {
      statement.skipNChars(VARIABLE_KEYWORD.length() + 1);
      return Optional.of(new Token(TokenType.VARIABLE_KEYWORD, VARIABLE_KEYWORD));
    }
    return Optional.empty();
  }
}
