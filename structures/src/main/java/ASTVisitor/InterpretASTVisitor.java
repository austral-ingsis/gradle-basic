package ASTVisitor;

import ast.*;

public class InterpretASTVisitor implements ASTVisitor {
    @Override
    public ExecutionContext visitOperationAST(OperationAST operationAST, ExecutionContext executionContext) {
        int left = operationAST.getLeftChild().accept(this, executionContext).getResult();
        int right = operationAST.getRightChild().accept(this, executionContext).getResult();

        switch (operationAST.getValue().getType()) {
            case PLUS_OPERATOR:
                executionContext.sum(left, right);
                break;
            case MINUS_OPERATOR:
                executionContext.rest(left, right);
                break;
            case MULTIPLICATION_OPERATOR:
                executionContext.mult(left, right);
                break;
            case DIVISION_OPERATOR:
                executionContext.div(left, right);
        }
        return executionContext;
    }

    @Override
    public ExecutionContext visitLiteralAST(LiteralAST literalAST, ExecutionContext executionContext) {
        executionContext.setResult(Integer.parseInt(literalAST.getValue().getValue()));
        return executionContext;
    }

    @Override
    public ExecutionContext visitAssignationAST(AssignationAST assignationAST, ExecutionContext executionContext) {
        String left = assignationAST.getLeftChild().accept(this, executionContext).getTemporalIdentifier();
        int right = assignationAST.getRightChild().accept(this, executionContext).getResult();
        executionContext.addVariable(left, String.valueOf(right));
        return executionContext;
    }

    @Override
    public ExecutionContext visitDataTypeAST(DataTypeAST dataTypeAST, ExecutionContext executionContext) {
        return executionContext;
    }

    @Override
    public ExecutionContext visitIdentifierAST(IdentifierAST identifierAST, ExecutionContext executionContext) {
        String identifier = identifierAST.getValue().getValue();
        String possibleValue = executionContext.getVariableValue(identifier);
        if (possibleValue == null)
            executionContext.setTemporalIdentifier(identifier);
        else executionContext.setResult(Integer.parseInt(possibleValue));
        return executionContext;
    }

    @Override
    public ExecutionContext visitDeclarationAST(DeclarationAST declarationAST, ExecutionContext executionContext) {
        declarationAST.getLeftChild().accept(this, executionContext);
        return executionContext;
    }
}
