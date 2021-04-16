import ast.AST;
import exceptions.BadTokenException;
import java.util.ArrayList;
import java.util.List;
import token.Token;

public class Main {
  static Lexer lexer = new PrintScriptLexer();
  static Parser parser = new Parser();

  public static void main(String[] args) {
    String badLine1 = "let a: number = 5*3**+1;";
    String badLine2 = ": number = a;";
    String badLine3 = "1 + number * 7 - a -b + 100;";
    String badLine4 = "\"!21432@!@##^&  TW#@1235&^*kl.lK:@@;'., \" + 7;";
    String badLine5 = "1 + 2-4 * 7 - a -b + 100";
    String goodLine1 = "let a: number = 5*3+1- 2;";
    String goodLine2 = "1 + 2-4 * 7 - a -b + 100;";
    String goodLine3 = "let a: number = a * a;";

    List<String> strings = new ArrayList<>();
    strings.add(badLine1);
    strings.add(badLine2);
    strings.add(badLine3);
    strings.add(badLine4);
    strings.add(badLine5);
    strings.add(goodLine1);
    strings.add(goodLine2);
    strings.add(goodLine3);

    strings.forEach(Main::interpret);
  }

  public static void interpret(String line) {
    try {
      List<Token> generatedTokens = lexer.lex(line);
      generatedTokens.forEach(token -> System.out.println(token.print()));
      AST ast = parser.parse(generatedTokens);
      System.out.println(printAST(ast));
    } catch (BadTokenException e) {
      System.out.println(e.getMessage());
    }
  }

  public static String printAST(AST ast) {
    if (ast == null) return "null";
    else
      return "( "
          + printAST(ast.getLeftChild())
          + " - "
          + ast.getValue().print()
          + " - "
          + printAST(ast.getRightChild())
          + " )";
  }
}
