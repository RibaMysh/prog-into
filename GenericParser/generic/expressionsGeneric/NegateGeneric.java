package expression.generic.expressionsGeneric;

import expression.generic.spaces.Space;

public class NegateGeneric<N extends Number> implements GenericExpression<N>{
    private final GenericExpression<N> val;

    private final Space<N> space;

    public NegateGeneric(GenericExpression<N> val, Space<N> space) {
        this.val = val;
        this.space = space;
    }


    @Override
    public N evaluate(N x) {
        return compute(val.evaluate(x));
    }

    @Override
    public N evaluate(N x, N y, N z) {
        return compute(val.evaluate(x, y, z));
    }

    public N compute(N x) {
        return space.negate(x);
    }


}
