package ASTVisitor;

import ast.*;

public class InterpretASTVisitor implements ASTVisitor {
  private final ExecutionContext executionContext;

  public InterpretASTVisitor(ExecutionContext executionContext) {
    this.executionContext = executionContext;
  }

  @Override
  public void visitOperationAST(OperationAST operationAST) {
    operationAST.getLeftChild().accept(this);
    int left = executionContext.getResult();
    operationAST.getRightChild().accept(this);
    int right = executionContext.getResult();

    switch (operationAST.getValue().getType()) {
      case PLUS_OPERATOR:
        executionContext.sum(left, right);
        break;
      case MINUS_OPERATOR:
        executionContext.min(left, right);
        break;
      case MULTIPLICATION_OPERATOR:
        executionContext.mult(left, right);
        break;
      case DIVISION_OPERATOR:
        executionContext.div(left, right);
    }
  }

  @Override
  public void visitLiteralAST(LiteralAST literalAST) {
    executionContext.setResult(Integer.parseInt(literalAST.getValue().getValue()));
  }

  @Override
  public void visitAssignationAST(AssignationAST assignationAST) {
    assignationAST.getLeftChild().accept(this);
    String left = executionContext.getTemporalIdentifier();
    assignationAST.getRightChild().accept(this);
    int right = executionContext.getResult();
    executionContext.addVariable(left, String.valueOf(right));
  }

  @Override
  public void visitDataTypeAST(DataTypeAST dataTypeAST) {}

  @Override
  public void visitIdentifierAST(IdentifierAST identifierAST) {
    String identifier = identifierAST.getValue().getValue();
    String possibleValue = executionContext.getVariableValue(identifier);
    if (possibleValue == null) executionContext.setTemporalIdentifier(identifier);
    else executionContext.setResult(Integer.parseInt(possibleValue));
  }

  @Override
  public void visitDeclarationAST(DeclarationAST declarationAST) {
    declarationAST.getLeftChild().accept(this);
  }
}
