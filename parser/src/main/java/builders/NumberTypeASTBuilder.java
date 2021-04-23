package builders;

import ast.AST;
import ast.NumberTypeAST;
import exceptions.ASTBuildException;
import token.Token;

public class NumberTypeASTBuilder extends AbstractASTBuilder {

  public NumberTypeASTBuilder(Token value) {
    super(value);
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new NumberTypeAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
