package builders;

import ast.AST;
import ast.BooleanTypeAST;
import exceptions.ASTBuildException;
import token.Token;

public class BooleanTypeASTBuilder extends AbstractASTBuilder {

  public BooleanTypeASTBuilder(Token value) {
    super(value);
  }

  public BooleanTypeASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new BooleanTypeAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
