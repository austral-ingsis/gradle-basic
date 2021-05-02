package builders;

import ast.AST;
import ast.LeftKeyAST;
import exceptions.ASTBuildException;
import token.Token;

public class LeftKeyASTBuilder extends AbstractASTBuilder {

  public LeftKeyASTBuilder(Token value) {
    super(value);
  }

  public LeftKeyASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new LeftKeyAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
