import ASTVisitor.ASTVisitor;
import ast.*;

public class InterpretASTVisitor implements ASTVisitor {
  private final ExecutionContext executionContext;

  public InterpretASTVisitor(ExecutionContext executionContext) {
    this.executionContext = executionContext;
  }

  @Override
  public void visitPlusAST(PlusAST plusAST) {
    plusAST.getLeftChild().accept(this);
    int left = executionContext.getResult();
    plusAST.getRightChild().accept(this);
    int right = executionContext.getResult();
    executionContext.sum(left, right);
  }

  @Override
  public void visitMinusAST(MinusAST minusAST) {
    minusAST.getLeftChild().accept(this);
    int left = executionContext.getResult();
    minusAST.getRightChild().accept(this);
    int right = executionContext.getResult();
    executionContext.min(left, right);
  }

  @Override
  public void visitMultiplicationAST(MultiplicationAST multiplicationAST) {
    multiplicationAST.getLeftChild().accept(this);
    int left = executionContext.getResult();
    multiplicationAST.getRightChild().accept(this);
    int right = executionContext.getResult();
    executionContext.mult(left, right);
  }

  @Override
  public void visitDivisionAST(DivisionAST divisionAST) {
    divisionAST.getLeftChild().accept(this);
    int left = executionContext.getResult();
    divisionAST.getRightChild().accept(this);
    int right = executionContext.getResult();
    executionContext.div(left, right);
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
  public void visitNumberTypeAST(NumberTypeAST numberTypeAST) {}

  @Override
  public void visitStringTypeAST(StringTypeAST stringTypeAST) {}

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

  @Override
  public void visitStringAST(StringAST stringAST) {
    executionContext.setResult(Integer.parseInt(stringAST.getValue().getValue()));
  }

  @Override
  public void visitNumberAST(NumberAST numberAST) {
    executionContext.setResult(Integer.parseInt(numberAST.getValue().getValue()));
  }

  @Override
  public void visitIfBodyAST(IfBodyAST ifBodyAST) {
    boolean conditional = executionContext.getConditionalResult();
    if (conditional)
      ifBodyAST.getLeftChild().accept(this);
    else ifBodyAST.getRightChild().accept(this);
  }

  @Override
  public void visitIfFunctionAST(IfFunctionAST ifFunctionAST) {
    ifFunctionAST.getLeftChild().accept(this);
    ifFunctionAST.getRightChild().accept(this);
  }

  @Override
  public void visitEqualsComparatorAST(EqualsComparatorAST equalsComparatorAST) {
    equalsComparatorAST.getLeftChild().accept(this);
    int left = executionContext.getResult();
    equalsComparatorAST.getRightChild().accept(this);
    int right = executionContext.getResult();
    boolean result = executionContext.isEqual(left, right);
    executionContext.setConditionalResult(result);
  }

  @Override
  public void visitGreaterComparatorAST(GreaterComparatorAST greaterComparatorAST) {
    greaterComparatorAST.getLeftChild().accept(this);
    int left = executionContext.getResult();
    greaterComparatorAST.getRightChild().accept(this);
    int right = executionContext.getResult();
    boolean result = executionContext.isGreater(left, right);
    executionContext.setConditionalResult(result);
  }

  @Override
  public void visitGreaterOrEqualsComparatorAST(GreaterOrEqualsComparatorAST greaterOrEqualsComparatorAST) {
    greaterOrEqualsComparatorAST.getLeftChild().accept(this);
    int left = executionContext.getResult();
    greaterOrEqualsComparatorAST.getRightChild().accept(this);
    int right = executionContext.getResult();
    boolean result = executionContext.isGreaterOrEqual(left, right);
    executionContext.setConditionalResult(result);
  }

  @Override
  public void visitMinorComparatorAST(MinorComparatorAST minorComparatorAST) {
    minorComparatorAST.getLeftChild().accept(this);
    int left = executionContext.getResult();
    minorComparatorAST.getRightChild().accept(this);
    int right = executionContext.getResult();
    boolean result = executionContext.isMinor(left, right);
    executionContext.setConditionalResult(result);
  }

  @Override
  public void visitMinorOrEqualsComparatorAST(MinorOrEqualsComparatorAST minorOrEqualsComparatorAST) {
    minorOrEqualsComparatorAST.getLeftChild().accept(this);
    int left = executionContext.getResult();
    minorOrEqualsComparatorAST.getRightChild().accept(this);
    int right = executionContext.getResult();
    boolean result = executionContext.isMinorOrEqual(left, right);
    executionContext.setConditionalResult(result);
  }

  @Override
  public void visitBooleanTypeAST(BooleanTypeAST booleanTypeAST) {

  }
}
