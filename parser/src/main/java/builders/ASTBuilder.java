package builders;

import ast.*;
import exceptions.BadTokenException;
import token.Token;

public interface ASTBuilder {
  AST buildAST();

  Token getValue();

  ASTBuilder getRightChild();

  ASTBuilder getLeftChild();

  default ASTBuilder addASTBuilder(LiteralASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(OperationASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(AssignationASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(DeclarationASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(DataTypeASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(IdentifierASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }
}
