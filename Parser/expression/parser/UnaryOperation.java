package expression.parser;

import expression.TotalExpression;

import java.util.List;
import java.util.Objects;

public abstract class UnaryOperation implements TotalExpression{
    private final TotalExpression expression;
    private final String operation;
    public UnaryOperation(TotalExpression e, String operation){
        expression = e;
        this.operation = operation;
    }
    @Override
    public String toString(){
        return   operation + "(" + expression + ")";
    }
    @Override
    public int evaluate(int n){
        return operation(expression.evaluate(n));
    }
    protected abstract int operation(int n);
    @Override
    public int evaluate(int x, int y, int z) {
        return operation(expression.evaluate(x, y, z));
    }
    @Override
    public int evaluate(List<Integer> variables) {
         return operation(expression.evaluate(variables));
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        UnaryOperation uo = (UnaryOperation) obj;

        return expression.equals(uo.expression);
    }
    @Override
    public int hashCode() {
        return Objects.hash(expression, operation);
    }
}

