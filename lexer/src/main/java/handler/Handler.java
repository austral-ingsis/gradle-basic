package handler;

import exceptions.BadTokenException;
import java.util.List;
import token.Token;

public interface Handler {
  List<Token> handle(String statement) throws BadTokenException;
}
