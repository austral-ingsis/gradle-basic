package ast;

import ASTVisitor.ASTVisitor;
import java.util.ArrayList;
import java.util.List;
import token.Token;

public class IfBlockAST implements AST {
  private final Token token;
  private final List<AST> children;

  public IfBlockAST(Token token) {
    this.token = token;
    this.children = new ArrayList<>();
  }

  public IfBlockAST(Token token, List<AST> children) {
    this.token = token;
    this.children = children;
  }

  @Override
  public Token getValue() {
    return token;
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
