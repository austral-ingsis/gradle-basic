package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class MinorComparatorTokenHandler implements TokenHandler {
  private static final String MINOR_COMPARATOR = "<";

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    String read = statement.peekNChars(MINOR_COMPARATOR.length());
    if (read.equals(MINOR_COMPARATOR)) {
      statement.skipNChars(MINOR_COMPARATOR.length());
      return Optional.of(new Token(TokenType.MINOR_COMPARATOR, MINOR_COMPARATOR));
    }
    return Optional.empty();
  }
}
