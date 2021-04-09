package ast;

import token.Token;

public class IdentifierAST extends AbstractAST {

  public IdentifierAST(Token value) {
    super(value);
  }

  public IdentifierAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }
}
