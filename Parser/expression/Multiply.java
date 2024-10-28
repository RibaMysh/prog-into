package expression;

public class Multiply extends BinaryOperations{
    public Multiply(TotalExpression n1, TotalExpression n2) {
        super(n1, n2, "*");
    }
    @Override
    public int operation(int n1, int n2){
        return n1 * n2;
    }
}
