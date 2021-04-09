package ast;

import token.Token;

public class DeclarationAST extends AbstractAST {

  public DeclarationAST(Token value) {
    super(value);
  }

  public DeclarationAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }
}
