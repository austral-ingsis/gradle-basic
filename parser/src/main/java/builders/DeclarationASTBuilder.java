package builders;

import ast.*;
import exceptions.ASTBuildException;
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
  public ASTBuilder addASTBuilder(NumberTypeASTBuilder newAST) throws BadTokenException {
    if (getRightChild() != null) throw new BadTokenException();
    return new NumberDeclarationASTBuilder(getValue(), getLeftChild(), newAST);
  }

  @Override
  public ASTBuilder addASTBuilder(StringTypeASTBuilder newAST) throws BadTokenException {
    if (getRightChild() != null) throw new BadTokenException();
    return new StringDeclarationASTBuilder(getValue(), getLeftChild(), newAST);
  }

  @Override
  public ASTBuilder addASTBuilder(BooleanTypeASTBuilder newAST) throws BadTokenException {
    if (getRightChild() != null) throw new BadTokenException();
    return new DeclarationASTBuilder(getValue(), getLeftChild(), newAST);
  }

  @Override
  public ASTBuilder addASTBuilder(AssignationASTBuilder newAST) throws BadTokenException {
    return new AssignationASTBuilder(
        getValue(),
        newAST.getLeftChild() == null ? this : newAST.getLeftChild().addASTBuilder(this),
        newAST.getRightChild());
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new DeclarationAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }

  @Override
  public ASTBuilder addASTBuilder(EscCharASTBuilder newAST) throws BadTokenException {
    return this;
  }
}
