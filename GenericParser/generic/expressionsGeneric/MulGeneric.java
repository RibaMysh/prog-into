package expression.generic.expressionsGeneric;

import expression.generic.spaces.Space;

public class MulGeneric<N extends Number> extends AbstractBinaryGeneric<N> {
    public MulGeneric(GenericExpression<N> left, GenericExpression<N> right, Space<N> space) {
        super(left, right, space);
    }

    @Override
    protected N compute(N x, N y) {
        return space.multiply(x, y);
    }

    @Override
    protected String getOperation() {
        return "*";
    }
}
