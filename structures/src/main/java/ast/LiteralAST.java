package ast;

import ASTVisitor.ExecutionContext;
import ASTVisitor.ASTVisitor;
import token.Token;

public class LiteralAST extends AbstractAST {

  public LiteralAST(Token value) {
    super(value);
  }

  public LiteralAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ExecutionContext accept(ASTVisitor visitor, ExecutionContext executionContext) {
    return visitor.visitLiteralAST(this, executionContext);
  }
}
