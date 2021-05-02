package builders;

import ast.AST;
import ast.EqualsComparatorAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;

public class EqualsComparatorASTBuilder extends AbstractASTBuilder {

  public EqualsComparatorASTBuilder(Token value) {
    super(value);
  }

  public EqualsComparatorASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ASTBuilder addASTBuilder(BooleanASTBuilder newAST) throws BadTokenException {
    return new EqualsComparatorASTBuilder(
        getValue(),
        getLeftChild(),
        getRightChild() == null ? newAST : getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(StringASTBuilder newAST) throws BadTokenException {
    return new EqualsComparatorASTBuilder(
        getValue(),
        getLeftChild(),
        getRightChild() == null ? newAST : getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(NumberASTBuilder newAST) throws BadTokenException {
    return new EqualsComparatorASTBuilder(
        getValue(),
        getLeftChild(),
        getRightChild() == null ? newAST : getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(IdentifierASTBuilder newAST) throws BadTokenException {
    return new EqualsComparatorASTBuilder(
        getValue(),
        getLeftChild(),
        getRightChild() == null ? newAST : getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(PlusASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
<<<<<<< Updated upstream
    return new EqualsComparatorASTBuilder(getValue(), getLeftChild(), newAST);
=======
    return new EqualsComparatorASTBuilder(
        getValue(),
        getLeftChild(),
        newAST);
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(MinusASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
<<<<<<< Updated upstream
    return new EqualsComparatorASTBuilder(getValue(), getLeftChild(), newAST);
=======
    return new EqualsComparatorASTBuilder(
        getValue(),
        getLeftChild(),
        newAST);
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(MultiplicationASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
<<<<<<< Updated upstream
    return new EqualsComparatorASTBuilder(getValue(), getLeftChild(), newAST);
=======
    return new EqualsComparatorASTBuilder(
        getValue(),
        getLeftChild(),
        newAST);
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(DivisionASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
<<<<<<< Updated upstream
    return new EqualsComparatorASTBuilder(getValue(), getLeftChild(), newAST);
=======
    return new EqualsComparatorASTBuilder(
        getValue(),
        getLeftChild(), newAST);
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(EqualsComparatorASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
<<<<<<< Updated upstream
    return new EqualsComparatorASTBuilder(getValue(), getLeftChild(), newAST);
=======
    return new EqualsComparatorASTBuilder(
            getValue(),
            getLeftChild(), newAST);
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterComparatorASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
<<<<<<< Updated upstream
    return new EqualsComparatorASTBuilder(getValue(), getLeftChild(), newAST);
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
    return new EqualsComparatorASTBuilder(getValue(), getLeftChild(), newAST);
=======
    return new EqualsComparatorASTBuilder(
            getValue(),
            getLeftChild(), newAST);
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterOrEqualsComparatorASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
    return new EqualsComparatorASTBuilder(
            getValue(),
            getLeftChild(), newAST);
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(MinorComparatorASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
<<<<<<< Updated upstream
    return new EqualsComparatorASTBuilder(getValue(), getLeftChild(), newAST);
  }

  @Override
  public ASTBuilder addASTBuilder(MinorOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
    return new EqualsComparatorASTBuilder(getValue(), getLeftChild(), newAST);
=======
    return new EqualsComparatorASTBuilder(
            getValue(),
            getLeftChild(), newAST);
  }

  @Override
  public ASTBuilder addASTBuilder(MinorOrEqualsComparatorASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
    return new EqualsComparatorASTBuilder(
            getValue(),
            getLeftChild(), newAST);
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(EscCharASTBuilder newAST) throws BadTokenException {
    return this;
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new EqualsComparatorAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
