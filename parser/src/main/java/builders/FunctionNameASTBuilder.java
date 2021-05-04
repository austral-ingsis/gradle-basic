package builders;

import ast.AST;
import ast.FunctionNameAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;

public class FunctionNameASTBuilder implements ASTBuilder {
  private final Token value;
  private transient ASTBuilder child;

  public FunctionNameASTBuilder(Token value) {
    this.value = value;
  }

  public FunctionNameASTBuilder(Token value, ASTBuilder child) {
    this.value = value;
    this.child = child;
  }

  @Override
  public ASTBuilder addASTBuilder(NumberASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      return new FunctionNameASTBuilder(value, newAST);
    }
    return new FunctionNameASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(StringASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      return new FunctionNameASTBuilder(value, newAST);
    }
    return new FunctionNameASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(PlusASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new FunctionNameASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(MinusASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new FunctionNameASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(MultiplicationASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new FunctionNameASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(DivisionASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new FunctionNameASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(IdentifierASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      return new FunctionNameASTBuilder(value, newAST);
    }
    return new FunctionNameASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public Token getValue() {
    return value;
  }

  @Override
  public ASTBuilder getRightChild() {
    return null;
  }

  @Override
  public ASTBuilder getLeftChild() {
    return null;
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new FunctionNameAST(getValue(), child.buildAST());
  }
}
