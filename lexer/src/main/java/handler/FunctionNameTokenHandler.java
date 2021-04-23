package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class FunctionNameTokenHandler implements TokenHandler {
  private static final String FUNCTION_NAME = "printLn";

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    String read = statement.peekNChars(FUNCTION_NAME.length());
    if (read.equals(FUNCTION_NAME)) {
      statement.skipNChars(FUNCTION_NAME.length());
      return Optional.of(new Token(TokenType.FUNCTION_NAME, FUNCTION_NAME));
    }
    return Optional.empty();
  }
}
