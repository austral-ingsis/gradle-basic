import exceptions.BadTokenException;

import java.io.FileNotFoundException;
import java.util.List;

import lexer.Lexer;
import lexer.PrintScriptLexer1;
import lexer.PrintScriptLexer2;
import org.junit.jupiter.api.*;
import token.Token;

public class LexerTest {

  @Test
  public void invalid() {
    String invalidStatement = "const x: int = |123|";

    Assertions.assertThrows(BadTokenException.class, () -> {
      Lexer lexer = new PrintScriptLexer1();
      lexer.lex(invalidStatement);
    });
  }

  @Test
  public void assignation() throws BadTokenException, FileNotFoundException {
    Lexer lexer = new PrintScriptLexer1();
    String codeDirectory = Utils.getCodeDirectory("assignation");
    String outputDirectory = Utils.getOutputDirectory("assignation");

    String code = Utils.getCode(codeDirectory);
    List<Token> resultTokens = lexer.lex(code);

    Assertions.assertEquals(Utils.getTokensAsString(resultTokens), Utils.getOutput(outputDirectory));
  }

  @Test
  public void operation() throws BadTokenException, FileNotFoundException {
    Lexer lexer = new PrintScriptLexer2();
    String codeDirectory = Utils.getCodeDirectory("operation");
    String outputDirectory = Utils.getOutputDirectory("operation");

    String code = Utils.getCode(codeDirectory);
    List<Token> resultTokens = lexer.lex(code);

    Assertions.assertEquals(Utils.getTokensAsString(resultTokens), Utils.getOutput(outputDirectory));
  }

  @Test
  public void conditional() throws BadTokenException, FileNotFoundException {
    Lexer lexer = new PrintScriptLexer2();
    String codeDirectory = Utils.getCodeDirectory("conditional");
    String outputDirectory = Utils.getOutputDirectory("conditional");

    String code = Utils.getCode(codeDirectory);
    List<Token> resultTokens = lexer.lex(code);

    Assertions.assertEquals(Utils.getTokensAsString(resultTokens), Utils.getOutput(outputDirectory));
  }

}