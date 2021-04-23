package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class MinorOrEqualsComparatorAST extends AbstractAST {
  public MinorOrEqualsComparatorAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitMinorOrEqualsComparatorAST(this);
  }
}
