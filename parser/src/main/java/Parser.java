//PROGRAM ::= { STATEMENT_LIST }
//STATEMENT_LIST ::= [[ STATEMENT ; ]]*
//STATEMENT :: =    VARIABLE_KEYWORD IDENTIFIER: DATA_TYPE
//               |  IDENTIFIER = EXPRESSION
//               |  println EXPRESSION
//DATA_TYPE ::= number | string
//EXPRESSION ::=  IDENTIFIER | NUMERAL | STRING | ( EXPRESSION OPERATOR EXPRESSION )

//VARIABLE_KEYWORD ::= let
//IDENTIFIER ::=  LETTER [[ LETTER | DIGIT ]]*
//NUMERAL ::=  DIGIT [[ DIGIT ]]*
//OPERATOR ::= + | - | / | *
//LETTER ::= A | B | C | ... | Z
//DIGIT ::= 0 | 1 | ... | 9
//STRING ::= "[[ CHARACTER ]]*" | '[[ CHARACTER ]]*'

//http://people.cs.ksu.edu/~schmidt/300s05/Lectures/GrammarNotes/compiler.html

import ast.*;
import exceptions.BadTokenException;
import token.Token;

import java.util.List;


public class Parser {
    private List<Token> tokens;
    private int position;
    private Token currentToken;
    private AST result;

    AST parse(List<Token> tokens) throws BadTokenException {
        this.tokens = tokens;
        result = null;
        position = -1;
        advance();
        while (currentToken != null) {
            generateASTFromToken();
            advance();
        }
        return result;
    }

    void advance() {
        if (position < tokens.size() - 1) {
            currentToken = tokens.get(++position);
        } else currentToken = null;
    }

    void generateASTFromToken() throws BadTokenException {
        try {
            switch (currentToken.getType()) {
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
        if (result == null) {
            throw new BadTokenException("First character cannot be an equals");
        }
        result = result.addAST(new AssignationAST(currentToken));
    }

    private void generateLiteralAST() throws BadTokenException {
        if (result == null) {
            result = new LiteralAST(currentToken);
        } else {
            result = result.addAST(new LiteralAST(currentToken));
        }
    }

    private void generateOperationAST() throws BadTokenException {
        if (result == null) {
            throw new BadTokenException("First token cannot be an operator");
        }
        result = result.addAST(new OperationAST(currentToken));
    }

    private void generateDeclarationAST() throws BadTokenException {
        if (result == null) {
            throw new BadTokenException("First token cannot be a colon");
        }
        result = result.addAST(new DeclarationAST(currentToken));
    }

    private void generateDataTypeAST() throws BadTokenException {
        if (result == null) {
            throw new BadTokenException("First token cannot be a data type");
        }
        result = result.addAST(new DataTypeAST(currentToken));
    }

    private void generateIdentifierAST() throws BadTokenException {
        if (result == null) {
            result = new IdentifierAST(currentToken);
        } else {
            result = result.addAST(new IdentifierAST(currentToken));
        }
    }
}
