package builders;

import ast.AST;
import ast.VariableKeywordAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;

public class VariableKeywordASTBuilder implements ASTBuilder {
  private final Token value;
  private transient ASTBuilder child;

  public VariableKeywordASTBuilder(Token value) {
    this.value = value;
  }

  public VariableKeywordASTBuilder(Token value, ASTBuilder child) {
    this.value = value;
    this.child = child;
  }

  @Override
  public ASTBuilder addASTBuilder(NumberASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(StringASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(PlusASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(MinusASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(MultiplicationASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(DivisionASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(AssignationASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(DeclarationASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(NumberTypeASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(StringTypeASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(IdentifierASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      return new VariableKeywordASTBuilder(value, newAST);
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(IfFunctionASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(IfBodyASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(BooleanASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(BooleanTypeASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(ElseBlockASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(IfBlockASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(EqualsComparatorASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterComparatorASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(MinorComparatorASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(MinorOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(LeftKeyASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(EscCharASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(FunctionNameASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(ConstantKeywordASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(VariableKeywordASTBuilder newAST) throws BadTokenException {
    if (child == null) {
      throw new BadTokenException();
    }
    return new VariableKeywordASTBuilder(value, child.addASTBuilder(newAST));
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
    return new VariableKeywordAST(getValue(), child.buildAST());
  }
}
