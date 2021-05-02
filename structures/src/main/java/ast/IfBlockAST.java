package ast;

import ASTVisitor.ASTVisitor;
import java.util.List;
import token.Token;

public class IfBlockAST implements AST {
  private final Token value;
  private transient List<AST> children;

  public IfBlockAST(Token value) {
    this.value = value;
  }

  public IfBlockAST(Token value, List<AST> children) {
    this.value = value;
    this.children = children;
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

  @Override
  public void accept(ASTVisitor visitor) {
    children.forEach(child -> child.accept(visitor));
  }
}
