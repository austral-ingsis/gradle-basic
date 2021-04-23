package builders;

import ast.AST;
import ast.AssignationAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;

public class StringAssignationASTBuilder extends AbstractASTBuilder {
  private transient boolean valid;

  public StringAssignationASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
    valid = false;
  }

  @Override
  public ASTBuilder addASTBuilder(NumberASTBuilder newAST) throws BadTokenException {
    ASTBuilder rightChild = getRightChild();
    return new AssignationASTBuilder(
        getValue(), getLeftChild(), rightChild == null ? newAST : rightChild.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(StringASTBuilder newAST) throws BadTokenException {
    valid = true;
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
  public AST buildAST() throws ASTBuildException {
    if (!valid) throw new ASTBuildException("Should be associated to number");
    return new AssignationAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
}
