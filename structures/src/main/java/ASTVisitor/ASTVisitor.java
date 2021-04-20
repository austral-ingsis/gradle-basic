package ASTVisitor;

import ast.*;

public interface ASTVisitor {
  void visitOperationAST(OperationAST operationAST);

  void visitLiteralAST(LiteralAST literalAST);

  void visitAssignationAST(AssignationAST assignationAST);

  void visitDataTypeAST(DataTypeAST dataTypeAST);

  void visitIdentifierAST(IdentifierAST identifierAST);

  void visitDeclarationAST(DeclarationAST declarationAST);
}
