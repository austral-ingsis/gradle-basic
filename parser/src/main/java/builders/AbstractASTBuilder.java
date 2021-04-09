package builders;

import token.Token;

public abstract class AbstractASTBuilder implements ASTBuilder {
  private final Token value;
  private ASTBuilder leftChild;
  private ASTBuilder rightChild;

  public AbstractASTBuilder(Token value) {
    this.value = value;
  }

  public AbstractASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    this.value = value;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  @Override
  public Token getValue() {
    return value;
  }

  @Override
  public ASTBuilder getRightChild() {
    return rightChild;
  }

  @Override
  public ASTBuilder getLeftChild() {
    return leftChild;
  }
}
