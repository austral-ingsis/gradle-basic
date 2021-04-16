package ast;

import ASTVisitor.ExecutionContext;
import ASTVisitor.ASTVisitor;
import token.Token;

public interface AST {
  Token getValue();

  AST getRightChild();

  AST getLeftChild();

  ExecutionContext accept(ASTVisitor visitor, ExecutionContext executionContext);
}
