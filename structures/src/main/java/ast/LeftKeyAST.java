package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

<<<<<<< Updated upstream
public class LeftKeyAST extends AbstractAST {
  public LeftKeyAST(Token value) {
    super(value);
  }

  public LeftKeyAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {}
=======
public class LeftKeyAST extends AbstractAST{
    public LeftKeyAST(Token value) {
        super(value);
    }

    public LeftKeyAST(Token value, AST leftChild, AST rightChild) {
        super(value, leftChild, rightChild);
    }

    @Override
    public void accept(ASTVisitor visitor) {
    }
>>>>>>> Stashed changes
}
