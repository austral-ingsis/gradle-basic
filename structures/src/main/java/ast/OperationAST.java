package ast;

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
  public void accept(ASTVisitor visitor) {
    visitor.visitOperationAST(this);
  }
}
