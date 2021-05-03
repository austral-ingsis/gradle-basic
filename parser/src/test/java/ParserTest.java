import ast.AST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parser.Parser;
import token.Token;
import token.TokenType;

public class ParserTest {
  private static String VARIABLE_KEYWORD = "let";

  @Test
  public void testParser() throws BadTokenException, ASTBuildException {
    Parser parser = new Parser();

    List<Token> generatedTokens = new ArrayList<>();
    generatedTokens.add(new Token(TokenType.VARIABLE_KEYWORD, VARIABLE_KEYWORD));
    generatedTokens.add(new Token(TokenType.IDENTIFIER, "a"));
    generatedTokens.add(new Token(TokenType.COLON, ":"));
    generatedTokens.add(new Token(TokenType.NUMBER_TYPE, "number"));
    generatedTokens.add(new Token(TokenType.EQUALS, "="));
    generatedTokens.add(new Token(TokenType.IDENTIFIER, "a"));
    generatedTokens.add(new Token(TokenType.MULTIPLICATION_OPERATOR, "*"));
    generatedTokens.add(new Token(TokenType.IDENTIFIER, "a"));
    generatedTokens.add(new Token(TokenType.ESC_CHAR, ";"));

    AST ast = parser.parse(generatedTokens);

    Assertions.assertEquals(TokenType.EQUALS, ast.getValue().getType());
    Assertions.assertEquals(TokenType.COLON, ast.getLeftChild().getValue().getType());
    Assertions.assertEquals(
        TokenType.MULTIPLICATION_OPERATOR, ast.getRightChild().getValue().getType());
    Assertions.assertEquals(
        TokenType.IDENTIFIER, ast.getLeftChild().getLeftChild().getValue().getType());
    Assertions.assertEquals(
        TokenType.NUMBER_TYPE, ast.getLeftChild().getRightChild().getValue().getType());
    Assertions.assertEquals(
        TokenType.IDENTIFIER, ast.getRightChild().getLeftChild().getValue().getType());
    Assertions.assertEquals(
        TokenType.IDENTIFIER, ast.getRightChild().getRightChild().getValue().getType());
  }

  @Test
  public void testParserComplexOperation() throws BadTokenException, ASTBuildException {
    Parser parser = new Parser();

    List<Token> generatedTokens = new ArrayList<>();
    generatedTokens.add(new Token(TokenType.VARIABLE_KEYWORD, VARIABLE_KEYWORD));
    generatedTokens.add(new Token(TokenType.IDENTIFIER, "a"));
    generatedTokens.add(new Token(TokenType.COLON, ":"));
    generatedTokens.add(new Token(TokenType.STRING_TYPE, "string"));
    generatedTokens.add(new Token(TokenType.EQUALS, "="));
    generatedTokens.add(new Token(TokenType.STRING, "\"my string\""));
    generatedTokens.add(new Token(TokenType.ESC_CHAR, ";"));

    AST ast = parser.parse(generatedTokens);

    Assertions.assertEquals(TokenType.EQUALS, ast.getValue().getType());
    Assertions.assertEquals(TokenType.COLON, ast.getLeftChild().getValue().getType());
    Assertions.assertEquals(TokenType.STRING, ast.getRightChild().getValue().getType());
    Assertions.assertEquals(
        TokenType.IDENTIFIER, ast.getLeftChild().getLeftChild().getValue().getType());
    Assertions.assertEquals(
        TokenType.STRING_TYPE, ast.getLeftChild().getRightChild().getValue().getType());
  }

  @Test
  public void testParser2() throws BadTokenException, ASTBuildException {
    Parser parser = new Parser();

    List<Token> generatedTokens = new ArrayList<>();
    generatedTokens.add(new Token(TokenType.IDENTIFIER, "a"));
    generatedTokens.add(new Token(TokenType.EQUALS, "="));
    generatedTokens.add(new Token(TokenType.NUMBER, "2"));
    generatedTokens.add(new Token(TokenType.ESC_CHAR, ";"));

    AST ast = parser.parse(generatedTokens);

    Assertions.assertEquals(TokenType.EQUALS, ast.getValue().getType());
    Assertions.assertEquals(TokenType.IDENTIFIER, ast.getLeftChild().getValue().getType());
    Assertions.assertEquals(TokenType.NUMBER, ast.getRightChild().getValue().getType());
  }

  @Test
  public void testParserShouldFail() {
    List<Token> generatedTokens = new ArrayList<>();

    generatedTokens.add(new Token(TokenType.VARIABLE_KEYWORD, VARIABLE_KEYWORD));
    generatedTokens.add(new Token(TokenType.IDENTIFIER, "a"));
    generatedTokens.add(new Token(TokenType.COLON, ":"));
    generatedTokens.add(new Token(TokenType.NUMBER_TYPE, "number"));
    generatedTokens.add(new Token(TokenType.EQUALS, "="));
    generatedTokens.add(new Token(TokenType.NUMBER, "5"));
    generatedTokens.add(new Token(TokenType.MULTIPLICATION_OPERATOR, "*"));
    generatedTokens.add(new Token(TokenType.NUMBER, "3"));
    generatedTokens.add(new Token(TokenType.MULTIPLICATION_OPERATOR, "*"));
    generatedTokens.add(new Token(TokenType.MULTIPLICATION_OPERATOR, "*"));
    generatedTokens.add(new Token(TokenType.PLUS_OPERATOR, "+"));
    generatedTokens.add(new Token(TokenType.NUMBER, "1"));
    generatedTokens.add(new Token(TokenType.ESC_CHAR, ";"));

    Assertions.assertThrows(
        BadTokenException.class,
        () -> {
          Parser parser = new Parser();
          parser.parse(generatedTokens);
        });
  }

  @Test
  public void testParserShouldFail_2() {
    List<Token> generatedTokens = new ArrayList<>();
    generatedTokens.add(new Token(TokenType.VARIABLE_KEYWORD, VARIABLE_KEYWORD));
    generatedTokens.add(new Token(TokenType.IDENTIFIER, "a"));
    generatedTokens.add(new Token(TokenType.COLON, ":"));
    generatedTokens.add(new Token(TokenType.NUMBER_TYPE, "number"));
    generatedTokens.add(new Token(TokenType.EQUALS, "="));
    generatedTokens.add(new Token(TokenType.NUMBER, "5"));
    generatedTokens.add(new Token(TokenType.MULTIPLICATION_OPERATOR, "*"));
    generatedTokens.add(new Token(TokenType.NUMBER, "3"));
    generatedTokens.add(new Token(TokenType.PLUS_OPERATOR, "+"));
    generatedTokens.add(new Token(TokenType.NUMBER, "1"));
    generatedTokens.add(new Token(TokenType.MINUS_OPERATOR, "-"));
    generatedTokens.add(new Token(TokenType.MINUS_OPERATOR, "-"));
    generatedTokens.add(new Token(TokenType.NUMBER, "2"));

    Assertions.assertThrows(
        BadTokenException.class,
        () -> {
          Parser parser = new Parser();
          parser.parse(generatedTokens);
        });
  }
}
