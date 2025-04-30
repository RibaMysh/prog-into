package expression.generic.expressionsGeneric;


import expression.generic.spaces.Space;

public class SubtractGeneric<N extends Number> extends AbstractBinaryGeneric<N> {

    public SubtractGeneric(GenericExpression<N> left, GenericExpression<N> right, Space<N> space) {
        super(left, right, space);
    }

    @Override
    protected N compute(N x, N y) {
        return space.subtract(x, y);
    }

    @Override
    protected String getOperation() {
        return "-";
    }
}
