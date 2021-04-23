package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class MinusAST extends AbstractAST {
  public MinusAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitMinusAST(this);
  }
}
