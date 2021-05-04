package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class VariableKeywordTokenHandler implements TokenHandler {
  private static final String VARIABLE_KEYWORD = "let";

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    String read = statement.peekNChars(VARIABLE_KEYWORD.length());
    if (read.equals(VARIABLE_KEYWORD)) {
      statement.skipNChars(VARIABLE_KEYWORD.length());
      return Optional.of(new Token(TokenType.VARIABLE_KEYWORD, VARIABLE_KEYWORD));
    }
    return Optional.empty();
  }
}
