package exceptions;

public class BadTokenException extends Exception{
    private String message;
    private int column;
    private int line;
    public BadTokenException(){}
    public BadTokenException(String message) {this.message = message;}
    public BadTokenException(int column) {this.column = column;}

    @Override
    public String getMessage() {
        return message != null? message : ("Error in token at position: " + column);
    }

    public int getColumn() {
        return column;
    }

    public int getLine() {
        return line;
    }
}
