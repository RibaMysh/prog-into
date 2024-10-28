package expression;

import expression.exceptions.ExpressionException;

import java.util.List;
import java.util.Objects;

public abstract class BinaryOperations implements TotalExpression{

    private final String operation; // :NOTE: store in OP
    private final TotalExpression variable1, variable2;

    public BinaryOperations(TotalExpression n1, TotalExpression n2, String operation){
        variable1 = n1;
        variable2 = n2;
        this.operation = operation;

    }

    public int evaluate(int n)  {
        return operation(variable1.evaluate(n), variable2.evaluate(n));
    }

    public int evaluate(int x, int y, int z)  {
        return operation(variable1.evaluate(x, y, z), variable2.evaluate(x, y, z));
    }

    public int evaluate(List<Integer> lst)  {
        return operation(variable1.evaluate(lst), variable2.evaluate(lst));
    }

    abstract public int operation(int n1, int n2) throws ExpressionException;

    @Override
    public String toString(){
        return "(" + variable1.toString() + " " + operation + " " + variable2.toString() + ")";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        BinaryOperations bo = (BinaryOperations) obj;
        // Objects.equals(variable1, bo.variable1) && ..
        return variable1.equals(bo.variable1) && variable2.equals(bo.variable2);
    }
    @Override
    public int hashCode() {
        return Objects.hash(variable1, variable2, operation);
    }
}
