package builders;

import ast.*;
import exceptions.BadTokenException;
import token.Token;

public class LiteralASTBuilder extends AbstractASTBuilder {

  public LiteralASTBuilder(Token value) {
    super(value);
  }

  @Override
  public ASTBuilder addASTBuilder(OperationASTBuilder newAST) throws BadTokenException {
    if (newAST.getLeftChild() != null) throw new BadTokenException();
    return new OperationASTBuilder(newAST.getValue(), this, newAST.getRightChild());
  }

  @Override
  public AST buildAST() {
    return new LiteralAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
