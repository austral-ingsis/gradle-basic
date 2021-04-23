package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class MinorComparatorAST extends AbstractAST {

  public MinorComparatorAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitMinorComparatorAST(this);
  }
}
