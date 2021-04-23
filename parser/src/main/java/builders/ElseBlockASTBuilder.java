package builders;

import ast.AST;
import ast.ElseBlockAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import token.Token;

public class ElseBlockASTBuilder implements ASTBuilder {
  private final Token value;
  private transient List<ASTBuilder> children;

  public ElseBlockASTBuilder(Token value) {
    this.value = value;
    this.children = new LinkedList<>();
  }

  public ElseBlockASTBuilder(Token value, List<ASTBuilder> children) {
    this.value = value;
    this.children = children;
  }

  @Override
  public Token getValue() {
    return value;
  }

  @Override
  public ASTBuilder getRightChild() {
    return null;
  }

  @Override
  public ASTBuilder getLeftChild() {
    return null;
  }

  @Override
  public ASTBuilder addASTBuilder(NumberASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(StringASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(PlusASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(MinusASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(MultiplicationASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(DivisionASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(AssignationASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(DeclarationASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(NumberTypeASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(StringTypeASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(IdentifierASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(IfFunctionASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(IfBodyASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(BooleanASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(BooleanTypeASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(ElseBlockASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(EqualsComparatorASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterComparatorASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(MinorComparatorASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public ASTBuilder addASTBuilder(MinorOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    ASTBuilder lastBuilder = newChildren.get(newChildren.size() - 1);
    lastBuilder.addASTBuilder(newAST);
    newChildren.add(newChildren.size() - 1, lastBuilder);
    return new ElseBlockASTBuilder(getValue(), newChildren);
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    List<AST> astList =
        children.stream()
            .map(
                astBuilder -> {
                  try {
                    return astBuilder.buildAST();
                  } catch (ASTBuildException e) {
                    throw new RuntimeException();
                  }
                })
            .collect(Collectors.toList());
    return new ElseBlockAST(getValue(), astList);
  }
}
