package builders;

import ast.AST;
import ast.MinusAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;

public class MinusASTBuilder extends AbstractASTBuilder {
  public MinusASTBuilder(Token value) {
    super(value);
  }

  public MinusASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ASTBuilder addASTBuilder(NumberASTBuilder newAST) throws BadTokenException {
    return new MinusASTBuilder(
        getValue(),
        getLeftChild(),
        getRightChild() != null ? getRightChild().addASTBuilder(newAST) : newAST);
  }

  @Override
  public ASTBuilder addASTBuilder(PlusASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
    return new PlusASTBuilder(
        newAST.getValue(),
        newAST.getLeftChild() != null ? newAST.getLeftChild().addASTBuilder(this) : this,
        newAST.getRightChild());
  }

  @Override
  public ASTBuilder addASTBuilder(MinusASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
    return new MinusASTBuilder(
        newAST.getValue(),
        newAST.getLeftChild() != null ? newAST.getLeftChild().addASTBuilder(this) : this,
        newAST.getRightChild());
  }

  @Override
  public ASTBuilder addASTBuilder(MultiplicationASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
    return new MinusASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(DivisionASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
    return new MinusASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(IdentifierASTBuilder newAST) throws BadTokenException {
    return new MinusASTBuilder(
        getValue(),
        getLeftChild(),
        getRightChild() != null ? getRightChild().addASTBuilder(newAST) : newAST);
  }

  @Override
  public ASTBuilder addASTBuilder(EscCharASTBuilder newAST) throws BadTokenException {
    return this;
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new MinusAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
