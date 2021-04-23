package builders;

import ast.AST;
import ast.MultiplicationAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;

public class MultiplicationASTBuilder extends AbstractASTBuilder {
  public MultiplicationASTBuilder(Token value) {
    super(value);
  }

  public MultiplicationASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ASTBuilder addASTBuilder(NumberASTBuilder newAST) throws BadTokenException {
    return new MultiplicationASTBuilder(
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
    return new MultiplicationASTBuilder(
        newAST.getValue(),
        newAST.getLeftChild() != null ? newAST.getLeftChild().addASTBuilder(this) : this,
        newAST.getRightChild());
  }

  @Override
  public ASTBuilder addASTBuilder(DivisionASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
    return new DivisionASTBuilder(
        newAST.getValue(),
        newAST.getLeftChild() != null ? newAST.getLeftChild().addASTBuilder(this) : this,
        newAST.getRightChild());
  }

  @Override
  public ASTBuilder addASTBuilder(IdentifierASTBuilder newAST) throws BadTokenException {
    return new MultiplicationASTBuilder(
        getValue(),
        getLeftChild(),
        getRightChild() != null ? getRightChild().addASTBuilder(newAST) : newAST);
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new MultiplicationAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
