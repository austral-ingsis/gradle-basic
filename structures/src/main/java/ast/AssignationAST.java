package ast;

import exceptions.BadTokenException;
import token.Token;

public class AssignationAST extends AbstractAST{

    public AssignationAST(Token value) {
        super(value);
    }

    public AssignationAST(Token value, AST leftChild, AST rightChild) {
        super(value, leftChild, rightChild);
    }

    @Override
    public AST addAST(LiteralAST newAST) throws BadTokenException {
        AST rightChild = getRightChild();
        return new AssignationAST(getValue(), getLeftChild(), rightChild == null ? newAST : rightChild.addAST(newAST));
    }

    @Override
    public AST addAST(OperationAST newAST) throws BadTokenException {
        AST rightChild = getRightChild();
        if (rightChild == null) throw new BadTokenException();
        return new AssignationAST(getValue(), getLeftChild(), rightChild.addAST(newAST));
    }

    @Override
    public AST addAST(IdentifierAST newAST) throws BadTokenException {
        AST rightChild = getRightChild();
        return new AssignationAST(getValue(), getLeftChild(), rightChild == null ? newAST : rightChild.addAST(newAST));
    }
}
