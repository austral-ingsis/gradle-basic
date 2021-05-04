package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

public class VariableKeywordAST implements AST {
  private final Token value;
  private final AST child;

  public VariableKeywordAST(Token value, AST child) {
    this.value = value;
    this.child = child;
  }

  @Override
  public Token getValue() {
    return value;
  }

  @Override
  public AST getRightChild() {
    return null;
  }

  @Override
  public AST getLeftChild() {
    return null;
  }

  public AST getChild() {
    return child;
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visitVariableKeywordAST(this);
  }
}
