package ASTVisitor;

import ast.*;

public interface ASTVisitor {
  void visitPlusAST(PlusAST plusAST);

  void visitMinusAST(MinusAST minusAST);

  void visitMultiplicationAST(MultiplicationAST multiplicationAST);

  void visitDivisionAST(DivisionAST divisionAST);

  void visitAssignationAST(AssignationAST assignationAST);

  void visitNumberTypeAST(NumberTypeAST numberTypeAST);

  void visitStringTypeAST(StringTypeAST stringTypeAST);

  void visitIdentifierAST(IdentifierAST identifierAST);

  void visitDeclarationAST(DeclarationAST declarationAST);

  void visitStringAST(StringAST stringAST);

  void visitNumberAST(NumberAST numberAST);

  void visitIfBodyAST(IfBodyAST ifBodyAST);

  void visitIfFunctionAST(IfFunctionAST ifFunctionAST);

  void visitEqualsComparatorAST(EqualsComparatorAST equalsComparatorAST);

  void visitGreaterComparatorAST(GreaterComparatorAST greaterComparatorAST);

  void visitGreaterOrEqualsComparatorAST(GreaterOrEqualsComparatorAST greaterOrEqualsComparatorAST);

  void visitMinorComparatorAST(MinorComparatorAST minorComparatorAST);

  void visitMinorOrEqualsComparatorAST(MinorOrEqualsComparatorAST minorOrEqualsComparatorAST);

  void visitBooleanTypeAST(BooleanTypeAST booleanTypeAST);
}
