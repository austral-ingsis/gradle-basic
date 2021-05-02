package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class StringTypeTokenHandler implements TokenHandler {
  private static final String STRING_TYPE = "string";
  private static final String LETTERS = "abcdefghijklmnñopqrstuvwxyzABCDEGHIJKLMNÑOPQRSTUVWXYZ";

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    String read = statement.peekNChars(STRING_TYPE.length());
    if (read.equals(STRING_TYPE)) {
      statement.skipNChars(STRING_TYPE.length());
      return Optional.of(new Token(TokenType.STRING_TYPE, STRING_TYPE));
    }
    return Optional.empty();
  }
}
