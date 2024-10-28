package expression.exceptions;

import expression.TotalExpression;
import expression.parser.UnaryOperation;

public class CheckedL0 extends UnaryOperation {
    public CheckedL0(TotalExpression e) {
        super(e, "l0");
    }
//    public static int l0(int value) {
//        if (value == 0) return 32;
//        int count = 0;
//        for (int i = 31; i >= 0; i--) {
//            if ((value & (1 << i)) == 0) {
//                count++;
//            } else {
//                break;
//            }
//        }
//        return count;
//    }

    @Override
    protected int operation(int n) {
        return Integer.numberOfLeadingZeros(n);
    }
}

