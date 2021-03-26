package ast;

import exceptions.BadTokenException;
import token.OperatorTypeComparator;
import token.Token;

public class OperationAST extends AbstractAST{
   private static OperatorTypeComparator operatorTypeComparator = new OperatorTypeComparator();

    public OperationAST(Token value) {
        super(value);
    }

    public OperationAST(Token value, AST leftChild, AST rightChild) {
        super(value, leftChild, rightChild);
    }

    @Override
    public AST addAST(LiteralAST newAST) throws BadTokenException {
        return new OperationAST(getValue(), getLeftChild(), getRightChild() != null ? getRightChild().addAST(newAST) : newAST);
    }

    @Override
    public AST addAST(OperationAST newAST) throws BadTokenException {
        if (getRightChild() == null) throw new BadTokenException();
        if (operatorTypeComparator.compare(newAST.getValue().getType(), getValue().getType()) > 0) {
            return new OperationAST(getValue(), getLeftChild(), getRightChild().addAST(newAST));
        }
        return new OperationAST(newAST.getValue(), newAST.getLeftChild() != null ? newAST.getLeftChild().addAST(this) : this, newAST.getRightChild());
    }

    @Override
    public AST addAST(IdentifierAST newAST) throws BadTokenException {
        return new OperationAST(getValue(), getLeftChild(), getRightChild() != null ? getRightChild().addAST(newAST) : newAST);
    }

}
