package expression.generic.expressionsGeneric;

public class ConstGeneric<N extends Number> implements GenericExpression<N>{
    private final N value;

    public ConstGeneric(N value) {
        this.value = value;
    }

    @Override
    public N evaluate(N x) {
        return value;
    }

    @Override
    public N evaluate(N x, N y, N z) {
        return value;
    }
}
