package builders;

import ast.AST;
import ast.DataTypeAST;
import token.Token;

public class DataTypeASTBuilder extends AbstractASTBuilder {

  public DataTypeASTBuilder(Token value) {
    super(value);
  }

  @Override
  public AST buildAST() {
    return new DataTypeAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
