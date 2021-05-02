package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class StringAST extends AbstractAST {

  public StringAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitStringAST(this);
  }
}
