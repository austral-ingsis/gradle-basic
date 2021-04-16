package ASTVisitor;

import java.util.Map;

public class SumExecution implements Execution {

    private Execution leftExecution;

    private Execution rightExecution;


    public Execution getLeftExecution() {
        return leftExecution;
    }

    public void setLeftExecution(Execution leftExecution) {
        this.leftExecution = leftExecution;
    }

    public Execution getRightExecution() {
        return rightExecution;
    }

    public void setRightExecution(Execution rightExecution) {
        this.rightExecution = rightExecution;
    }

    @Override
    public int execute(Map<String, String> variables) {
        return leftExecution.execute(variables) + rightExecution.execute(variables);
    }
}
