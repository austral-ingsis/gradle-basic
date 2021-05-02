package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class IdentifierAST extends AbstractAST {

  public IdentifierAST(Token value) {
    super(value);
  }

  public IdentifierAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitIdentifierAST(this);
  }
}
