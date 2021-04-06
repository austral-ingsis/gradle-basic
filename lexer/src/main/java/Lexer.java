import java.util.ArrayList;
import java.util.List;
import token.Token;
import token.TokenType;

public class Lexer {
  private List<Token> tokens;
  private int position;
  private String currentStatement;
  private char currentChar;
  private static final String DIGITS = "0123456789";
  private static final String LETTERS = "abcdefghijklmnñopqrstuvwxyzABCDEGHIJKLMNÑOPQRSTUVWXYZ";
  private static final char ESC_CHAR = ';';

  public Lexer() {
    tokens = new ArrayList<>();
    position = -1;
  }

  public List<Token> lex(String statement) {
    tokens = new ArrayList<>();
    position = -1;
    this.currentStatement = statement;
    generateTokens();
    return tokens;
  }

  private void generateTokens() {
    advance();
    while (currentChar != ESC_CHAR) {
      generateToken();
    }
  }

  private void advance() {
    if (position < currentStatement.length() - 1) { // sacar a una funcion
      currentChar = currentStatement.charAt(++position);
    } else currentChar = ESC_CHAR;
  }

  private void generateToken() {
    boolean valid = false;

    switch (currentChar) { // agregar un handler
      case ' ' -> {
        valid = true;
        advance();
      }
      case '+' -> {
        tokens.add(new Token(TokenType.PLUS_OPERATOR, "+"));
        valid = true;
        advance();
      }
      case '-' -> {
        tokens.add(new Token(TokenType.MINUS_OPERATOR, "-"));
        valid = true;
        advance();
      }
      case '*' -> {
        tokens.add(new Token(TokenType.MULTIPLICATION_OPERATOR, "*"));
        valid = true;
        advance();
      }
      case '/' -> {
        tokens.add(new Token(TokenType.DIVISION_OPERATOR, "/"));
        valid = true;
        advance();
      }
      case '=' -> {
        tokens.add(new Token(TokenType.EQUALS, "="));
        valid = true;
        advance();
      }
      case '"' -> {
        advance();
        generateStringToken();
        valid = true;
      }
      case ':' -> {
        advance();
        tokens.add(new Token(TokenType.COLON, ":"));
        valid = true;
      }
      case '(' -> {
        advance();
        tokens.add(new Token(TokenType.LEFT_PARENTHESES, "("));
      }
      case ')' -> {
        advance();
        tokens.add(new Token(TokenType.RIGHT_PARENTHESES, ")"));
      }
      case ESC_CHAR -> valid = true;
    }
    if (!valid && DIGITS.indexOf(currentChar) != -1) {
      generateNumberToken();
      valid = true;
    }
    if (!valid && LETTERS.indexOf(currentChar) != -1) {
      generateConstant();
      valid = true;
    }
    if (!valid) throw new RuntimeException("Not supported character: " + currentChar);
  }

  private void generateNumberToken() {
    StringBuilder result = new StringBuilder();
    while (DIGITS.indexOf(currentChar) != -1) {
      result.append(currentChar);
      advance();
    }
    tokens.add(new Token(TokenType.NUMBER, result.toString()));
  }

  private void generateStringToken() {
    StringBuilder result = new StringBuilder();
    while (currentChar != '"') {
      result.append(currentChar);
      advance();
    }
    advance();
    tokens.add(new Token(TokenType.STRING, result.toString()));
  }

  private void generateConstant() {
    StringBuilder resultBuilder = new StringBuilder();
    while (DIGITS.indexOf(currentChar) != -1 || LETTERS.indexOf(currentChar) != -1) {
      resultBuilder.append(currentChar);
      advance();
    }

    String result = resultBuilder.toString();

    switch (result) {
      case "let" -> tokens.add(new Token(TokenType.VARIABLE_KEYWORD, result));
      case "string" -> tokens.add(new Token(TokenType.STRING_TYPE, result));
      case "number" -> tokens.add(new Token(TokenType.NUMBER_TYPE, result));
      case "printLn" -> tokens.add(new Token(TokenType.FUNCTION_NAME, result));
      default -> tokens.add(new Token(TokenType.IDENTIFIER, result));
    }
  }
}
