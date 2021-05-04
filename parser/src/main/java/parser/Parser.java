package parser;

import ast.*;
import builders.*;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import java.util.List;
import token.Token;

public class Parser {
  private transient List<Token> tokens;
  private transient int position;
  private transient Token currentToken;
  private static final String FIRST_TOKEN_OPERATOR_ERROR = "First token cannot be an operator";
  private static final String FIRST_TOKEN_COMPARATOR_ERROR = "First token cannot be a comparator";

  public AST parse(List<Token> tokens) throws BadTokenException, ASTBuildException {
    this.tokens = tokens;
    ASTBuilder currentASTBuilder = null;
    position = 0;
    while (!shouldFinish()) {
      advance();
      currentASTBuilder = generateASTFromToken(currentASTBuilder);
      position = position + 1;
    }
    advance();
    if (currentASTBuilder == null) return null;
    return currentASTBuilder.buildAST();
  }

  boolean shouldFinish() {
    return position == tokens.size() - 1;
  }

  void advance() {
    currentToken = tokens.get(position);
  }

  ASTBuilder generateASTFromToken(ASTBuilder currentASTBuilder) throws BadTokenException {
    try {
      switch (currentToken.getType()) {
        case NUMBER -> {
          return generateNumberAST(currentASTBuilder);
        }
        case STRING -> {
          return generateStringAST(currentASTBuilder);
        }
        case PLUS_OPERATOR -> {
          return generatePlusAST(currentASTBuilder);
        }
        case MINUS_OPERATOR -> {
          return generateMinusAST(currentASTBuilder);
        }
        case MULTIPLICATION_OPERATOR -> {
          return generateMultiplicationAST(currentASTBuilder);
        }
        case DIVISION_OPERATOR -> {
          return generateDivisionAST(currentASTBuilder);
        }
        case EQUALS -> {
          return generateAssignationAST(currentASTBuilder);
        }
        case COLON -> {
          return generateDeclarationAST(currentASTBuilder);
        }
        case NUMBER_TYPE -> {
          return generateNumberTypeAST(currentASTBuilder);
        }
        case STRING_TYPE -> {
          return generateStringTypeAST(currentASTBuilder);
        }
        case IDENTIFIER -> {
          return generateIdentifierAST(currentASTBuilder);
        }
        case IF_FUNCTION -> {
          return generateIfFunctionAST(currentASTBuilder);
        }
        case BOOLEAN -> {
          return generateBooleanAST(currentASTBuilder);
        }
        case BOOLEAN_TYPE -> {
          return generateBooleanTypeAST(currentASTBuilder);
        }
        case ELSE_FUNCTION -> {
          return generateElseBlockAST(currentASTBuilder);
        }
        case EQUALS_COMPARATOR -> {
          return generateEqualsComparatorAST(currentASTBuilder);
        }
        case GREATER_COMPARATOR -> {
          return generateGreaterComparatorAST(currentASTBuilder);
        }
        case GREATER_OR_EQUALS_COMPARATOR -> {
          return generateGreaterOrEqualsComparatorAST(currentASTBuilder);
        }
        case MINOR_COMPARATOR -> {
          return generateMinorComparatorAST(currentASTBuilder);
        }
        case MINOR_OR_EQUALS_COMPARATOR -> {
          return generateMinorOrEqualsComparatorAST(currentASTBuilder);
        }
        case LEFT_KEY -> {
          return generateLeftKeyAST(currentASTBuilder);
        }
        case ESC_CHAR -> {
          return generateEscCharAST(currentASTBuilder);
        }
        case FUNCTION_NAME -> {
          return generateFunctionNameAST(currentASTBuilder);
        }
        case CONSTANT_KEYWORD -> {
          return generateConstantKeywordAST(currentASTBuilder);
        }
        case VARIABLE_KEYWORD -> {
          return generateVariableKeywordAST(currentASTBuilder);
        }
      }
    } catch (BadTokenException e) {
      throw new BadTokenException(position);
    }

    return currentASTBuilder;
  }

