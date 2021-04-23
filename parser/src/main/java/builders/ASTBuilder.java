package builders;

import ast.*;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;

public interface ASTBuilder {
  AST buildAST() throws ASTBuildException;

  Token getValue();

  ASTBuilder getRightChild();

  ASTBuilder getLeftChild();

  default ASTBuilder addASTBuilder(NumberASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(StringASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(PlusASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(MinusASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(MultiplicationASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(DivisionASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(AssignationASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(DeclarationASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(NumberTypeASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(StringTypeASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(IdentifierASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(IfFunctionASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(IfBodyASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(BooleanASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(BooleanTypeASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(ElseBlockASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(IfBlockASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(EqualsComparatorASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(GreaterComparatorASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(GreaterOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(MinorComparatorASTBuilder newAST) throws BadTokenException {
    throw new BadTokenException();
  }

  default ASTBuilder addASTBuilder(MinorOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    throw new BadTokenException();
  }
}
