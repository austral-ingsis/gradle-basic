package handler;

import exceptions.BadTokenException;
import java.util.ArrayList;
import java.util.List;
import token.Token;

public class PrintScriptHandler implements Handler {
  private transient List<Token> tokens;
  private transient int position;
  private transient String currentStatement;
  private transient char currentChar;

  @Override
  public List<Token> handle(String statement) throws BadTokenException {
    tokens = new ArrayList<>();
    position = 0;
    this.currentStatement = statement;
    currentChar = currentStatement.charAt(position);
    generateTokens();
    return tokens;
  }

  private void generateTokens() throws BadTokenException {
    TokenBuilder tokenBuilder = new TokenBuilder();

    while (!shouldFinish(position, currentStatement)) {
      advance();
      if (tokenBuilder.shouldAddNext(currentChar)) {
        tokenBuilder.addChar(currentChar);
        position = position + 1;
      } else {
        if (tokenBuilder.isValid()) {
          tokens.add(tokenBuilder.build());
          tokenBuilder = new TokenBuilder();
        } else throw new RuntimeException("Non valid token");
      }
    }

    if (tokenBuilder.isValid()) tokens.add(tokenBuilder.build());
  }

  private void advance() {
    currentChar = currentStatement.charAt(position);
  }

  private boolean shouldFinish(int position, String statement) {
    return position == statement.length();
  }
}
