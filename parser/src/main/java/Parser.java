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
import exceptions.BadTokenException;
import java.util.List;
import token.Token;
import token.TokenType;

public class Parser {
  private transient List<Token> tokens;
  private transient int position;
  private transient Token currentToken;

  AST parse(List<Token> tokens) throws BadTokenException {
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
        case NUMBER, STRING -> {
          return generateLiteralAST(currentASTBuilder);
        }
        case PLUS_OPERATOR, MINUS_OPERATOR, MULTIPLICATION_OPERATOR, DIVISION_OPERATOR -> {
          return generateOperationAST(currentASTBuilder);
        }
        case EQUALS -> {
          return generateAssignationAST(currentASTBuilder);
        }
        case COLON -> {
          return generateDeclarationAST(currentASTBuilder);
        }
        case NUMBER_TYPE, STRING_TYPE -> {
          return generateDataTypeAST(currentASTBuilder);
        }
        case IDENTIFIER -> {
          return generateIdentifierAST(currentASTBuilder);
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

  private ASTBuilder generateLiteralAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      return new LiteralASTBuilder(currentToken);
    } else {
      return currentASTBuilder.addASTBuilder(new LiteralASTBuilder(currentToken));
    }
  }

  private ASTBuilder generateOperationAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First token cannot be an operator");
    }
    return currentASTBuilder.addASTBuilder(new OperationASTBuilder(currentToken));
  }

  private ASTBuilder generateDeclarationAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First token cannot be a colon");
    }
    return currentASTBuilder.addASTBuilder(new DeclarationASTBuilder(currentToken));
  }

  private ASTBuilder generateDataTypeAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First token cannot be a data type");
    }
    return currentASTBuilder.addASTBuilder(new DataTypeASTBuilder(currentToken));
  }

  private ASTBuilder generateIdentifierAST(ASTBuilder currentASTBuilder) throws BadTokenException {
    if (currentASTBuilder == null) {
      return new IdentifierASTBuilder(currentToken);
    } else {
      return currentASTBuilder.addASTBuilder(new IdentifierASTBuilder(currentToken));
    }
  }
}
