package ast;

import ASTVisitor.ExecutionContext;
import ASTVisitor.ASTVisitor;
import token.Token;

public class DataTypeAST extends AbstractAST {

  public DataTypeAST(Token value) {
    super(value);
  }

  public DataTypeAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ExecutionContext accept(ASTVisitor visitor, ExecutionContext executionContext) {
    return visitor.visitDataTypeAST(this, executionContext);
  }
}
