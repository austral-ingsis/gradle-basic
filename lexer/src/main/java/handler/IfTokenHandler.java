package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class IfTokenHandler implements TokenHandler {
  private static final String IF_KEYWORD = "if";
  private static final char SPACE_CHAR = ' ';
  private static final char PARENTHESES_CHAR = '(';

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    String read = statement.peekNChars(IF_KEYWORD.length() + 1);
    if (read.equals(IF_KEYWORD + SPACE_CHAR) || read.equals(IF_KEYWORD + PARENTHESES_CHAR)) {
      statement.skipNChars(IF_KEYWORD.length());
      return Optional.of(new Token(TokenType.IF_FUNCTION, IF_KEYWORD));
    }
    return Optional.empty();
  }
}
