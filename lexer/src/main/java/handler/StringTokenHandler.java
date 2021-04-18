package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class StringTokenHandler implements TokenHandler {
  private static final char QUOTES = '"';
  private static final String LETTERS = "abcdefghijklmnñopqrstuvwxyzABCDEGHIJKLMNÑOPQRSTUVWXYZ";
  private static final String NUMBERS = "0123456789";
  private static final String SPECIAL_CHARACTERS = " `~!@#$%^&*()_-+=[{]}|;:'<>,./?";

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    char read = statement.peek();
    if (read != QUOTES) {
      return Optional.empty();
    }
    if (!statement.hasNext()) {
      return Optional.empty();
    }

    CharacterStream temp = new CharacterStream(statement.peekRemainingChars());
    StringBuilder result = new StringBuilder();

    boolean valid = true;
    while (temp.hasNext() && valid) {
      read = temp.next();
      if (LETTERS.indexOf(read) != -1
          || NUMBERS.indexOf(read) != -1
          || SPECIAL_CHARACTERS.indexOf(read) != -1) {
        result.append(read);
      } else {
        valid = false;
      }
    }

    if (read == QUOTES) {
      String stringResult = result.toString();
      statement.skipNChars(stringResult.length() + 2);
      return Optional.of(new Token(TokenType.STRING, stringResult));
    }
    return Optional.empty();
  }
}
