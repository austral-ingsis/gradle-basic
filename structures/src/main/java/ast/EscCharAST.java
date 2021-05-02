package ast;

import ASTVisitor.ASTVisitor;
import token.Token;

<<<<<<< Updated upstream
public class EscCharAST extends AbstractAST {
  public EscCharAST(Token value) {
    super(value);
  }

  public EscCharAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public void accept(ASTVisitor visitor) {}
=======
public class EscCharAST extends AbstractAST{
    public EscCharAST(Token value) {
        super(value);
    }

    public EscCharAST(Token value, AST leftChild, AST rightChild) {
        super(value, leftChild, rightChild);
    }

    @Override
    public void accept(ASTVisitor visitor) {
    }
>>>>>>> Stashed changes
}
