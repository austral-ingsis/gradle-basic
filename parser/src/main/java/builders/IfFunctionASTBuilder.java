package builders;

import ast.AST;
import ast.IfFunctionAST;
import exceptions.ASTBuildException;
import token.Token;

public class IfFunctionASTBuilder extends AbstractASTBuilder {

  public IfFunctionASTBuilder(Token value) {
    super(value);
  }

  public IfFunctionASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new IfFunctionAST(getValue(), getLeftChild().buildAST(), getRightChild().buildAST());
  }
}
