package builders;

import ast.*;
import exceptions.BadTokenException;
import token.Token;

public class DeclarationASTBuilder extends AbstractASTBuilder {

  public DeclarationASTBuilder(Token value) {
    super(value);
  }

  public DeclarationASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ASTBuilder addASTBuilder(AssignationASTBuilder newAST) throws BadTokenException {
    if (getLeftChild() == null || getRightChild() == null || newAST.getLeftChild() != null)
      throw new BadTokenException();
    return new AssignationASTBuilder(newAST.getValue(), this, newAST.getRightChild());
  }

  @Override
  public ASTBuilder addASTBuilder(DataTypeASTBuilder newAST) throws BadTokenException {
    if (getRightChild() != null) throw new BadTokenException();
    return new DeclarationASTBuilder(getValue(), getLeftChild(), newAST);
  }

  @Override
  public AST buildAST() {
    return new DeclarationAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
