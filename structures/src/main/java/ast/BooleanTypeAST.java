package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class BooleanTypeAST extends AbstractAST {
  public BooleanTypeAST(Token value) {
    super(value);
  }

  public BooleanTypeAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitBooleanTypeAST(this);
  }
}
