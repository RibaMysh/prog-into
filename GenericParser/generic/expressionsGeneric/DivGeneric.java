package expression.generic.expressionsGeneric;

import expression.generic.spaces.Space;

public class DivGeneric<N extends Number> extends AbstractBinaryGeneric<N> {
    public DivGeneric(GenericExpression<N> left, GenericExpression<N> right, Space<N> space) {
        super(left, right, space);
    }

    @Override
    protected N compute(N x, N y) {
        return space.divide(x, y);
    }

    @Override
    protected String getOperation() {
        return "/";
    }
}
