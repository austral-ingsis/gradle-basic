package handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

@SuppressWarnings("PMD")
public class IdentifierTokenHandler implements TokenHandler {
  private static final String LETTERS = "abcdefghijklmnñopqrstuvwxyzABCDEGHIJKLMNÑOPQRSTUVWXYZ";
  private static final String NUMBERS = "0123456789";
  private static final List<String> reservedKeywords =
      new ArrayList<>() {
        {
          add("true");
          add("false");
          add("let");
          add("const");
          add("number");
          add("string");
          add("boolean");
          add("if");
          add("else");
          add("println");
        }
      };

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    char read = statement.peek();
    if (LETTERS.indexOf(read) == -1) {
      return Optional.empty();
    }

    StringBuilder result = new StringBuilder(String.valueOf(read));
    CharacterStream temp = new CharacterStream(statement.peekRemainingChars());

    boolean valid = true;
    while (temp.hasNext() && valid) {
      read = temp.next();
      if (LETTERS.indexOf(read) != -1 || NUMBERS.indexOf(read) != -1) {
        result.append(read);
      } else {
        valid = false;
      }
    }

    String stringResult = result.toString();
    if (reservedKeywords.stream().anyMatch(keyword -> keyword.equals(stringResult)))
      return Optional.empty();
    statement.skipNChars(stringResult.length());
    return Optional.of(new Token(TokenType.IDENTIFIER, stringResult));
  }
}
