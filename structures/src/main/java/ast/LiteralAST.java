package ast;

import token.Token;

public class LiteralAST extends AbstractAST {

  public LiteralAST(Token value) {
    super(value);
  }

  public LiteralAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }
}
