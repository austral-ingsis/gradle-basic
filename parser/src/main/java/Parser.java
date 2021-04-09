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
  private transient ASTBuilder currentASTBuilder;

  AST parse(List<Token> tokens) throws BadTokenException {
    this.tokens = tokens;
    currentASTBuilder = null;
    position = 0;
    while (!shouldFinish()) {
      advance();
      generateASTFromToken();
      position = position + 1;
    }
    advance();
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

  void generateASTFromToken() throws BadTokenException {
    try {
      switch (currentToken.getType()) { // pasar a handler
        case NUMBER, STRING -> generateLiteralAST();
        case PLUS_OPERATOR, MINUS_OPERATOR, MULTIPLICATION_OPERATOR, DIVISION_OPERATOR -> generateOperationAST();
        case EQUALS -> generateAssignationAST();
        case COLON -> generateDeclarationAST();
        case NUMBER_TYPE, STRING_TYPE -> generateDataTypeAST();
        case IDENTIFIER -> generateIdentifierAST();
      }
    } catch (BadTokenException e) {
      throw new BadTokenException(position);
    }
  }

  private void generateAssignationAST() throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First character cannot be an equals");
    }
    currentASTBuilder = currentASTBuilder.addASTBuilder(new AssignationASTBuilder(currentToken));
  }

  private void generateLiteralAST() throws BadTokenException {
    if (currentASTBuilder == null) {
      currentASTBuilder = new LiteralASTBuilder(currentToken);
    } else {
      currentASTBuilder = currentASTBuilder.addASTBuilder(new LiteralASTBuilder(currentToken));
    }
  }

  private void generateOperationAST() throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First token cannot be an operator");
    }
    currentASTBuilder = currentASTBuilder.addASTBuilder(new OperationASTBuilder(currentToken));
  }

  private void generateDeclarationAST() throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First token cannot be a colon");
    }
    currentASTBuilder = currentASTBuilder.addASTBuilder(new DeclarationASTBuilder(currentToken));
  }

  private void generateDataTypeAST() throws BadTokenException {
    if (currentASTBuilder == null) {
      throw new BadTokenException("First token cannot be a data type");
    }
    currentASTBuilder = currentASTBuilder.addASTBuilder(new DataTypeASTBuilder(currentToken));
  }

  private void generateIdentifierAST() throws BadTokenException {
    if (currentASTBuilder == null) {
      currentASTBuilder = new IdentifierASTBuilder(currentToken);
    } else {
      currentASTBuilder = currentASTBuilder.addASTBuilder(new IdentifierASTBuilder(currentToken));
    }
  }
}
