package handler;

import java.io.IOException;
import java.util.Optional;
import stream.CharacterStream;
import token.Token;

public interface TokenHandler {
  Optional<Token> handle(CharacterStream statement) throws IOException;
}
