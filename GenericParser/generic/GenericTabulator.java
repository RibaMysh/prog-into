package expression.generic;

import expression.exceptions.madenException.CheckedException;
import expression.exceptions.madenException.ParseException;
import expression.generic.expressionsGeneric.GenericExpression;
import expression.generic.parserGeneric.GenericParser;
import expression.generic.spaces.*;

import java.util.Map;

public class GenericTabulator implements Tabulator{

    private static final Map<String, Space<?>> SPACE_MAP = Map.of(
            "i", new IntegerSpace(),
            "d", new DoubleSpace(),
            "bi", new BigIntegerSpace()
    );

    public static Space<?> getSpace(String key) {
        return SPACE_MAP.get(key);
    }

    @Override
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws Exception {

        return solution(getSpace(mode), expression, x1, x2, y1, y2, z1, z2);
    }

    private <N extends Number> Object[][][] solution(Space<N> space, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws ParseException {
        Object[][][] result = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        GenericParser<N> genericParser = new GenericParser<>(expression, space);
//        GenericParser<T> parser = new GenericParser<>(typeInterface);
        GenericExpression<N> parsedExpression = genericParser.parseExpression();
        for (int i = 0; i < x2 - x1 + 1; i++) {
            for (int j = 0; j < y2 - y1 + 1; j++) {

                for (int k = 0; k < z2 - z1 + 1; k++) {
                    try {
                        result[i][j][k] = parsedExpression.evaluate(space.intToType((x1 + i)), space.intToType((y1 + j)),
                                space.intToType((z1 + k)));
                    } catch (CheckedException e) {
                        result[i][j][k] = null;
                    }

                }
            }
        }
        return result;
    }


    public static void main(String[] args) throws Exception {
        if(args.length < 2) {
            throw new IllegalArgumentException("Not enough args: " + args.length);
        }
        String mode = args[0];
        String expression = args[1];
        GenericTabulator tabulator = new GenericTabulator();
        Object[][][] res = tabulator.tabulate(mode, expression, -2, 2, -2, 2, -2, 2);
        for(int i = 0; i < 5; i++) {
            for (int j =0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    System.out.println(res[i][j][k]);
                }
            }
        }
    }
}
