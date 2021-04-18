package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;
import token.TokenType;

public class NumberTypeTokenHandler implements TokenHandler {
  private static final String NUMBER_TYPE = "number";
  private static final char SPACE_CHAR = ' ';

  @Override
  public Optional<Token> handle(CharacterStream statement) {
    String read = statement.peekNChars(NUMBER_TYPE.length() + 1);
    if (read.equals(NUMBER_TYPE + SPACE_CHAR)) {
      statement.skipNChars(NUMBER_TYPE.length() + 1);
      return Optional.of(new Token(TokenType.NUMBER_TYPE, NUMBER_TYPE));
    }
    return Optional.empty();
  }
}
