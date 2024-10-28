package expression.exceptions;

import expression.Multiply;
import expression.TotalExpression;

public class CheckedMultiply extends Multiply {
    public CheckedMultiply(TotalExpression n1, TotalExpression n2) {
        super(n1, n2);
    }

    @Override
    public int operation(int a, int b) {
        if ( a == 0 || b == 0) {
            return 0;
        }

        int mul = a * b;

        if ((mul / a != b) || (mul / b != a)) {
            if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
                throw new OverflowException(1);
            }
            throw new OverflowException(2);
        }
        return a * b;
    }
}
