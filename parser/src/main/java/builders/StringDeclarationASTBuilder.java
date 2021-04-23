package builders;

import ast.AST;
import ast.DeclarationAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;

public class StringDeclarationASTBuilder extends AbstractASTBuilder {
  public StringDeclarationASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ASTBuilder addASTBuilder(AssignationASTBuilder newAST) throws BadTokenException {
    if (getLeftChild() == null || getRightChild() == null || newAST.getLeftChild() != null)
      throw new BadTokenException();
    return new StringAssignationASTBuilder(newAST.getValue(), this, newAST.getRightChild());
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new DeclarationAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }

  @Override
  public ASTBuilder addASTBuilder(EscCharASTBuilder newAST) throws BadTokenException {
    return this;
  }
}
