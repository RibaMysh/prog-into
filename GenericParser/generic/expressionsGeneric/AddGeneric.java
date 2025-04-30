package expression.generic.expressionsGeneric;

import expression.generic.spaces.Space;

public class AddGeneric<N extends Number> extends AbstractBinaryGeneric<N> {

    public AddGeneric(GenericExpression<N> left, GenericExpression<N> right, Space<N> space) {
        super(left, right, space);
    }

    @Override
    protected N compute(N x, N y) {
        return space.add(x, y);
    }

    @Override
    protected String getOperation() {
        return "+";
    }
}
