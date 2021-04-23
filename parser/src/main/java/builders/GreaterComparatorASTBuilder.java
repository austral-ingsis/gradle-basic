package builders;

import ast.AST;
import ast.GreaterComparatorAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;

public class GreaterComparatorASTBuilder extends AbstractASTBuilder {

  public GreaterComparatorASTBuilder(Token value) {
    super(value);
  }

  public GreaterComparatorASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ASTBuilder addASTBuilder(NumberASTBuilder newAST) throws BadTokenException {
    return new GreaterComparatorASTBuilder(
        getValue(),
        getLeftChild(),
        getRightChild() == null ? newAST : getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(IdentifierASTBuilder newAST) throws BadTokenException {
    return new GreaterComparatorASTBuilder(
        getValue(),
        getLeftChild(),
        getRightChild() == null ? newAST : getRightChild().addASTBuilder(newAST));
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new GreaterComparatorAST(
        getValue(), getLeftChild().buildAST(), getRightChild().buildAST());
  }
}
