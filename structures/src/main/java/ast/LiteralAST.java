package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class LiteralAST extends AbstractAST {

  public LiteralAST(Token value) {
    super(value);
  }

  public LiteralAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitLiteralAST(this);
  }
}
