import exceptions.BadTokenException;
import java.util.List;
import org.junit.jupiter.api.*;
import token.Token;
import token.TokenType;

public class LexerTest {
  @Test
  public void tokenShouldContainAll() throws BadTokenException {
    Lexer lexer = new Lexer();
    String statement = "let a: number = a * a;";
    List<Token> tokens = lexer.lex(statement);
    Assertions.assertEquals(
        1, tokens.stream().filter(token -> token.getType() == TokenType.VARIABLE_KEYWORD).count());
    Assertions.assertEquals(
        3, tokens.stream().filter(token -> token.getType() == TokenType.IDENTIFIER).count());
    Assertions.assertEquals(
        1, tokens.stream().filter(token -> token.getType() == TokenType.COLON).count());
    Assertions.assertEquals(
        1, tokens.stream().filter(token -> token.getType() == TokenType.NUMBER_TYPE).count());
    Assertions.assertEquals(
        1, tokens.stream().filter(token -> token.getType() == TokenType.EQUALS).count());
    Assertions.assertEquals(
        1,
        tokens.stream()
            .filter(token -> token.getType() == TokenType.MULTIPLICATION_OPERATOR)
            .count());
    Assertions.assertEquals(
        1, tokens.stream().filter(token -> token.getType() == TokenType.ESC_CHAR).count());
  }

  @Test
  public void tokenShouldContainAll_2() throws BadTokenException {
    Lexer lexer = new Lexer();
    String statement = "let str: string = \"!21432@!@##^&  TW#@1235&^*kl.lK:@@;'., \";";
    List<Token> tokens = lexer.lex(statement);
    Assertions.assertEquals(
        1, tokens.stream().filter(token -> token.getType() == TokenType.VARIABLE_KEYWORD).count());
    Assertions.assertEquals(
        1, tokens.stream().filter(token -> token.getType() == TokenType.IDENTIFIER).count());
    Assertions.assertEquals(
        1, tokens.stream().filter(token -> token.getType() == TokenType.COLON).count());
    Assertions.assertEquals(
        1, tokens.stream().filter(token -> token.getType() == TokenType.STRING_TYPE).count());
    Assertions.assertEquals(
        1, tokens.stream().filter(token -> token.getType() == TokenType.EQUALS).count());
    Assertions.assertEquals(
        1, tokens.stream().filter(token -> token.getType() == TokenType.STRING).count());
    Assertions.assertEquals(
        1, tokens.stream().filter(token -> token.getType() == TokenType.ESC_CHAR).count());
  }
}
