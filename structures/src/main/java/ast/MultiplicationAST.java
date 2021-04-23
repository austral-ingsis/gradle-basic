package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class MultiplicationAST extends AbstractAST {
  public MultiplicationAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitMultiplicationAST(this);
  }
}
