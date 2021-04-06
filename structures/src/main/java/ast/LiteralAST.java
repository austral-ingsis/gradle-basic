package ast;

import exceptions.BadTokenException;
import token.Token;

public class LiteralAST extends AbstractAST {

  public LiteralAST(Token value) {
    super(value);
  }

  public LiteralAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public AST addAST(OperationAST newAST) throws BadTokenException {
    if (newAST.getLeftChild() != null) throw new BadTokenException();
    return new OperationAST(newAST.getValue(), this, newAST.getRightChild());
  }
}
