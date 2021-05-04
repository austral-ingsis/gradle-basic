package interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ExecutionContext {

  private enum ResultMode {
    DOUBLE_MODE,
    STRING_MODE
  }

  private final transient Map<String, String> variables;
  private final transient Consumer<String> lines;
  private transient ResultMode resultMode;

  private String temporalIdentifier;

  private String result;
  private boolean conditionalResult;

  public ExecutionContext(Consumer<String> lines) {
    this.resultMode = ResultMode.DOUBLE_MODE;
    this.result = "";
    this.variables = new HashMap<>();
    this.lines = lines;
  }

  public void sum(String a, String b) {
    switch (resultMode) {
      case STRING_MODE -> result = a + b;
      case DOUBLE_MODE -> result = String.valueOf(Double.parseDouble(a) + Double.parseDouble(b));
    }
  }

  public void mult(String a, String b) {
    if (resultMode == ResultMode.STRING_MODE) throw new UnsupportedOperationException();
    result = String.valueOf(Double.parseDouble(a) * Double.parseDouble(b));
  }

  public void div(String a, String b) {
    if (resultMode == ResultMode.STRING_MODE) throw new UnsupportedOperationException();
    result = String.valueOf(Double.parseDouble(a) / Double.parseDouble(b));
  }

  public void min(String a, String b) {
    if (resultMode == ResultMode.STRING_MODE) throw new UnsupportedOperationException();
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

  public String getVariableValue(String variable) {
    return variables.get(variable);
  }

  public void addVariable(String variable, String value) {
    variables.put(variable, value);
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
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
  }

  public void setStringResult(String value) {
    this.result = value;
    resultMode = ResultMode.STRING_MODE;
  }

  public void printLine() {
    switch (resultMode) {
      case DOUBLE_MODE -> {
        double resultDouble = Double.parseDouble(result);
        if ((resultDouble == Math.floor(resultDouble)) && !Double.isInfinite(resultDouble)) {
          lines.accept(String.valueOf((int) resultDouble));
        } else {
          lines.accept(result);
        }
        result = "";
      }
      case STRING_MODE -> lines.accept(result);
    }
    this.resultMode = ResultMode.DOUBLE_MODE;
  }
}
