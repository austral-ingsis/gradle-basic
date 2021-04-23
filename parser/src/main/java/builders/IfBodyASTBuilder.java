package builders;

import ast.AST;
import ast.IfBodyAST;
import exceptions.ASTBuildException;
import token.Token;

public class IfBodyASTBuilder extends AbstractASTBuilder {

  public IfBodyASTBuilder(Token value) {
    super(value);
  }

  public IfBodyASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new IfBodyAST(getValue(), getLeftChild().buildAST(), getRightChild().buildAST());
  }
}
