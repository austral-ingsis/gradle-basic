package ast;

import ASTVisitor.ExecutionContext;
import ASTVisitor.ASTVisitor;
import token.Token;

public class AssignationAST extends AbstractAST {

  public AssignationAST(Token value) {
    super(value);
  }

  public AssignationAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }


  @Override
  public ExecutionContext accept(ASTVisitor visitor, ExecutionContext executionContext) {
    return visitor.visitAssignationAST(this, executionContext);
  }
}
