package ASTVisitor;

import java.util.HashMap;
import java.util.Map;

public class ExecutionContext {

    private final Map<String, String> variables;

    private String temporalIdentifier;

    private int result;

    public ExecutionContext() {
        this.variables = new HashMap<>();
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

    public int rest(int a, int b) {
        result = a - b;
        return a;
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
}
