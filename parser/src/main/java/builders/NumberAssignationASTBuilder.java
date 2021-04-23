package builders;

import ast.AST;
import ast.AssignationAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;

public class NumberAssignationASTBuilder extends AbstractASTBuilder {

  public NumberAssignationASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ASTBuilder addASTBuilder(NumberASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    return new AssignationASTBuilder(
        getValue(), getLeftChild(), rightChild == null ? newAST : rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(PlusASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    if (rightChild == null) throw new BadTokenException();
    return new AssignationASTBuilder(getValue(), getLeftChild(), rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(MinusASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    if (rightChild == null) throw new BadTokenException();
    return new AssignationASTBuilder(getValue(), getLeftChild(), rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(MultiplicationASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    if (rightChild == null) throw new BadTokenException();
    return new AssignationASTBuilder(getValue(), getLeftChild(), rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(DivisionASTBuilder newAST) throws BadTokenException {
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
  public ASTBuilder addASTBuilder(EscCharASTBuilder newAST) throws BadTokenException {
    return this;
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new AssignationAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
