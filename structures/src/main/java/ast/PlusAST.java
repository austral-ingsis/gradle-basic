package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class PlusAST extends AbstractAST {

  public PlusAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitPlusAST(this);
  }
}
