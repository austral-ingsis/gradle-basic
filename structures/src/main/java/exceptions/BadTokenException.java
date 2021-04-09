package exceptions;

public class BadTokenException extends Exception {
  private transient String message;
  private transient int column;
  public static final long serialVersionUID = 4328743;

  public BadTokenException() {}

  public BadTokenException(String message) {
    this.message = message;
  }

  public BadTokenException(int column) {
    this.column = column;
  }

  @Override
  public String getMessage() {
    return message != null ? message : ("Error in token at position: " + column);
  }
}
