package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class DivisionAST extends AbstractAST {
  public DivisionAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitDivisionAST(this);
  }
}
