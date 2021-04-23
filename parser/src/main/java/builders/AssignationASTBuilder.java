package builders;

import ast.*;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;

public class AssignationASTBuilder extends AbstractASTBuilder {

  public AssignationASTBuilder(Token value) {
    super(value);
  }

  public AssignationASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ASTBuilder addASTBuilder(NumberASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    return new AssignationASTBuilder(
        getValue(), getLeftChild(), rightChild == null ? newAST : rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(StringASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    return new AssignationASTBuilder(
        getValue(), getLeftChild(), rightChild == null ? newAST : rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(PlusASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    if (rightChild == null) throw new BadTokenException();
    return new AssignationASTBuilder(getValue(), getLeftChild(), rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(MinusASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    if (rightChild == null) throw new BadTokenException();
    return new AssignationASTBuilder(getValue(), getLeftChild(), rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(MultiplicationASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    if (rightChild == null) throw new BadTokenException();
    return new AssignationASTBuilder(getValue(), getLeftChild(), rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(DivisionASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    if (rightChild == null) throw new BadTokenException();
    return new AssignationASTBuilder(getValue(), getLeftChild(), rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(EqualsComparatorASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    if (rightChild == null) throw new BadTokenException();
    return new AssignationASTBuilder(getValue(), getLeftChild(), rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterComparatorASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    if (rightChild == null) throw new BadTokenException();
    return new AssignationASTBuilder(getValue(), getLeftChild(), rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    if (rightChild == null) throw new BadTokenException();
    return new AssignationASTBuilder(getValue(), getLeftChild(), rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(MinorComparatorASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    if (rightChild == null) throw new BadTokenException();
    return new AssignationASTBuilder(getValue(), getLeftChild(), rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(MinorOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    if (rightChild == null) throw new BadTokenException();
    return new AssignationASTBuilder(getValue(), getLeftChild(), rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(IdentifierASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    return new AssignationASTBuilder(
        getValue(), getLeftChild(), rightChild == null ? newAST : rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(BooleanASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    return new AssignationASTBuilder(
        getValue(), getLeftChild(), rightChild == null ? newAST : rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(EscCharASTBuilder newAST) throws BadTokenException {
    return this;
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new AssignationAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
