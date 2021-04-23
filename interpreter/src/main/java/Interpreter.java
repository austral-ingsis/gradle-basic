import ast.AST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import java.util.List;
import token.Token;

public class Interpreter {

  private transient Lexer lexer;
  private transient Parser parser;
  private transient InterpretASTVisitor interpretASTVisitor;
  private transient ExecutionContext executionContext;

  public Interpreter() {
    lexer = new PrintScriptLexer();
    parser = new Parser();
    executionContext = new ExecutionContext();
    interpretASTVisitor = new InterpretASTVisitor(executionContext);
  }

  public void interpret(String statement) {
    try {
      List<Token> generatedTokens = lexer.lex(statement);
      AST ast = parser.parse(generatedTokens);
      ast.accept(interpretASTVisitor);
      System.out.println(executionContext.getResult());
    } catch (BadTokenException | ASTBuildException e) {
      System.out.println(e.getMessage());
    }
  }
}
