package handler;

import java.io.IOException;
import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class IdentifierTokenHandler implements TokenHandler {
  private static final String LETTERS = "abcdefghijklmnñopqrstuvwxyzABCDEGHIJKLMNÑOPQRSTUVWXYZ";
  private static final String NUMBERS = "0123456789";
  private static final char END_OF_INPUT = (char) -1;

  @Override
  public Optional<Token> handle(CharacterStream statement) throws IOException {
    CharacterStream temp = new CharacterStream(statement.peekRemainingChars());
    char read = temp.next();
    StringBuilder result = new StringBuilder(String.valueOf(read));
    if (LETTERS.indexOf(read) == -1) {
      return Optional.empty();
    }

    read = temp.next();
    while (read != END_OF_INPUT && (LETTERS.indexOf(read) != -1 || NUMBERS.indexOf(read) != -1)) {
      result.append(read);
      read = temp.next();
    }
    return Optional.of(new Token(TokenType.IDENTIFIER, result.toString()));
  }
}
