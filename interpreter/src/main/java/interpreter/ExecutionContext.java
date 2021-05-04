package interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ExecutionContext {

  private enum ResultMode {
    DOUBLE,
    STRING,
    BOOLEAN
  }

  private enum CreationMode {
    VARIABLE,
    CONSTANT
  }

  private class ValueAndType {
    private transient String value;
    private transient ResultMode type;

    public ValueAndType(String value, ResultMode type) {
      this.value = value;
      this.type = type;
    }

    public String getValue() {
      return value;
    }

    public ResultMode getType() {
      return type;
    }

    public void setValue(String value) {
      this.value = value;
    }
  }

  private final transient Map<String, ValueAndType> variables;
  private final transient Map<String, ValueAndType> constants;
  private final transient Consumer<String> lines;
  private transient ResultMode resultMode;
  private transient ResultMode creationType;
  private transient CreationMode creationMode;

  private String temporalIdentifier;

  private String result;
  private boolean conditionalResult;

  public ExecutionContext(Consumer<String> lines) {
    this.resultMode = ResultMode.DOUBLE;
    this.result = "";
    this.variables = new HashMap<>();
    this.constants = new HashMap<>();
    this.lines = lines;
  }

  public void sum(String a, String b) {
    switch (resultMode) {
      case STRING -> result = a + b;
      case DOUBLE -> result = String.valueOf(Double.parseDouble(a) + Double.parseDouble(b));
    }
  }

  public void mult(String a, String b) {
    if (resultMode == ResultMode.STRING) throw new UnsupportedOperationException();
    result = String.valueOf(Double.parseDouble(a) * Double.parseDouble(b));
  }

  public void div(String a, String b) {
    if (resultMode == ResultMode.STRING) throw new UnsupportedOperationException();
    result = String.valueOf(Double.parseDouble(a) / Double.parseDouble(b));
  }

  public void min(String a, String b) {
    if (resultMode == ResultMode.STRING) throw new UnsupportedOperationException();
    result = String.valueOf(Double.parseDouble(a) - Double.parseDouble(b));
  }

  public boolean isEqual(String a, String b) {
    return Double.parseDouble(a) == Double.parseDouble(b);
  }

  public boolean isGreater(String a, String b) {
    return Double.parseDouble(a) > Double.parseDouble(b);
  }

  public boolean isGreaterOrEqual(String a, String b) {
    return Double.parseDouble(a) >= Double.parseDouble(b);
  }

  public boolean isMinor(String a, String b) {
    return Double.parseDouble(a) < Double.parseDouble(b);
  }

  public boolean isMinorOrEqual(String a, String b) {
    return Double.parseDouble(a) <= Double.parseDouble(b);
  }

  public String getIdentifierValue(String identifier) {
    ValueAndType variable = variables.get(identifier);
    ValueAndType constant = constants.get(identifier);
    return variable != null ? variable.getValue() : (constant != null ? constant.getValue() : null);
  }

  public void addIdentifier(String identifier, String value) {
    if (creationMode == null) {
      if (variables.get(identifier) == null) {
        throw new UnsupportedOperationException();
      }
      variables.put(identifier, new ValueAndType(value, resultMode));
    } else {
      if (constants.containsKey(identifier) || variables.containsKey(identifier)) {
        throw new UnsupportedOperationException();
      }
      switch (creationMode) {
        case CONSTANT -> constants.put(identifier, new ValueAndType(value, resultMode));
        case VARIABLE -> variables.put(identifier, new ValueAndType(value, resultMode));
      }
    }

    resultMode = ResultMode.DOUBLE;
  }

  public String getResult() {
    return result;
  }

  public String getTemporalIdentifier() {
    return temporalIdentifier;
  }

  public void setTemporalIdentifier(String temporalIdentifier) {
    this.temporalIdentifier = temporalIdentifier;
  }

  public boolean getConditionalResult() {
    return conditionalResult;
  }

  public void setConditionalResult(boolean conditionalResult) {
    this.conditionalResult = conditionalResult;
    this.resultMode = ResultMode.BOOLEAN;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public void setStringResult(String value) {
    this.result = value;
    this.resultMode = ResultMode.STRING;
  }

  public void setBooleanResult(String value) {
    this.result = value;
    this.resultMode = ResultMode.BOOLEAN;
  }

  public void printLine() {
    switch (resultMode) {
      case DOUBLE -> {
        double resultDouble = Double.parseDouble(result);
        if ((resultDouble == Math.floor(resultDouble)) && !Double.isInfinite(resultDouble)) {
          lines.accept(String.valueOf((int) resultDouble));
        } else {
          lines.accept(result);
        }
        result = "";
      }
      case STRING -> lines.accept(result);
    }
    this.resultMode = ResultMode.DOUBLE;
  }

  public void constantCreationMode() {
    creationMode = CreationMode.CONSTANT;
  }

  public void variableCreationMode() {
    creationMode = CreationMode.VARIABLE;
  }

  public void setResultModeFromIdentifier(String identifier) {
    if (resultMode != ResultMode.STRING) {
      ValueAndType variable = variables.get(identifier);
      ValueAndType constant = constants.get(identifier);
      this.resultMode = variable != null ? variable.getType() : constant.getType();
    }
  }

  public boolean isBoolean(String identifier) {
    ValueAndType variable = variables.get(identifier);
    ValueAndType constant = constants.get(identifier);
    ResultMode temp = variable != null ? variable.getType() : constant.getType();
    return temp == ResultMode.BOOLEAN;
  }

  public void setCreationTypeToNumber() {
    this.creationType = ResultMode.DOUBLE;
  }

  public void setCreationTypeToString() {
    this.creationType = ResultMode.STRING;
  }

  public void setCreationTypeToBoolean() {
    this.creationType = ResultMode.BOOLEAN;
  }
}
