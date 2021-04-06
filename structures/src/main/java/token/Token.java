package token;

public class Token {
  private TokenType type;
  private String value;

  public Token(TokenType type, String value) {
    this.type = type;
    this.value = value;
  }

  public TokenType getType() {
    return type;
  }

  String getValue() {
    return value;
  }

  public String print() {
    return type + ": " + value;
  }
}
