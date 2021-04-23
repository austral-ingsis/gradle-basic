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
  public AST buildAST() throws ASTBuildException {
    return new NumberAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
