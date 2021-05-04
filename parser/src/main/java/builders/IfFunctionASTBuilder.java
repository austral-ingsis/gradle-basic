package builders;

import ast.AST;
import ast.IfFunctionAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;
import token.TokenType;

public class IfFunctionASTBuilder extends AbstractASTBuilder {

  public IfFunctionASTBuilder(Token value) {
    super(value);
  }

  public IfFunctionASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ASTBuilder addASTBuilder(NumberASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfFunctionASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(StringASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfFunctionASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(PlusASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfFunctionASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(MinusASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfFunctionASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(MultiplicationASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfFunctionASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(DivisionASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfFunctionASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(AssignationASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      throw new BadTokenException();
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(DeclarationASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      throw new BadTokenException();
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(NumberTypeASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      throw new BadTokenException();
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(StringTypeASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      throw new BadTokenException();
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(IdentifierASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfFunctionASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(IfFunctionASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      throw new BadTokenException();
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(BooleanASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfFunctionASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(BooleanTypeASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      throw new BadTokenException();
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(ElseBlockASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      throw new BadTokenException();
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(IfBlockASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      throw new BadTokenException();
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(EqualsComparatorASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfFunctionASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterComparatorASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfFunctionASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    if (getRightChild() == null) {
      return new IfFunctionASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(MinorComparatorASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfFunctionASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(MinorOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    if (getRightChild() == null) {
      return new IfFunctionASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(LeftKeyASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfFunctionASTBuilder(
          getValue(), getLeftChild(), new IfBodyASTBuilder(new Token(TokenType.IF_BODY, "")));
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(EscCharASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      throw new BadTokenException();
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(FunctionNameASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      throw new BadTokenException();
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(ConstantKeywordASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      throw new BadTokenException();
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(VariableKeywordASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      throw new BadTokenException();
    }
    return new IfFunctionASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new IfFunctionAST(getValue(), getLeftChild().buildAST(), getRightChild().buildAST());
  }
}
