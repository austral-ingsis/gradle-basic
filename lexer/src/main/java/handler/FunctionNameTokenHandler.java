package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class FunctionNameTokenHandler implements TokenHandler {
  private static final String FUNCTION_NAME = "printLn";
  private static final char SPACE_CHAR = ' ';

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    String read = statement.peekNChars(FUNCTION_NAME.length() + 1);
    if (read.equals(FUNCTION_NAME + SPACE_CHAR)) {
      statement.skipNChars(FUNCTION_NAME.length() + 1);
      return Optional.of(new Token(TokenType.FUNCTION_NAME, FUNCTION_NAME));
    }
    return Optional.empty();
  }
}
