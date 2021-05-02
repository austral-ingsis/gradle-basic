package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class GreaterComparatorAST extends AbstractAST {

  public GreaterComparatorAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitGreaterComparatorAST(this);
  }
}
