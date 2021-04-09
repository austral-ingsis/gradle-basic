package token;

public enum TokenType {
  STRING(0),
  NUMBER(0),
  IDENTIFIER(0),
  STRING_TYPE(0),
  NUMBER_TYPE(0),
  VARIABLE_KEYWORD(0),
  PLUS_OPERATOR(0),
  MINUS_OPERATOR(0),
  MULTIPLICATION_OPERATOR(1),
  DIVISION_OPERATOR(1),
  EQUALS(0),
  COLON(0),
  FUNCTION_NAME(0),
  LEFT_PARENTHESES(0),
  RIGHT_PARENTHESES(0),
  ESC_CHAR(0);

  private int precedence;

  TokenType(int precedence) {
    this.precedence = precedence;
  }

  public int getPrecedence() {
    return precedence;
  }
}
