package expression.generic.expressionsGeneric;

import expression.generic.spaces.Space;

public class PerimeterGeneric<N extends Number> extends AbstractBinaryGeneric<N> {
    public PerimeterGeneric(GenericExpression<N> left, GenericExpression<N> right, Space<N> space) {
        super(left, right, space);
    }

    @Override
    protected N compute(N x, N y) {
        return space.perimeter(x, y);
    }

    @Override
    protected String getOperation() {
        return "perimeter";
    }


}
