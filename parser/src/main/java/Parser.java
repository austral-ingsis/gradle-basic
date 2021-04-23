// PROGRAM ::= { STATEMENT_LIST }
// STATEMENT_LIST ::= [[ STATEMENT ; ]]*
// STATEMENT :: =    VARIABLE_KEYWORD IDENTIFIER: DATA_TYPE
//               |  IDENTIFIER = EXPRESSION
//               |  println EXPRESSION
// DATA_TYPE ::= number | string
// EXPRESSION ::=  IDENTIFIER | NUMERAL | STRING | ( EXPRESSION OPERATOR EXPRESSION )

// VARIABLE_KEYWORD ::= let
// IDENTIFIER ::=  LETTER [[ LETTER | DIGIT ]]*
// NUMERAL ::=  DIGIT [[ DIGIT ]]*
// OPERATOR ::= + | - | / | *
// LETTER ::= A | B | C | ... | Z
// DIGIT ::= 0 | 1 | ... | 9
// STRING ::= "[[ CHARACTER ]]*" | '[[ CHARACTER ]]*'

// http://people.cs.ksu.edu/~schmidt/300s05/Lectures/GrammarNotes/compiler.html

import ast.*;
import builders.*;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import java.util.List;
import token.Token;
import token.TokenType;

public class Parser {
  private transient List<Token> tokens;
  private transient int position;
  private transient Token currentToken;

  AST parse(List<Token> tokens) throws BadTokenException, ASTBuildException {
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
    if (currentToken.getType() != TokenType.ESC_CHAR)
      throw new BadTokenException("Last token should be ;");
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
      }
    } catch (BadTokenException e) {
      throw new BadTokenException(position);
    }

    return null;
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
      throw new BadTokenException("First token cannot be an operator");
    }
    return currentASTBuilder.addASTBuilder(new PlusASTBuilder(currentToken));
  }

  private ASTBuilder generateMinusAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First token cannot be an operator");
    }
    return currentASTBuilder.addASTBuilder(new MinusASTBuilder(currentToken));
  }

  private ASTBuilder generateMultiplicationAST(ASTBuilder currentASTBuilder)
      throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First token cannot be an operator");
    }
    return currentASTBuilder.addASTBuilder(new MultiplicationASTBuilder(currentToken));
  }

  private ASTBuilder generateDivisionAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First token cannot be an operator");
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
}
