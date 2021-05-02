package builders;

import ast.AST;
import ast.IfBodyAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import token.Token;
import token.TokenType;

public class IfBodyASTBuilder extends AbstractASTBuilder {

  public IfBodyASTBuilder(Token value) {
    super(value, new IfBlockASTBuilder(new Token(TokenType.IF_BLOCK, "")), null);
  }

  public IfBodyASTBuilder(Token value, ASTBuilder leftChild, ASTBuilder rightChild) {
    super(value, leftChild, rightChild);
  }

  @Override
  public ASTBuilder addASTBuilder(NumberASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(StringASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(PlusASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(MinusASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(MultiplicationASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(DivisionASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(AssignationASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(DeclarationASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(NumberTypeASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(StringTypeASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(IdentifierASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(IfFunctionASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(BooleanASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(BooleanTypeASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(ElseBlockASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
<<<<<<< Updated upstream
      return new IfBodyASTBuilder(getValue(), getLeftChild(), newAST);
    }
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild(),
          newAST);
    }
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(IfBlockASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(EqualsComparatorASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterComparatorASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(MinorComparatorASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(MinorOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
<<<<<<< Updated upstream
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(EscCharASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(LeftKeyASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
=======
>>>>>>> Stashed changes
          getValue(),
          getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
          getRightChild());
    }
<<<<<<< Updated upstream
    return new IfBodyASTBuilder(getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
=======
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public ASTBuilder addASTBuilder(EscCharASTBuilder newAST)
      throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
              getValue(),
              getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
              getRightChild());
    }
    return new IfBodyASTBuilder(
        getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
>>>>>>> Stashed changes
  }

  @Override
  public ASTBuilder addASTBuilder(LeftKeyASTBuilder newAST) throws BadTokenException {
    if (getRightChild() == null) {
      return new IfBodyASTBuilder(
              getValue(),
              getLeftChild() == null ? newAST : getLeftChild().addASTBuilder(newAST),
              getRightChild());
    }
    return new IfBodyASTBuilder(
            getValue(), getLeftChild(), getRightChild().addASTBuilder(newAST));
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new IfBodyAST(getValue(), getLeftChild().buildAST(), getRightChild().buildAST());
  }
}
