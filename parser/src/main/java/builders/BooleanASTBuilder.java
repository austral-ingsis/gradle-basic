package builders;

import ast.AST;
import ast.AssignationAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;

public class BooleanASTBuilder extends AbstractASTBuilder {

  public BooleanASTBuilder(Token value) {
    super(value);
  }

  public BooleanASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ASTBuilder addASTBuilder(EqualsComparatorASTBuilder newAST) throws BadTokenException {
    return new EqualsComparatorASTBuilder(
        newAST.getValue(),
        newAST.getLeftChild() == null ? this : newAST.getLeftChild().addASTBuilder(this),
        newAST.getRightChild());
  }

  @Override
  public ASTBuilder addASTBuilder(EscCharASTBuilder newAST) throws BadTokenException {
    return this;
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new AssignationAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
