package expression.generic.expressionsGeneric;

import expression.generic.spaces.Space;

import java.util.Objects;

public abstract class AbstractBinaryGeneric<T extends Number> implements GenericExpression<T> {
    protected final GenericExpression<T> left;
    protected final GenericExpression<T> right;
    protected final Space<T> space;

    public AbstractBinaryGeneric(GenericExpression<T> left, GenericExpression<T> right, Space<T> space) {
        this.left = left;
        this.right = right;
        this.space = space;
    }


    @Override
    public T evaluate(T x){
        return compute(left.evaluate(x), right.evaluate(x));
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return compute(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }

    protected abstract T compute(T x, T y);

    @Override
    public String toString() {
        return String.format("(%s %s %s)", left.toString(), getOperation(), right.toString());
    }

    abstract protected String getOperation();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractBinaryGeneric<?> that = (AbstractBinaryGeneric<?>) o;
        return Objects.equals(left, that.left) && Objects.equals(right, that.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, getOperation());
    }
    
}
