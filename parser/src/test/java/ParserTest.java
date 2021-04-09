import ast.AST;
import exceptions.BadTokenException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import token.Token;
import token.TokenType;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {
  @Test
  public void testParser() throws BadTokenException {
    Parser parser = new Parser();

    // let a: number = a * a;


    List<Token> generatedTokens = new ArrayList<>();
    generatedTokens.add(new Token(TokenType.VARIABLE_KEYWORD, "let"));
    generatedTokens.add(new Token(TokenType.IDENTIFIER, "a"));
    generatedTokens.add(new Token(TokenType.COLON, ":"));
    generatedTokens.add(new Token(TokenType.NUMBER_TYPE, "number"));
    generatedTokens.add(new Token(TokenType.EQUALS, "="));
    generatedTokens.add(new Token(TokenType.IDENTIFIER, "a"));
    generatedTokens.add(new Token(TokenType.MULTIPLICATION_OPERATOR, "*"));
    generatedTokens.add(new Token(TokenType.IDENTIFIER, "a"));
    generatedTokens.add(new Token(TokenType.ESC_CHAR, ";"));

    generatedTokens.forEach(token -> System.out.println(token.print()));
    AST ast = parser.parse(generatedTokens);



    Assertions.assertEquals(TokenType.EQUALS, ast.getValue().getType());
    Assertions.assertEquals(TokenType.COLON, ast.getLeftChild().getValue().getType());
    Assertions.assertEquals(TokenType.MULTIPLICATION_OPERATOR, ast.getRightChild().getValue().getType());
    Assertions.assertEquals(TokenType.IDENTIFIER, ast.getLeftChild().getLeftChild().getValue().getType());
    Assertions.assertEquals(TokenType.NUMBER_TYPE, ast.getLeftChild().getRightChild().getValue().getType());
    Assertions.assertEquals(TokenType.IDENTIFIER, ast.getRightChild().getLeftChild().getValue().getType());
    Assertions.assertEquals(TokenType.IDENTIFIER, ast.getRightChild().getRightChild().getValue().getType());
  }
}
