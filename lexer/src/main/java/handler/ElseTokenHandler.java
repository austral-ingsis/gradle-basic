package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class ElseTokenHandler implements TokenHandler {
  private static final String ELSE_KEYWORD = "else";
  private static final char SPACE_CHAR = ' ';
  private static final char KEYS_CHAR = '{';

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    String read = statement.peekNChars(ELSE_KEYWORD.length() + 1);
    if (read.equals(ELSE_KEYWORD + SPACE_CHAR) || read.equals(ELSE_KEYWORD + KEYS_CHAR)) {
      statement.skipNChars(ELSE_KEYWORD.length());
      return Optional.of(new Token(TokenType.ELSE_FUNCTION, ELSE_KEYWORD));
    }
    return Optional.empty();
  }
}
