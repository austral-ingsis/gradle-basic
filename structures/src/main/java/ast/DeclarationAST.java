package ast;

import exceptions.BadTokenException;
import token.Token;

public class DeclarationAST extends AbstractAST{

    public DeclarationAST(Token value) {
        super(value);
    }

    public DeclarationAST(Token value, AST leftChild, AST rightChild) {
       super(value, leftChild, rightChild);
    }

    @Override
    public AST addAST(AssignationAST newAST) throws BadTokenException {
        if (getLeftChild() == null || getRightChild() == null || newAST.getLeftChild() != null) throw new BadTokenException();
        return new AssignationAST(newAST.getValue(), this, newAST.getRightChild());
    }

    @Override
    public AST addAST(DataTypeAST newAST) throws BadTokenException {
        if (getRightChild() != null) throw new BadTokenException();
        return new DeclarationAST(getValue(), getLeftChild(), newAST);
    }
}
