package builders;

import ast.AST;
import ast.StringAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;

public class StringASTBuilder extends AbstractASTBuilder {
  public StringASTBuilder(Token value) {
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
  public ASTBuilder addASTBuilder(EscCharASTBuilder newAST) throws BadTokenException {
    return this;
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new StringAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
