package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class ConstantKeywordTokenHandler implements TokenHandler {
  private static final String CONSTANT_KEYWORD = "const";

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    String read = statement.peekNChars(CONSTANT_KEYWORD.length());
    if (read.equals(CONSTANT_KEYWORD)) {
      statement.skipNChars(CONSTANT_KEYWORD.length());
      return Optional.of(new Token(TokenType.CONSTANT_KEYWORD, CONSTANT_KEYWORD));
    }
    return Optional.empty();
  }
}
