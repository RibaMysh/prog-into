package expression.parser;

import expression.*;

public class ExpressionParser  {
//
//    public TripleExpression parse(String expression) {
//        return new Parser(new StringCharSource(expression)).parseElement();
//    }
//    private static class Parser extends BaseParser {
//        public Parser(CharSource source) {
//            super(source);
//        }
//
//        private TotalExpression parseElement() {
//            skipWhitespace();
//            TotalExpression expression = expr();
//            skipWhitespace();
//
//            if(eof()) {
//                return expression;
//            }
//            throw error("End of string expected");
//        }
//        private TotalExpression prim() {
//            skipWhitespace();
//
//            if (between('0', '9')) {
//                return new Const(parseNum(false));
//            }
//
//            if (test('x') ||  test('y') || test('z') ) {
//                return new Variable(Character.toString(take()));
//            }
//
//            if (take('-')) {
//                if (between('1', '9')) {
//                    return new Const(parseNum(true));
//                }
//                return new UnaryMinus(prim());
//            }
//
//            if (take('(')) {
//                TotalExpression e = expr();
//                expect(')');
//                return e;
//            }
//            throw error("Invalid parse element");
//        }
//
//        private int parseNum(boolean flag) {
//            StringBuilder sb = new StringBuilder();
//            if(flag){
//                sb.append('-');
//            }
//            if (take('0')) {
//                return 0;
//            }
//            while (between('0', '9')) {
//                sb.append(take());
//            }
//            try {
//                return Integer.parseInt(sb.toString());
//            } catch (NumberFormatException e) {
//                throw error("Invalid number" + " " + sb);
//            }
//        }
//        private TotalExpression term() {
//            skipWhitespace();
//            TotalExpression left = prim();
//            skipWhitespace();
//
//            while (true) {
//                if (take('*')) {
//                    skipWhitespace();
//                    left = new Multiply(left, prim());
//                    skipWhitespace();
//                } else if (take('/')) {
//                    skipWhitespace();
//                    left = new Divide(left, prim());
//                    skipWhitespace();
//                } else {
//                    break;
//                }
//            }
//            return left;
//        }
//
//        private TotalExpression expr() {
//            skipWhitespace();
//            TotalExpression left = term();
//            skipWhitespace();
//            while (true) {
//                if (take('+')) {
//                    skipWhitespace();
//                    left = new Add(left, term());
//                    skipWhitespace();
//                } else if (take('-')) {
//                    skipWhitespace();
//                    left = new Subtract(left, term());
//                    skipWhitespace();
//                } else {
//                    return left;
//                }
//            }
//        }

}

