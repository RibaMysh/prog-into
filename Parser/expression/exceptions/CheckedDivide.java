package expression.exceptions;

import expression.Divide;
import expression.TotalExpression;

public class CheckedDivide extends Divide {

    public CheckedDivide(TotalExpression n1, TotalExpression n2) {
        super(n1, n2);
    }

    @Override
    public int operation(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("DivisionByZero");
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new OverflowException(1);
        }
        return a / b;
    }
}
