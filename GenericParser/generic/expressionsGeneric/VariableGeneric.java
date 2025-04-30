package expression.generic.expressionsGeneric;

public class VariableGeneric<N extends Number> implements GenericExpression<N> {
    private final String name;

    public VariableGeneric(String name) {
        this.name = name;
    }

    @Override
    public N evaluate(N x) {
        return x;
    }

    @Override
    public N evaluate(N x, N y, N z) {
        return switch (name.charAt(name.length()-1)) {
            case 'x' -> x;
            case 'y' -> y;
            case 'z' -> z;
            default -> throw new IllegalArgumentException("Unknown variable");
        };

    }
}
