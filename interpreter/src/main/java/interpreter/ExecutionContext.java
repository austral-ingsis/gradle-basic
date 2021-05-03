package interpreter;

import java.util.HashMap;
import java.util.Map;
import utils.Printer;

public class ExecutionContext {

  private final transient Map<String, String> variables;
  private final transient Printer printer;

  private String temporalIdentifier;

  private int result;

  private boolean conditionalResult;

  public ExecutionContext(Printer printer) {
    this.variables = new HashMap<>();
    this.printer = printer;
  }

  public int sum(int a, int b) {
    result = a + b;
    return a;
  }

  public int mult(int a, int b) {
    result = a * b;
    return a;
  }

  public int div(int a, int b) {
    result = a / b;
    return a;
  }

  public int min(int a, int b) {
    result = a - b;
    return a;
  }

  public boolean isEqual(int a, int b) {
    return a == b;
  }

  public boolean isGreater(int a, int b) {
    return a > b;
  }

  public boolean isGreaterOrEqual(int a, int b) {
    return a >= b;
  }

  public boolean isMinor(int a, int b) {
    return a < b;
  }

  public boolean isMinorOrEqual(int a, int b) {
    return a <= b;
  }

  public String getVariableValue(String variable) {
    return variables.get(variable);
  }

  public void addVariable(String variable, String value) {
    variables.put(variable, value);
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
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

  public void printLine() {
    printer.print(String.valueOf(getResult()));
  }
}
