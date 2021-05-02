package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class EqualsComparatorAST extends AbstractAST {

  public EqualsComparatorAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitEqualsComparatorAST(this);
  }
}
