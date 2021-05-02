package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class MinorOrEqualsComparatorTokenHandler implements TokenHandler {
  private static final String MINOR_OR_EQUALS_COMPARATOR = "<=";

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    String read = statement.peekNChars(MINOR_OR_EQUALS_COMPARATOR.length());
    if (read.equals(MINOR_OR_EQUALS_COMPARATOR)) {
      statement.skipNChars(MINOR_OR_EQUALS_COMPARATOR.length());
      return Optional.of(
          new Token(TokenType.MINOR_OR_EQUALS_COMPARATOR, MINOR_OR_EQUALS_COMPARATOR));
    }
    return Optional.empty();
  }
}
