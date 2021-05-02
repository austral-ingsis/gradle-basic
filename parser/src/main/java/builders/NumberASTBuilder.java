package builders;

import ast.AST;
import ast.NumberAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;

public class NumberASTBuilder extends AbstractASTBuilder {
  public NumberASTBuilder(Token value) {
    super(value);
  }

  @Override
  public ASTBuilder addASTBuilder(PlusASTBuilder newAST) throws BadTokenException {
    if (newAST.getLeftChild() != null) throw new BadTokenException();
    return new PlusASTBuilder(newAST.getValue(), this, newAST.getRightChild());
  }

  @Override
  public ASTBuilder addASTBuilder(MinusASTBuilder newAST) throws BadTokenException {
    if (newAST.getLeftChild() != null) throw new BadTokenException();
    return new MinusASTBuilder(newAST.getValue(), this, newAST.getRightChild());
  }

  @Override
  public ASTBuilder addASTBuilder(MultiplicationASTBuilder newAST) throws BadTokenException {
    if (newAST.getLeftChild() != null) throw new BadTokenException();
    return new MultiplicationASTBuilder(newAST.getValue(), this, newAST.getRightChild());
  }

  @Override
  public ASTBuilder addASTBuilder(DivisionASTBuilder newAST) throws BadTokenException {
    if (newAST.getLeftChild() != null) throw new BadTokenException();
    return new DivisionASTBuilder(newAST.getValue(), this, newAST.getRightChild());
  }

  @Override
  public ASTBuilder addASTBuilder(EqualsComparatorASTBuilder newAST) throws BadTokenException {
    return new EqualsComparatorASTBuilder(
<<<<<<< Updated upstream
        newAST.getValue(),
        newAST.getLeftChild() == null ? this : newAST.getLeftChild().addASTBuilder(this),
        newAST.getRightChild());
=======
            newAST.getValue(),
            newAST.getLeftChild() == null ? this : newAST.getLeftChild().addASTBuilder(this), newAST.getRightChild());
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterComparatorASTBuilder newAST) throws BadTokenException {
    return new GreaterComparatorASTBuilder(
<<<<<<< Updated upstream
        newAST.getValue(),
        newAST.getLeftChild() == null ? this : newAST.getLeftChild().addASTBuilder(this),
        newAST.getRightChild());
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    return new GreaterOrEqualsComparatorASTBuilder(
        newAST.getValue(),
        newAST.getLeftChild() == null ? this : newAST.getLeftChild().addASTBuilder(this),
        newAST.getRightChild());
=======
            newAST.getValue(),
            newAST.getLeftChild() == null ? this : newAST.getLeftChild().addASTBuilder(this), newAST.getRightChild());
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterOrEqualsComparatorASTBuilder newAST) throws BadTokenException {
    return new GreaterOrEqualsComparatorASTBuilder(
            newAST.getValue(),
            newAST.getLeftChild() == null ? this : newAST.getLeftChild().addASTBuilder(this), newAST.getRightChild());
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(MinorComparatorASTBuilder newAST) throws BadTokenException {
    return new MinorComparatorASTBuilder(
<<<<<<< Updated upstream
        newAST.getValue(),
        newAST.getLeftChild() == null ? this : newAST.getLeftChild().addASTBuilder(this),
        newAST.getRightChild());
  }

  @Override
  public ASTBuilder addASTBuilder(MinorOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    return new MinorOrEqualsComparatorASTBuilder(
        newAST.getValue(),
        newAST.getLeftChild() == null ? this : newAST.getLeftChild().addASTBuilder(this),
        newAST.getRightChild());
=======
            newAST.getValue(),
            newAST.getLeftChild() == null ? this : newAST.getLeftChild().addASTBuilder(this), newAST.getRightChild());
  }

  @Override
  public ASTBuilder addASTBuilder(MinorOrEqualsComparatorASTBuilder newAST) throws BadTokenException {
    return new MinorOrEqualsComparatorASTBuilder(
            newAST.getValue(),
            newAST.getLeftChild() == null ? this : newAST.getLeftChild().addASTBuilder(this), newAST.getRightChild());
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(EscCharASTBuilder newAST) throws BadTokenException {
    return this;
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new NumberAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
