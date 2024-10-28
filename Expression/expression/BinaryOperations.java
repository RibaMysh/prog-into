package expression;

import java.util.Objects;

abstract class BinaryOperations implements TotalExpression{

    private final String operation;
    private final TotalExpression variable1, variable2;

    public BinaryOperations(TotalExpression n1, TotalExpression n2, String operation){
        variable1 = n1;
        variable2 = n2;
        this.operation = operation;

    }
    public TotalExpression getVariable1(){
        return variable1;
    }
    public TotalExpression getVariable2(){
        return variable2;
    }
    public int evaluate(int n){
        return operation(variable1.evaluate(n), variable2.evaluate(n));
    }

    public int evaluate(int x, int y, int z) {
        return operation(variable1.evaluate(x, y, z), variable2.evaluate(x, y, z));
    }
    protected abstract int operation(int n1, int n2);

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
        return getVariable1().equals(bo.getVariable1()) && getVariable2().equals(bo.getVariable2());
    }
    @Override
    public int hashCode() {
        return Objects.hash(variable1, variable2, operation);
    }
}
