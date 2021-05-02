package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class NumberTypeAST extends AbstractAST {

  public NumberTypeAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitNumberTypeAST(this);
  }
}
