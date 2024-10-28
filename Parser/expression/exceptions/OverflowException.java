package expression.exceptions;

public class OverflowException extends ExpressionException {
    public OverflowException(int type) {
        super("Constant overflow " + type);
    }
}
