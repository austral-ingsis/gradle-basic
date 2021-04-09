package builders;

import ast.*;
import exceptions.BadTokenException;
import token.Token;

public class AssignationASTBuilder extends AbstractASTBuilder {

  public AssignationASTBuilder(Token value) {
    super(value);
  }

  public AssignationASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ASTBuilder addASTBuilder(LiteralASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    return new AssignationASTBuilder(
        getValue(), getLeftChild(), rightChild == null ? newAST : rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(OperationASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    if (rightChild == null) throw new BadTokenException();
    return new AssignationASTBuilder(getValue(), getLeftChild(), rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(IdentifierASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    return new AssignationASTBuilder(
        getValue(), getLeftChild(), rightChild == null ? newAST : rightChild.addASTBuilder(newAST));
  }

  @Override
  public AST buildAST() {
    return new AssignationAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
