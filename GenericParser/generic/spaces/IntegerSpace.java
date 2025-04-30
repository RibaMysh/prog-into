package expression.generic.spaces;

import expression.exceptions.*;

public class IntegerSpace implements Space<Integer>{
    @Override
    public Integer add(Integer x, Integer y) {
        return CheckedAdd.checkedCount(x, y);
    }

    @Override
    public Integer subtract(Integer x, Integer y) {
        return CheckedSubtract.checkedCount(x, y);
    }

    @Override
    public Integer multiply(Integer x, Integer y) {
        return CheckedMultiply.checkedCount(x, y);
    }

    @Override
    public Integer divide(Integer x, Integer y) {
        return CheckedDivide.checkedCount(x, y);
    }

    @Override
    public Integer negate(Integer x) {
        return CheckedNegate.checkedCount(x);
    }

    @Override
    public Integer intToType(int a) {
        return a;
    }

    @Override
    public Integer area(Integer x, Integer y) {
        return CheckedArea.checkedCount(x, y);
    }

    @Override
    public Integer perimeter(Integer x, Integer y) {
        return CheckedPerimetr.checkedCount(x, y);
    }
}
