package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class BooleanAST extends AbstractAST {
  public BooleanAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitBooleanAST(this);
  }
}