  private ASTBuilder generateAssignationAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First character cannot be an equals");
    }
    return currentASTBuilder.addASTBuilder(new AssignationASTBuilder(currentToken));
  }

  private ASTBuilder generateNumberAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      return new NumberASTBuilder(currentToken);
    } else {
      return currentASTBuilder.addASTBuilder(new NumberASTBuilder(currentToken));
    }
  }

  private ASTBuilder generateStringAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      return new StringASTBuilder(currentToken);
    } else {
      return currentASTBuilder.addASTBuilder(new StringASTBuilder(currentToken));
    }
  }

  private ASTBuilder generatePlusAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException(FIRST_TOKEN_OPERATOR_ERROR);
    }
    return currentASTBuilder.addASTBuilder(new PlusASTBuilder(currentToken));
  }

  private ASTBuilder generateMinusAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException(FIRST_TOKEN_OPERATOR_ERROR);
    }
    return currentASTBuilder.addASTBuilder(new MinusASTBuilder(currentToken));
  }

  private ASTBuilder generateMultiplicationAST(ASTBuilder currentASTBuilder)
      throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException(FIRST_TOKEN_OPERATOR_ERROR);
    }
    return currentASTBuilder.addASTBuilder(new MultiplicationASTBuilder(currentToken));
  }

  private ASTBuilder generateDivisionAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException(FIRST_TOKEN_OPERATOR_ERROR);
    }
    return currentASTBuilder.addASTBuilder(new DivisionASTBuilder(currentToken));
  }

  private ASTBuilder generateDeclarationAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First token cannot be a colon");
    }
    return currentASTBuilder.addASTBuilder(new DeclarationASTBuilder(currentToken));
  }

  private ASTBuilder generateNumberTypeAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First token cannot be a data type");
    }
    return currentASTBuilder.addASTBuilder(new NumberTypeASTBuilder(currentToken));
  }

  private ASTBuilder generateStringTypeAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First token cannot be a data type");
    }
    return currentASTBuilder.addASTBuilder(new StringTypeASTBuilder(currentToken));
  }

  private ASTBuilder generateIdentifierAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      return new IdentifierASTBuilder(currentToken);
    } else {
      return currentASTBuilder.addASTBuilder(new IdentifierASTBuilder(currentToken));
    }
  }

  private ASTBuilder generateIfFunctionAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      return new IfFunctionASTBuilder(currentToken);
    } else {
      return currentASTBuilder.addASTBuilder(new IfFunctionASTBuilder(currentToken));
    }
  }

  private ASTBuilder generateBooleanAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First token cannot be a boolean");
    } else {
      return currentASTBuilder.addASTBuilder(new BooleanASTBuilder(currentToken));
    }
  }

  private ASTBuilder generateBooleanTypeAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First token cannot be a boolean type");
    } else {
      return currentASTBuilder.addASTBuilder(new BooleanTypeASTBuilder(currentToken));
    }
  }

  private ASTBuilder generateElseBlockAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First token cannot be an else");
    } else {
      return currentASTBuilder.addASTBuilder(new ElseBlockASTBuilder(currentToken));
    }
  }

  private ASTBuilder generateEqualsComparatorAST(ASTBuilder currentASTBuilder)
      throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException(FIRST_TOKEN_COMPARATOR_ERROR);
    } else {
      return currentASTBuilder.addASTBuilder(new EqualsComparatorASTBuilder(currentToken));
    }
  }

  private ASTBuilder generateGreaterComparatorAST(ASTBuilder currentASTBuilder)
      throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException(FIRST_TOKEN_COMPARATOR_ERROR);
    } else {
      return currentASTBuilder.addASTBuilder(new GreaterComparatorASTBuilder(currentToken));
    }
  }

  private ASTBuilder generateGreaterOrEqualsComparatorAST(ASTBuilder currentASTBuilder)
      throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException(FIRST_TOKEN_COMPARATOR_ERROR);
    } else {
      return currentASTBuilder.addASTBuilder(new GreaterOrEqualsComparatorASTBuilder(currentToken));
    }
  }

  private ASTBuilder generateMinorComparatorAST(ASTBuilder currentASTBuilder)
      throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException(FIRST_TOKEN_COMPARATOR_ERROR);
    } else {
      return currentASTBuilder.addASTBuilder(new MinorComparatorASTBuilder(currentToken));
    }
  }

  private ASTBuilder generateMinorOrEqualsComparatorAST(ASTBuilder currentASTBuilder)
      throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException(FIRST_TOKEN_COMPARATOR_ERROR);
    } else {
      return currentASTBuilder.addASTBuilder(new MinorOrEqualsComparatorASTBuilder(currentToken));
    }
  }

  private ASTBuilder generateLeftKeyAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First token cannot be a left key");
    } else {
      return currentASTBuilder.addASTBuilder(new LeftKeyASTBuilder(currentToken));
    }
  }

  private ASTBuilder generateEscCharAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First token cannot be an escape character");
    } else {
      return currentASTBuilder.addASTBuilder(new EscCharASTBuilder(currentToken));
    }
  }

  private ASTBuilder generateConstantKeywordAST(ASTBuilder currentASTBuilder)
      throws BadTokenException {
    if (currentASTBuilder == null) {
      return new ConstantKeywordASTBuilder(currentToken);
    } else {
      return currentASTBuilder.addASTBuilder(new ConstantKeywordASTBuilder(currentToken));
    }
  }

  private ASTBuilder generateVariableKeywordAST(ASTBuilder currentASTBuilder)
      throws BadTokenException {
    if (currentASTBuilder == null) {
      return new VariableKeywordASTBuilder(currentToken);
    } else {
      return currentASTBuilder.addASTBuilder(new VariableKeywordASTBuilder(currentToken));
    }
  }

  private ASTBuilder generateFunctionNameAST(ASTBuilder currentASTBuilder)
      throws BadTokenException {
    if (currentASTBuilder == null) {
      return new FunctionNameASTBuilder(currentToken);
    } else {
      return currentASTBuilder.addASTBuilder(new FunctionNameASTBuilder(currentToken));
    }
  }
}
