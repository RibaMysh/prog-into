package expression.exceptions;

import expression.TotalExpression;
import expression.parser.UnaryOperation;

public class CheckedT0 extends UnaryOperation {
    public CheckedT0(TotalExpression e) {
        super(e, "t0");
    }
//    public static int t0(int value) {
//        if (value == 0) return 32;
//        int count = 0;
//        for (int i = 0; i < 32; i++) {
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
        return Integer.numberOfTrailingZeros(n);
    }
}
