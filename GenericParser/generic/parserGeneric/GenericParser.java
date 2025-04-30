package expression.generic.parserGeneric;

import expression.exceptions.madenException.ParseException;
import expression.generic.expressionsGeneric.*;
import expression.generic.spaces.Space;

import java.util.Map;

public final class GenericParser<N extends Number> extends BaseParser {
    private boolean inBracket = false;
    private int argumentCount = 0;
    private final Map<Character, Character> openToClose = Map.of('(', ')', '[', ']', '{', '}');
    private Space<N> space;

    public GenericParser(String source, Space<N> space) {
        super(new StringSource(source));
        this.space = space;

    }

    public GenericExpression<N> parse() throws ParseException {
        skipWhiteSpace();
        GenericExpression<N> result = first();
        skipWhiteSpace();
        if (eof()) {
            return result;
        }

        if (take(')')) {
            throw parseError("no opening parenthesis");
        }
        throw parseError("bad symbol: " + take());
    }

    public GenericExpression<N> parseExpression() throws ParseException {
        skipWhiteSpace();
        GenericExpression<N> result = first();
        skipWhiteSpace();
        if (eof()) {
            return result;
        }

        if (take(')')) {
            throw parseError("no opening parenthesis");
        }
        throw parseError("bad symbol: " + take());
    }

    private GenericExpression<N> first() throws ParseException {

        skipWhiteSpace();
        checkValid();
        GenericExpression<N> left = expr();
        skipWhiteSpace();

        while (true) {
            skipWhiteSpace();
            String operation = test("area");
            if (operation.isEmpty()) {
                operation = test("perimeter");
                if (!operation.isEmpty()) {
                    left = new PerimeterGeneric<>(left, expr(), space);
                    continue;
                } else {
                    break;
                }
            }
            skipWhiteSpace();
            left = new AreaGeneric<>(left, expr(), space);
            skipWhiteSpace();
        }
        return left;

    }


    // add, sub
    private GenericExpression<N> expr() throws ParseException {
        skipWhiteSpace();

        GenericExpression<N> left = term();
        skipWhiteSpace();

        while (in("+-")) {
            char op = take();
            skipWhiteSpace();
            left = switch (op) {
                case ('-') -> new SubtractGeneric<>(left, term(), space);
                case ('+') -> new AddGeneric<>(left, term(), space);
                default -> left;
            };
            skipWhiteSpace();

        }
        return left;

    }

    // divide, mul
    private GenericExpression<N> term() throws ParseException {
        GenericExpression<N> left = factor();
        skipWhiteSpace();

        while (in("*/")) {

            skipWhiteSpace();
            char op = take();
            skipWhiteSpace();
            left = switch (op) {
                case ('*') -> new MulGeneric<>(left, factor(), space);
                case ('/') -> new DivGeneric<>(left, factor(), space);
                default -> left;
            };
            skipWhiteSpace();
        }
        skipWhiteSpace();
        return left;

    }


    // var, unary -, num
    private GenericExpression<N> factor() throws ParseException {
        if (take('-')) {
            skipWhiteSpace();
            if (between('0', '9')) {
                return new ConstGeneric<>(space.intToType(parseNumber(true)));
            }
            return new NegateGeneric<>(factor(), space);
        }

        if (between('0', '9')) {
            return new ConstGeneric<>(space.intToType(parseNumber(false)));
        }

        if (isAlpha()) {
            argumentCount++;
            return new VariableGeneric<>(getVar());

        }

        if (isOpenPar()) {

            inBracket = true;
            int memoryArgumentCount = argumentCount;
            argumentCount = 0;

            char par = take();

            skipWhiteSpace();
            GenericExpression<N> inner = first();
            inBracket = false;
            argumentCount += memoryArgumentCount;

            if (!take(openToClose.get(par))) {
                throw parseError("Mismatched closing parenthesis");
            }
            return inner;
        }

        throw argumentProblem(argumentCount, inBracket);
    }

    private int parseNumber(boolean isNegative) throws ParseException {
        StringBuilder sb = new StringBuilder();

        if (isNegative) {
            sb.append('-');
        }

        while (between('0', '9')) {
            sb.append(take());
        }
        if (boolTest("area")) {
            throw parseError("5area5");
        }
        skipWhiteSpace();
        if (between('0', '9')) {
            throw parseError("Spaces in numbers");
        }

        try {
            int num = Integer.parseInt(sb.toString());
            argumentCount++;
            return num;
        } catch (NumberFormatException e) {
            throw parseError("Can not to parse number: " + sb);
        }
    }
}

