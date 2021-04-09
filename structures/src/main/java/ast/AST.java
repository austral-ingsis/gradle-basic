package ast;

import token.Token;

public interface AST {
  Token getValue();

  AST getRightChild();

  AST getLeftChild();
}
