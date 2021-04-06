package ast;

import exceptions.BadTokenException;
import token.Token;

public interface AST {
  Token getValue();

  AST getRightChild();

  AST getLeftChild();

  default AST addAST(LiteralAST newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default AST addAST(OperationAST newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default AST addAST(AssignationAST newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default AST addAST(DeclarationAST newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default AST addAST(DataTypeAST newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default AST addAST(IdentifierAST newAST) throws BadTokenException {
    throw new BadTokenException();
  }
}
