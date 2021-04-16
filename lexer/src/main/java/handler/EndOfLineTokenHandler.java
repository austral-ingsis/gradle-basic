package handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import token.Token;
import token.TokenType;

public class EndOfLineTokenHandler implements TokenHandler {
  private static final int END_OF_INPUT = -1;

  @Override
  public Optional<Token> handle(InputStream statement) throws IOException {
    statement.mark(1);
    if (statement.read() == END_OF_INPUT) return Optional.of(new Token(TokenType.END_OF_INPUT, ""));
    statement.reset();
    return Optional.empty();
  }
}
