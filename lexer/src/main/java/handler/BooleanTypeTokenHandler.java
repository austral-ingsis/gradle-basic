package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class BooleanTypeTokenHandler implements TokenHandler {
  private static final String BOOLEAN_TYPE = "boolean";

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    String read = statement.peekNChars(BOOLEAN_TYPE.length());
    if (read.equals(BOOLEAN_TYPE)) {
      statement.skipNChars(BOOLEAN_TYPE.length());
      return Optional.of(new Token(TokenType.BOOLEAN_TYPE, BOOLEAN_TYPE));
    }
    return Optional.empty();
  }
}
