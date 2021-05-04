package interpreter;

import ast.AST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import java.security.InvalidAlgorithmParameterException;
import java.util.List;
import java.util.function.Consumer;
import lexer.Lexer;
import lexer.PrintScriptLexer1;
import lexer.PrintScriptLexer2;
import parser.Parser;
import token.Token;

public class Interpreter {

  private transient Lexer lexer;
  private transient Parser parser;
  private transient InterpretASTVisitor interpretASTVisitor;
  private transient ExecutionContext executionContext;

  public Interpreter(String version, Consumer<String> lines)
      throws InvalidAlgorithmParameterException {
    switch (version) {
      case "1.0" -> lexer = new PrintScriptLexer1();
      case "1.1" -> lexer = new PrintScriptLexer2();
      default -> throw new InvalidAlgorithmParameterException();
    }
    parser = new Parser();
    executionContext = new ExecutionContext(lines);
    interpretASTVisitor = new InterpretASTVisitor(executionContext);
  }

  public void interpret(String statement) throws BadTokenException, ASTBuildException {
    List<Token> generatedTokens = lexer.lex(statement);
    AST ast = parser.parse(generatedTokens);
    ast.accept(interpretASTVisitor);
  }
}
