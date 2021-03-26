import token.Token;
import token.TokenType;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private List<Token> tokens;
    private int position;
    private String currentStatement;
    private char currentChar;

    private static String DIGITS = "0123456789";
    private static String LETTERS = "abcdefghijklmnñopqrstuvwxyzABCDEGHIJKLMNÑOPQRSTUVWXYZ";
    private final static char ESC_CHAR = ';';

    public Lexer(){
        tokens = new ArrayList<>();
        position = -1;
    }

    public List<Token> lexicalAnalysis(String statement){
        tokens = new ArrayList<>();
        position = -1;
        this.currentStatement = statement;
        generateTokens();
        return tokens;
    }

    void generateTokens() {
        advance();
        while (currentChar != ESC_CHAR) {
            generateToken();
        }
    }

    public void advance() {
        if (position < currentStatement.length() - 1) {
            currentChar = currentStatement.charAt(++position);
        } else currentChar = ESC_CHAR;
    }

    public void generateToken() {
        boolean valid = false;

        switch (currentChar) {
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
            case ESC_CHAR -> {
                valid = true;
            }
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

    public void generateNumberToken() {
        StringBuilder result = new StringBuilder();
        while (DIGITS.indexOf(currentChar) != -1) {
            result.append(currentChar);
            advance();
        }
        tokens.add(new Token(TokenType.NUMBER, result.toString()));
    }

    private void generateStringToken(){
        StringBuilder result = new StringBuilder();
        while (currentChar != '"') {
            result.append(currentChar);
            advance();
        }
        advance();
        tokens.add(new Token(TokenType.STRING, result.toString()));
    }

    private void generateConstant(){
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
