package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class GreaterComparatorTokenHandler implements TokenHandler {
  private static final String GREATER_COMPARATOR = ">";

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    String read = statement.peekNChars(GREATER_COMPARATOR.length());
    if (read.equals(GREATER_COMPARATOR)) {
      statement.skipNChars(GREATER_COMPARATOR.length());
      return Optional.of(new Token(TokenType.GREATER_COMPARATOR, GREATER_COMPARATOR));
    }
    return Optional.empty();
  }
}
