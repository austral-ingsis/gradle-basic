import ASTVisitor.ExecutionContext;
import ASTVisitor.InterpretASTVisitor;
import ast.AST;
import ast.LiteralAST;
import ast.OperationAST;
import exceptions.BadTokenException;
import token.Token;

import java.util.List;

public class Interpreter {

    private Lexer lexer;
    private Parser parser;
    private InterpretASTVisitor interpretASTVisitor;
    private ExecutionContext executionContext;

    public Interpreter() {
        lexer = new Lexer();
        parser = new Parser();
        interpretASTVisitor = new InterpretASTVisitor();
        executionContext = new ExecutionContext();
    }

    public void interpret(String statement) {
        try {
            List<Token> generatedTokens = lexer.lex(statement);
            AST ast = parser.parse(generatedTokens);
            ast.accept(interpretASTVisitor, executionContext);
            System.out.println(executionContext.getResult());
        } catch (BadTokenException e) {
            System.out.println(e.getMessage());
        }
    }

}
