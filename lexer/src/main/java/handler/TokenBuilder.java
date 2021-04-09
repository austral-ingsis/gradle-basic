package handler;

import exceptions.BadTokenException;
import java.util.*;
import token.Token;
import token.TokenType;

public class TokenBuilder {
  private static final String LETTERS = "abcdefghijklmnñopqrstuvwxyzABCDEGHIJKLMNÑOPQRSTUVWXYZ";
  private static final String NUMBERS = "0123456789";
  private static final String SPECIAL_CHARACTERS = " `~!@#$%^&*()_-+=[{]}|;:'<>,./?\"";
  private static final List<TokenType> singleCharTypes =
      new ArrayList<>() {
        {
          add(TokenType.PLUS_OPERATOR);
          add(TokenType.MINUS_OPERATOR);
          add(TokenType.MULTIPLICATION_OPERATOR);
          add(TokenType.DIVISION_OPERATOR);
          add(TokenType.EQUALS);
          add(TokenType.COLON);
          add(TokenType.LEFT_PARENTHESES);
          add(TokenType.RIGHT_PARENTHESES);
          add(TokenType.ESC_CHAR);
        }
      };

  private static final Map<TokenType, String> tokenTypes =
      new LinkedHashMap<>() {
        {
          put(TokenType.ESC_CHAR, ";");
          put(TokenType.PLUS_OPERATOR, "+");
          put(TokenType.MINUS_OPERATOR, "-");
          put(TokenType.MULTIPLICATION_OPERATOR, "*");
          put(TokenType.DIVISION_OPERATOR, "/");
          put(TokenType.EQUALS, "=");
          put(TokenType.COLON, ":");
          put(TokenType.LEFT_PARENTHESES, "(");
          put(TokenType.RIGHT_PARENTHESES, ")");
          put(TokenType.IDENTIFIER, LETTERS);
          put(TokenType.NUMBER, NUMBERS);
          put(TokenType.STRING, LETTERS + NUMBERS + SPECIAL_CHARACTERS);
        }
      };

  //    private static final List<Function<TokenType, Boolean>> shouldAddNextRules = new
  // ArrayList<>() {{
  //       add(tokenType -> );
  //    }};

  private transient String value;
  private transient TokenType currentTokenType;

  public TokenBuilder() {
    this.value = "";
  }

  public Token build() {
    if (currentTokenType == TokenType.IDENTIFIER) {
      switch (value) {
        case "let" -> currentTokenType = TokenType.VARIABLE_KEYWORD;
        case "string" -> currentTokenType = TokenType.STRING_TYPE;
        case "number" -> currentTokenType = TokenType.NUMBER_TYPE;
        case "printLn" -> currentTokenType = TokenType.FUNCTION_NAME;
      }
    }
    return new Token(currentTokenType, value);
  }

  public void addChar(char currentChar) throws BadTokenException {
    if (currentChar == ' ' && currentTokenType != TokenType.STRING) return;
    if (currentTokenType == null) {
      TokenType tokenType =
          TokenBuilder.tokenTypes.keySet().stream()
              .filter(type -> TokenBuilder.tokenTypes.get(type).indexOf(currentChar) != -1)
              .findFirst()
              .orElseThrow(() -> new BadTokenException("Not supported character: " + currentChar));
      value += currentChar;
      currentTokenType = tokenType;
    } else value += currentChar;
  }

  public boolean isValid() {
    if (currentTokenType == null) return false;
    if (currentTokenType == TokenType.STRING) {
      return value.length() > 1
          && value.charAt(0) == '"'
          && value.charAt(value.length() - 1) == '"';
    } else {
      return true;
    }
  }

  public boolean shouldAddNext(char nextChar) {
    if (currentTokenType == null) return true;
    if (singleCharTypes.contains(currentTokenType)) return false;
    if (currentTokenType == TokenType.STRING && isValid()) return false;
    return tokenTypes.get(currentTokenType).indexOf(nextChar) != -1;
  }
}
