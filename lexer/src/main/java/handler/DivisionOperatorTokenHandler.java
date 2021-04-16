package handler;

import java.io.IOException;
import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class DivisionOperatorTokenHandler implements TokenHandler {
  private static final char DIVISION_CHAR = '/';

  @Override
  public Optional<Token> handle(CharacterStream statement) throws IOException {
    char read = statement.peek();
    if (read == DIVISION_CHAR) {
      statement.skipNChars(1);
      return Optional.of(new Token(TokenType.DIVISION_OPERATOR, String.valueOf(DIVISION_CHAR)));
    }
    return Optional.empty();
  }
}
