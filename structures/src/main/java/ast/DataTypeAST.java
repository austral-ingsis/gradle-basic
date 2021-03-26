package ast;

import token.Token;

public class DataTypeAST extends AbstractAST{

    public DataTypeAST(Token value) {
        super(value);
    }

    public DataTypeAST(Token value, AST leftChild, AST rightChild) {
        super(value, leftChild, rightChild);
    }
}
