package token;

public class Token {
  private transient TokenType type;
  private transient String value;

  public Token(TokenType type, String value) {
    this.type = type;
    this.value = value;
  }

  public TokenType getType() {
    return type;
  }

  public String getValue() {
    return value;
  }

  public String print() {
    return type + ": " + value;
  }
}
