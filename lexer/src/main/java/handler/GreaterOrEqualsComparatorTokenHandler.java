package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class GreaterOrEqualsComparatorTokenHandler implements TokenHandler {
  private static final String GREATER_OR_EQUALS_COMPARATOR = ">=";

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    String read = statement.peekNChars(GREATER_OR_EQUALS_COMPARATOR.length());
    if (read.equals(GREATER_OR_EQUALS_COMPARATOR)) {
      statement.skipNChars(GREATER_OR_EQUALS_COMPARATOR.length());
      return Optional.of(
          new Token(TokenType.GREATER_OR_EQUALS_COMPARATOR, GREATER_OR_EQUALS_COMPARATOR));
    }
    return Optional.empty();
  }
}
