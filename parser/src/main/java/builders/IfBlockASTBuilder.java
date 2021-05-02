package builders;

import ast.AST;
import ast.IfBlockAST;
import exceptions.ASTBuildException;
import exceptions.BadTokenException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import token.Token;

public class IfBlockASTBuilder implements ASTBuilder {
  private final Token value;
  private transient List<ASTBuilder> children;
  private transient int position;

  public IfBlockASTBuilder(Token value) {
    this.value = value;
    this.children = new LinkedList<>();
    this.position = 0;
  }

  public IfBlockASTBuilder(Token value, List<ASTBuilder> children) {
    this.value = value;
    this.children = children;
    this.position = 0;
  }

  public IfBlockASTBuilder(Token value, List<ASTBuilder> children, int position) {
    this.value = value;
    this.children = children;
    this.position = position;
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
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(StringASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(PlusASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(MinusASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(MultiplicationASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(DivisionASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(AssignationASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(DeclarationASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(NumberTypeASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(StringTypeASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(IdentifierASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(IfFunctionASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(IfBodyASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(BooleanASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(BooleanTypeASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(IfBlockASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(EqualsComparatorASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterComparatorASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(GreaterOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(MinorComparatorASTBuilder newAST) throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(MinorOrEqualsComparatorASTBuilder newAST)
      throws BadTokenException {
    List<ASTBuilder> newChildren = new LinkedList<>(children);
    if (position >= children.size()) {
      newChildren.add(newAST);
      return new IfBlockASTBuilder(getValue(), newChildren, position);
    }
    ASTBuilder lastBuilder = newChildren.get(position);
    ASTBuilder builderToAdd = lastBuilder.addASTBuilder(newAST);
    newChildren.set(position, builderToAdd);
    return new IfBlockASTBuilder(getValue(), newChildren, position);
  }

  @Override
  public ASTBuilder addASTBuilder(EscCharASTBuilder newAST) throws BadTokenException {
    return new IfBlockASTBuilder(value, children, position + 1);
  }

  @Override
  public AST buildAST() throws ASTBuildException {
    return new IfBlockAST(getValue(), getASTList());
  }

  private List<AST> getASTList() {
    return children.stream()
        .map(
            astBuilder -> {
              try {
                return astBuilder.buildAST();
              } catch (ASTBuildException e) {
                throw new RuntimeException();
              }
            })
        .collect(Collectors.toList());
  }
}
