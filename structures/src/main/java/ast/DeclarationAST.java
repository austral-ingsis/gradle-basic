package ast;

import ASTVisitor.ExecutionContext;
import ASTVisitor.ASTVisitor;
import token.Token;

public class DeclarationAST extends AbstractAST {

  public DeclarationAST(Token value) {
    super(value);
  }

  public DeclarationAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ExecutionContext accept(ASTVisitor visitor, ExecutionContext executionContext) {
    return visitor.visitDeclarationAST(this, executionContext);
  }
}
