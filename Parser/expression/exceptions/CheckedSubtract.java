package expression.exceptions;

import expression.Subtract;
import expression.TotalExpression;

public class CheckedSubtract extends Subtract {
    public CheckedSubtract(TotalExpression n1, TotalExpression n2) {
        super(n1, n2);
    }
    @Override
    public int operation(int a, int b) {
        if (b > 0 && (Integer.MIN_VALUE + b > a)) {
            throw new OverflowException(1);
        }
        if (b < 0 && (Integer.MAX_VALUE + b < a)) {
            throw new OverflowException(2);
        }
        return a - b;
    }
}
