package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class IfBodyAST extends AbstractAST {

  public IfBodyAST(Token value) {
    super(value);
  }

  public IfBodyAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitIfBodyAST(this);
  }
}
