package builders;

import ast.AST;
import ast.MinorOrEqualsComparatorAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;

public class MinorOrEqualsComparatorASTBuilder extends AbstractASTBuilder {
  public MinorOrEqualsComparatorASTBuilder(Token value) {
    super(value);
  }

  public MinorOrEqualsComparatorASTBuilder(
      Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ASTBuilder addASTBuilder(NumberASTBuilder newAST) throws BadTokenException {
    return new MinorOrEqualsComparatorASTBuilder(
        getValue(),
        getLeftChild(),
        getRightChild() == null ? newAST : getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(IdentifierASTBuilder newAST) throws BadTokenException {
    return new MinorOrEqualsComparatorASTBuilder(
        getValue(),
        getLeftChild(),
        getRightChild() == null ? newAST : getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(PlusASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
<<<<<<< Updated upstream
    return new MinorOrEqualsComparatorASTBuilder(getValue(), getLeftChild(), newAST);
=======
    return new MinorOrEqualsComparatorASTBuilder(
            getValue(),
            getLeftChild(),
            newAST);
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(MinusASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
<<<<<<< Updated upstream
    return new MinorOrEqualsComparatorASTBuilder(getValue(), getLeftChild(), newAST);
=======
    return new MinorOrEqualsComparatorASTBuilder(
            getValue(),
            getLeftChild(),
            newAST);
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(MultiplicationASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
<<<<<<< Updated upstream
    return new MinorOrEqualsComparatorASTBuilder(getValue(), getLeftChild(), newAST);
=======
    return new MinorOrEqualsComparatorASTBuilder(
            getValue(),
            getLeftChild(),
            newAST);
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(DivisionASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
<<<<<<< Updated upstream
    return new MinorOrEqualsComparatorASTBuilder(getValue(), getLeftChild(), newAST);
=======
    return new MinorOrEqualsComparatorASTBuilder(
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
    return new MinorOrEqualsComparatorAST(
        getValue(), getLeftChild().buildAST(), getRightChild().buildAST());
  }
}
