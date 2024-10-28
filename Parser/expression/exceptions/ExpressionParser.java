package expression.exceptions;

import expression.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionParser implements TripleParser, ListParser {

    @Override
    public TripleExpression parse(String expression) {
        //System.err.println(expression);
        return new Parser(new StringCharSource(expression)).parseElement();
    }

    @Override
    public ListExpression parse(String expression, List<String> variables) throws Exception {

        return new Parser(new StringCharSource(expression), variables).parseElement();
    }

    private static class Parser extends BaseParser {
        private final Map<String, Integer> variablesMap = new HashMap<>();
        private List<String> variables;
        private final List<Character> variablesLetters = new ArrayList<>();
        private final String validSymbols = "_$lt()+-/*xyz0123456789";
        private boolean firstBracketFlag = false, inBracket = false;
        public Parser(CharSource source) {
            super(source);
        }
        public Parser(CharSource source, List<String> variables) {
            super(source);
            this.variables = variables;
            makeList();
        }

        private void makeList() {
            String s;
            for( int i = 0; i < variables.size(); i ++){
                s = variables.get(i);
                for(char ch : s.toCharArray()) {
                    if(!variablesLetters.contains(ch)) {
                        variablesLetters.add(ch);
                    }
                }
                variablesMap.put(s, i);
            }

        }

        private TotalExpression parseElement() {
            skipWhitespace();
            TotalExpression expression = expr();
            skipWhitespace();
            if(eof()) {
                return expression;
            }
            if(take(')')){
                throw new ExpressionException("No opening parenthesis");
            }
            take();
            if(eof()) {
                throw new ExpressionException("End symbol");
            }
            throw new ExpressionException("Middle symbol");
        }


        private TotalExpression prim() {
            skipWhitespace();

            if (between('0', '9')) {
                return new Const(parseNum(false));
            }

            if (take('-')) {
                if (between('1', '9')) {
                    return new Const(parseNum(true));
                }
                return new CheckedNegate(prim());
            }

            if (take('(')) {
                inBracket = true;
                firstBracketFlag = true;
                TotalExpression e = expr();
                skipWhitespace();
                if(!take(')')) {
                    throw new ExpressionException("No closing parenthesis"); // No closing parenthesis!!!
                }
                inBracket = false;
                return e;
            }
            if (test('l') || test('t')) { // :NOTE: copypaste
                char ch = take();
                if(!take('0')) {
                    throw new ExpressionException("Missing zero");
                }
                if(between('0', '9') || in("xyz")) {
                    throw new ExpressionException("So close");
                }

                return ch == 'l' ? new CheckedL0(prim()) :
                        new CheckedT0(prim());
            }
            if(variables == null) {
                if (test('x') || test('y') || test('z')) {
                    return new Variable(Character.toString(take()));
                }
            } else {
                return makeVariable();
            }
            throw parseException(inBracket);

        }

        private TotalExpression makeVariable() {
            StringBuilder sb = new StringBuilder();
            while (true) {
                if (in(variablesLetters)) sb.append(take());
                else break;
            }
            if(variables.contains(sb.toString())) {
                return new Variable(sb.toString(), variablesMap.get(sb.toString()));
            }
            throw new ExpressionException("Unknown variable");
        }

        private ExpressionException parseException(boolean inBracket) {
            if(eof()) {
                return new ExpressionException("No last argument");
            }
            if(!inBracket) {
                return new ExpressionException("No middle argument");
            } else {
                if(in("+-*/")) {
                    return new ExpressionException("No middle argument'");
                } if(test(')')) {
                    return new ExpressionException("No last argument'");
                }
            }
            if(!in(validSymbols)) {
                take();
                skipWhitespace();
                if (eof()){
                    return new ExpressionException("End symbol");
                }else {
                    return new ExpressionException("Middle symbol");
                }
            }
            return new ExpressionException("At End ");
        }

        private int parseNum(boolean flag) {
            StringBuilder sb = new StringBuilder();
            if(flag){
                sb.append('-');
            }
            if (take('0')) {
                return 0;
            }
            while (between('0', '9')) {
                sb.append(take());
            }
            skipWhitespace();
            if(between('0', '9')) {
                throw new ExpressionException("Spaces in numbers");
            }

            try {
                return Integer.parseInt(sb.toString());
            } catch (NumberFormatException e) {
                if(sb.charAt(0) == '-') {
                    throw new OverflowException(1);
                }
                throw new OverflowException(2);
            }
        }
        private TotalExpression term() {
            skipWhitespace();
            TotalExpression left = prim();
            skipWhitespace();
            while (true) {
                if (take('*')) {
                    skipWhitespace();
                    left = new CheckedMultiply(left, prim());
                    skipWhitespace();
                } else if (take('/')) {
                    skipWhitespace();
                    left = new CheckedDivide(left, prim());
                    skipWhitespace();
                } else {
                    break;
                }
            }
            return left;
        }

        private TotalExpression expr() {
            skipWhitespace();
            if(!in(validSymbols) ) {
                throw new ExpressionException("Start symbol");
            }
            if(in("+/*")) {
                if(firstBracketFlag) {
                    throw new ExpressionException("No first argument'");
                }
                throw new ExpressionException("No first argument");
            }
            firstBracketFlag = false;

            TotalExpression left = term();
            skipWhitespace();
            while (true) {

                if (take('+')) {
                    skipWhitespace();
                    left = new CheckedAdd(left, term());
                    skipWhitespace();

                } else if (take('-')) {

                    skipWhitespace();
                    left = new CheckedSubtract(left, term());
                    skipWhitespace();
                } else  {
                    break;
                }
            }
            return left;
        }
    }
}
