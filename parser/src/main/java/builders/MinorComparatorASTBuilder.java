package builders;

import ast.AST;
import ast.MinorComparatorAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;

public class MinorComparatorASTBuilder extends AbstractASTBuilder {
  public MinorComparatorASTBuilder(Token value) {
    super(value);
  }

  public MinorComparatorASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ASTBuilder addASTBuilder(NumberASTBuilder newAST) throws BadTokenException {
    return new MinorComparatorASTBuilder(
        getValue(),
        getLeftChild(),
        getRightChild() == null ? newAST : getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(IdentifierASTBuilder newAST) throws BadTokenException {
    return new MinorComparatorASTBuilder(
        getValue(),
        getLeftChild(),
        getRightChild() == null ? newAST : getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(PlusASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
<<<<<<< Updated upstream
    return new MinorComparatorASTBuilder(getValue(), getLeftChild(), newAST);
=======
    return new MinorComparatorASTBuilder(
            getValue(),
            getLeftChild(),
            newAST);
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(MinusASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
<<<<<<< Updated upstream
    return new MinorComparatorASTBuilder(getValue(), getLeftChild(), newAST);
=======
    return new MinorComparatorASTBuilder(
            getValue(),
            getLeftChild(),
            newAST);
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(MultiplicationASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
<<<<<<< Updated upstream
    return new MinorComparatorASTBuilder(getValue(), getLeftChild(), newAST);
=======
    return new MinorComparatorASTBuilder(
            getValue(),
            getLeftChild(),
            newAST);
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(DivisionASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
<<<<<<< Updated upstream
    return new MinorComparatorASTBuilder(getValue(), getLeftChild(), newAST);
=======
    return new MinorComparatorASTBuilder(
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
    return new MinorComparatorAST(
        getValue(), getLeftChild().buildAST(), getRightChild().buildAST());
  }
}
