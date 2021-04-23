package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class NumberAST extends AbstractAST {

  public NumberAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitNumberAST(this);
  }
}
