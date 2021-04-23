package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class GreaterOrEqualsComparatorAST extends AbstractAST {
  public GreaterOrEqualsComparatorAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitGreaterOrEqualsComparatorAST(this);
  }
}
