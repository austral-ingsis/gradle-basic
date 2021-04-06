package ast;

import exceptions.BadTokenException;
import token.Token;

public class IdentifierAST extends AbstractAST {

  public IdentifierAST(Token value) {
    super(value);
  }

  public IdentifierAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public AST addAST(AssignationAST newAST) throws BadTokenException {
    if (newAST.getLeftChild() != null) throw new BadTokenException();
    return new AssignationAST(newAST.getValue(), this, newAST.getRightChild());
  }

  @Override
  public AST addAST(DeclarationAST newAST) {
    if (newAST.getLeftChild() != null) throw new RuntimeException();
    return new DeclarationAST(newAST.getValue(), this, newAST.getRightChild());
  }

  @Override
  public AST addAST(OperationAST newAST) throws BadTokenException {
    if (newAST.getLeftChild() != null) throw new BadTokenException();
    return new OperationAST(newAST.getValue(), this, newAST.getRightChild());
  }
}
