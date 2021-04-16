package handler;

import java.io.IOException;
import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class FunctionNameTokenHandler implements TokenHandler {
  private static final String FUNCTION_NAME = "printLn";
  private static final char SPACE_CHAR = ' ';

  @Override
  public Optional<Token> handle(CharacterStream statement) throws IOException {
    String read = statement.peekNChars(FUNCTION_NAME.length());
    if (read.equals(FUNCTION_NAME) && statement.peek() == SPACE_CHAR) {
      statement.skipNChars(FUNCTION_NAME.length() + 1);
      return Optional.of(new Token(TokenType.FUNCTION_NAME, FUNCTION_NAME));
    }
    return Optional.empty();
  }
}
