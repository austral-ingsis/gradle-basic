package interpreter;

import ast.AST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import java.util.List;
import lexer.Lexer;
import lexer.PrintScriptLexer;
import parser.Parser;
import token.Token;
import utils.Printer;

public class Interpreter {

  private transient Lexer lexer;
  private transient Parser parser;
  private transient InterpretASTVisitor interpretASTVisitor;
  private transient ExecutionContext executionContext;

  public Interpreter(Printer printer) {
    lexer = new PrintScriptLexer();
    parser = new Parser();
    executionContext = new ExecutionContext(printer);
    interpretASTVisitor = new InterpretASTVisitor(executionContext);
  }

  public void interpret(String statement) {
    try {
      List<Token> generatedTokens = lexer.lex(statement);
      AST ast = parser.parse(generatedTokens);
      ast.accept(interpretASTVisitor);
    } catch (BadTokenException | ASTBuildException e) {
      System.out.println(e.getMessage());
    }
  }
}
