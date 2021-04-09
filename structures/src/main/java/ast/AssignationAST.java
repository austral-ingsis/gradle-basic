package ast;

import token.Token;

public class AssignationAST extends AbstractAST {

  public AssignationAST(Token value) {
    super(value);
  }

  public AssignationAST(Token value, AST leftChild, AST rightChild) {
    super(value, leftChild, rightChild);
  }
}
