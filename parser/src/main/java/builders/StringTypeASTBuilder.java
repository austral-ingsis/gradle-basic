package builders;

import ast.AST;
import ast.StringTypeAST;
import exceptions.ASTBuildException;
import token.Token;

public class StringTypeASTBuilder extends AbstractASTBuilder {

  public StringTypeASTBuilder(Token value) {
    super(value);
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new StringTypeAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
