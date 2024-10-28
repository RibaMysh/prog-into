package expression.parser;


import expression.TotalExpression;

public class UnaryMinus extends UnaryOperation{
    public UnaryMinus(TotalExpression e){
        super(e, "-");
    }

    @Override
    protected int operation(int n) {
        return -n;
    }
}

