package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class IfFunctionAST extends AbstractAST {

  public IfFunctionAST(Token value) {
    super(value);
  }

  public IfFunctionAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitIfFunctionAST(this);
  }
}
