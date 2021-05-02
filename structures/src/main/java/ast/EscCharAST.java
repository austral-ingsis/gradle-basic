package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class EscCharAST extends AbstractAST {
  public EscCharAST(Token value) {
    super(value);
  }

  public EscCharAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {}
}
