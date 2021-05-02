package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class NumberTypeTokenHandler implements TokenHandler {
  private static final String NUMBER_TYPE = "number";

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    String read = statement.peekNChars(NUMBER_TYPE.length());
    if (read.equals(NUMBER_TYPE)) {
      statement.skipNChars(NUMBER_TYPE.length());
      return Optional.of(new Token(TokenType.NUMBER_TYPE, NUMBER_TYPE));
    }
    return Optional.empty();
  }
}
