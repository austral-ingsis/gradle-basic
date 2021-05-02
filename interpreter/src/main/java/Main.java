import ast.AST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import java.util.List;
import token.Token;

public class Main {
  static Lexer lexer = new PrintScriptLexer();
  static Parser parser = new Parser();
  static Interpreter interpreter = new Interpreter();

  public static void main(String[] args) {
    //    String badLine1 = "let a: number = 5*3**+1;";
    //    String badLine2 = ": number = a;";
    //    String badLine3 = "1 + number * 7 - a -b + 100;";
    //    String badLine4 = "\"!21432@!@##^&  TW#@1235&^*kl.lK:@@;'., \" + 7;";
    //    String badLine5 = "1 + 2-4 * 7 - a -b + 100";
    //    String goodLine1 = "let a: number = 5*3+1- 2;";
    //    String goodLine2 = "1 + 2-4 * 7 - a -b + 100;";
    //    String goodLine3 = "let a: number = a * a;";
    //    String goodLine4 = "let a: number = a * a;";
    //
    //    List<String> strings = new ArrayList<>();
    //    strings.add(badLine1);
    //    strings.add(badLine2);
    //    strings.add(badLine3);
    //    strings.add(badLine4);
    //    strings.add(badLine5);
    //    strings.add(goodLine1);
    //    strings.add(goodLine2);
    //    strings.add(goodLine3);
    //    strings.add(goodLine4);
    //
    //    strings.forEach(Main::interpret);
<<<<<<< Updated upstream
    //    interpreter.interpret("let a: number = 5;");
    //    interpreter.interpret("let b: number = 15;");
    //    interpreter.interpret("let c: number = 3;");
    //    interpreter.interpret("c = 100;");
    //    interpreter.interpret("a * b + c / a - b;");
    interpreter.interpret(
        "if (100 < 200) {let a: number = 3; let b: number = 4; a + b;} else {5 + 100}");
    //    interpreter.interpret("" +
    //            "if (100 < 200) " +
    //            "{if(2>1) " +
    //            "{let d: number = 5;}" +
    //            "} " +
    //            "else " +
    //            "{let e: number = 15;}");
    //    interpreter.interpret("e");
=======
//    interpreter.interpret("let a: number = 5;");
//    interpreter.interpret("let b: number = 15;");
//    interpreter.interpret("let c: number = 3;");
//    interpreter.interpret("c = 100;");
//    interpreter.interpret("a * b + c / a - b;");
    interpreter.interpret("if (100 < 200) {let a: number = 3; let b: number = 4; a + b;} else {5 + 100}");
//    interpreter.interpret("" +
//            "if (100 < 200) " +
//            "{if(2>1) " +
//            "{let d: number = 5;}" +
//            "} " +
//            "else " +
//            "{let e: number = 15;}");
//    interpreter.interpret("e");
>>>>>>> Stashed changes
  }

  public static void interpret(String line) {
    try {
      List<Token> generatedTokens = lexer.lex(line);
      generatedTokens.forEach(token -> System.out.println(token.print()));
      AST ast = parser.parse(generatedTokens);
      System.out.println(printAST(ast));
    } catch (BadTokenException | ASTBuildException e) {
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
