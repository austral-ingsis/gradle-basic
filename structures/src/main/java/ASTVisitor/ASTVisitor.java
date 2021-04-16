package ASTVisitor;

import ast.*;

public interface ASTVisitor {
    ExecutionContext visitOperationAST(OperationAST operationAST, ExecutionContext executionContext);
    ExecutionContext visitLiteralAST(LiteralAST literalAST, ExecutionContext executionContext);
    ExecutionContext visitAssignationAST(AssignationAST assignationAST, ExecutionContext executionContext);
    ExecutionContext visitDataTypeAST(DataTypeAST dataTypeAST, ExecutionContext executionContext);
    ExecutionContext visitIdentifierAST(IdentifierAST identifierAST, ExecutionContext executionContext);
    ExecutionContext visitDeclarationAST(DeclarationAST declarationAST, ExecutionContext executionContext);
}
