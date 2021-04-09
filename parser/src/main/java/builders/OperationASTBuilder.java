package builders;

import ast.*;
import exceptions.BadTokenException;
import token.OperatorTypeComparator;
import token.Token;

public class OperationASTBuilder extends AbstractASTBuilder {
  private static final OperatorTypeComparator operatorTypeComparator = new OperatorTypeComparator();

  public OperationASTBuilder(Token value) {
    super(value);
  }

  public OperationASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ASTBuilder addASTBuilder(LiteralASTBuilder newAST) throws BadTokenException {
    return new OperationASTBuilder(
        getValue(),
        getLeftChild(),
        getRightChild() != null ? getRightChild().addASTBuilder(newAST) : newAST);
  }

  @Override
  public ASTBuilder addASTBuilder(OperationASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) throw new BadTokenException();
    if (operatorTypeComparator.compare(newAST.getValue().getType(), getValue().getType()) > 0) {
      return new OperationASTBuilder(
          getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
    }
    return new OperationASTBuilder(
        newAST.getValue(),
        newAST.getLeftChild() != null ? newAST.getLeftChild().addASTBuilder(this) : this,
        newAST.getRightChild());
  }

  @Override
  public ASTBuilder addASTBuilder(IdentifierASTBuilder newAST) throws BadTokenException {
    return new OperationASTBuilder(
        getValue(),
        getLeftChild(),
        getRightChild() != null ? getRightChild().addASTBuilder(newAST) : newAST);
  }

  @Override
  public AST buildAST() {
    return new OperationAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
