package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class StringTypeAST extends AbstractAST {

  public StringTypeAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitStringTypeAST(this);
  }
}
