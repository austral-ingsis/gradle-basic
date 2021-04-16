package handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import token.Token;
import token.TokenType;

public class StringTokenHandler implements TokenHandler {
  private static final char QUOTES = '"';
  private static final String LETTERS = "abcdefghijklmnñopqrstuvwxyzABCDEGHIJKLMNÑOPQRSTUVWXYZ";
  private static final String NUMBERS = "0123456789";
  private static final String SPECIAL_CHARACTERS = " `~!@#$%^&*()_-+=[{]}|;:'<>,./?\"";
  private static final int END_OF_INPUT = (char) -1;

  @Override
  public Optional<Token> handle(InputStream statement) throws IOException {
    statement.mark(2147483647);
    char read = (char) statement.read();
    if (read != QUOTES) {
      statement.reset();
      return Optional.empty();
    }

    StringBuilder result = new StringBuilder();
    char currentRead = (char) statement.read();
    while (currentRead != END_OF_INPUT
        && (LETTERS.indexOf(currentRead) != -1
            || NUMBERS.indexOf(currentRead) != -1
            || SPECIAL_CHARACTERS.indexOf(currentRead) != -1)) {
      result.append(currentRead);
      currentRead = (char) statement.read();
    }
    if (currentRead == QUOTES) {
      return Optional.of(new Token(TokenType.STRING, result.toString()));
    }
    statement.reset();
    return Optional.empty();
  }
}
