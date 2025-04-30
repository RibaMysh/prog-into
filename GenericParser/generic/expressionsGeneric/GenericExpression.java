package expression.generic.expressionsGeneric;

public interface GenericExpression<T extends Number> {
    T evaluate(T x);
    T evaluate(T x, T y, T z);
}
