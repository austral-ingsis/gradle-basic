package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class EqualsComparatorTokenHandler implements TokenHandler {
  private static final String EQUALS_COMPARATOR = "==";

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    String read = statement.peekNChars(EQUALS_COMPARATOR.length());
    if (read.equals(EQUALS_COMPARATOR)) {
      statement.skipNChars(EQUALS_COMPARATOR.length());
      return Optional.of(new Token(TokenType.EQUALS_COMPARATOR, EQUALS_COMPARATOR));
    }
    return Optional.empty();
  }
}
