package ast;

import ASTVisitor.ExecutionContext;
import ASTVisitor.ASTVisitor;
import token.Token;

public class OperationAST extends AbstractAST {

  public OperationAST(Token value) {
    super(value);
  }

  public OperationAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ExecutionContext accept(ASTVisitor visitor, ExecutionContext executionContext) {
    return visitor.visitOperationAST(this, executionContext);
  }
}
