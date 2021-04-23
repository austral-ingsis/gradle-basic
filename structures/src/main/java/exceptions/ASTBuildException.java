package exceptions;

public class ASTBuildException extends Exception {
  private final String message;
  private transient int column;
  public static final long serialVersionUID = 4328743;

  public ASTBuildException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
