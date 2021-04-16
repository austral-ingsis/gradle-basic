package handler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import token.Token;
import token.TokenType;

public class NumberTokenHandler implements TokenHandler {
  private static final String NUMBERS = "0123456789";
  private static final String OPERATIONS = "+-/*";
  private static final char SPACE_CHAR = ' ';
  private static final char ESC_CHAR = ';';
  private static final int END_OF_INPUT = (char) -1;

  @Override
  public Optional<Token> handle(InputStream statement) throws IOException {
    statement.mark(2147483647);
    char read = (char) statement.read();
    if (NUMBERS.indexOf(read) == -1) {
      statement.reset();
      return Optional.empty();
    }

    StringBuilder result = new StringBuilder(String.valueOf(read));

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    statement.transferTo(outputStream);
    InputStream temp = new ByteArrayInputStream(outputStream.toByteArray());

    char currentRead = (char) temp.read();
    while (currentRead != END_OF_INPUT && NUMBERS.indexOf(currentRead) != -1) {
      result.append(currentRead);
      currentRead = (char) temp.read();
      statement.skip(1);
    }

    if (currentRead == SPACE_CHAR
        || currentRead == ESC_CHAR
        || OPERATIONS.indexOf(currentRead) != -1) {
      return Optional.of(new Token(TokenType.NUMBER, result.toString()));
    }
    statement.reset();
    return Optional.empty();
  }
}
