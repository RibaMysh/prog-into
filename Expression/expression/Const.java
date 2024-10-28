package expression;

import java.util.Objects;

public class Const implements TotalExpression{
    private final int cons;
    public Const(int n){
        cons = n;
    }
    public int getCons(){
        return cons;
    }
    @Override
    public String toString(){
        return String.valueOf(cons);
    }
    @Override
    public int evaluate(int n){
        return cons;
    }
    @Override
    public int evaluate(int x, int y, int z) {
        return cons;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != Const.class) {
            return false;
        }
        Const co = (Const) obj;
        return cons == co.getCons();
    }
    @Override
    public int hashCode() {
        return Objects.hash(cons);
    }
}
