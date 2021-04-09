package ast;

import token.Token;

public class OperationAST extends AbstractAST {

  public OperationAST(Token value) {
    super(value);
  }

  public OperationAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }
}
