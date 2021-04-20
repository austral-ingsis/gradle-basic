package handler;

import java.util.Optional;
import stream.CharacterStream;
import token.Token;

public interface TokenHandler {
  Optional<Token> handle(CharacterStream statement);
}
