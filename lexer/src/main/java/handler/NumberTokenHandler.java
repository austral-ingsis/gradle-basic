package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

@SuppressWarnings("PMD")
public class NumberTokenHandler implements TokenHandler {
  private static final String NUMBERS = "0123456789";
  private static final char DOT_CHAR = '.';

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    char read = statement.peek();
    if (NUMBERS.indexOf(read) == -1) {
      return Optional.empty();
    }

    StringBuilder result = new StringBuilder(String.valueOf(read));
    CharacterStream temp = new CharacterStream(statement.peekRemainingChars());

    boolean valid = true;
    boolean hasDot = false;
    while (temp.hasNext() && valid) {
      read = temp.next();
      if (NUMBERS.indexOf(read) != -1) {
        result.append(read);
      } else if (!hasDot && read == DOT_CHAR) {
        result.append(read);
        hasDot = true;
      } else {
        valid = false;
      }
    }
    String stringResult = result.toString();
    statement.skipNChars(stringResult.length());
    return Optional.of(new Token(TokenType.NUMBER, stringResult));
  }
}
