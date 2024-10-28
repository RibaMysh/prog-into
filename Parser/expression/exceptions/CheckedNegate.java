package expression.exceptions;

import expression.TotalExpression;
import expression.parser.UnaryMinus;

public class CheckedNegate extends UnaryMinus {
    public CheckedNegate(TotalExpression e) {
        super(e);
    }

    @Override
    public int operation(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new OverflowException(2);
        }
        return -a;
    }
}
