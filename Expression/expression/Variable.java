package expression;

import java.util.Objects;

public class Variable implements TotalExpression{
    private final String variable;
    public Variable(String variable){
        this.variable = variable;
    }
    public String getVariable(){
        return variable;
    }
    @Override
    public String toString(){
        return variable;
    }
    @Override
    public int evaluate(int n){
        return n;
    }
    @Override
    public int evaluate(int x, int y, int z) {
        switch(variable) {
            case "x": {
                return x;
            }
            case "y": {
                return y;
            }
            case "z": {
                return z;
            }
        }
        return 0;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != Variable.class) {
            return false;
        }
        Variable v = (Variable) obj;
        return getVariable().equals(v.getVariable());
    }
    @Override
    public int hashCode() {
        return Objects.hash(variable);
    }


}
