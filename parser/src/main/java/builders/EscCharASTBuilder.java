package builders;

import ast.AST;
import ast.EscCharAST;
import exceptions.ASTBuildException;
import token.Token;

<<<<<<< Updated upstream
public class EscCharASTBuilder extends AbstractASTBuilder {
  public EscCharASTBuilder(Token value) {
    super(value);
  }

  public EscCharASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new EscCharAST(
        getValue(),
        getLeftChild() == null ? null : getLeftChild().buildAST(),
        getRightChild() == null ? null : getRightChild().buildAST());
  }
=======
public class EscCharASTBuilder extends AbstractASTBuilder{
    public EscCharASTBuilder(Token value) {
        super(value);
    }

    public EscCharASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
        super(value, leftChild, rightChild);
    }

    @Override
    public AST buildAST() throws ASTBuildException {
        return new EscCharAST(
                getValue(),
                getLeftChild() == null ? null : getLeftChild().buildAST(),
                getRightChild() == null ? null : getRightChild().buildAST());
    }
>>>>>>> Stashed changes
}
