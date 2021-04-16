package ast;

import ASTVisitor.ExecutionContext;
import ASTVisitor.ASTVisitor;
import token.Token;

public class IdentifierAST extends AbstractAST {

  public IdentifierAST(Token value) {
    super(value);
  }

  public IdentifierAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ExecutionContext accept(ASTVisitor visitor, ExecutionContext executionContext) {
    return visitor.visitIdentifierAST(this, executionContext);
  }
}
