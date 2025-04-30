package expression.generic.parserGeneric;


import expression.exceptions.madenException.ParseException;

import java.util.List;
import java.util.Map;


/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class BaseParser {
    private static final char END = '\0';
    private final CharSource source;
    private char ch = 0xffff;

    private final List<Character> operations = List.of('+', '*', '/', '-');
    protected final List<Character> parenthesis = List.of('(', ')', '[', ']', '{', '}');
    private final Map<Integer, String> intToPlace = Map.of(1, "first", 2, "second", 3, "last");

    protected BaseParser(final CharSource source) {
        this.source = source;
        take();
    }

    protected char take() {
        final char result = ch;
        ch = source.hasNext() ? source.next() : END;
        return result;
    }


    protected boolean test(final char expected) {
        return ch == expected;
    }

    protected boolean take(final char expected) {
        if (test(expected)) {
            take();
            return true;
        }
        return false;
    }

    protected String test(final String expected) throws ParseException {
        int startPose = source.getPose();
        for (char c : expected.toCharArray()) {
            if (!take(c)) {
                source.setPose(startPose);
                return "";
            }
        }
        if (Character.isDigit(ch)) {
            throw parseError("number after area");
        }
        return expected;

    }

    protected boolean boolTest(final String expected) {
        int startPose = source.getPose();
        for (char c : expected.toCharArray()) {
            if (!take(c)) {
                source.setPose(startPose);
                return false;
            }
        }

        source.setPose(startPose);
        return true;

    }


    protected boolean eof() {
        return take(END);
    }

    protected IllegalArgumentException error(final String message) {
        return source.error(message);
    }

    protected boolean between(final char from, final char to) {
        return from <= ch && ch <= to;
    }

    protected void skipWhiteSpace() {
        while (Character.isWhitespace(ch)) {
            take();
        }
    }

    protected boolean in(final String s) {
        return s.contains(String.valueOf(ch));
    }

    protected boolean isAlpha() {
        return Character.isAlphabetic(ch);
    }

    protected String getVar() throws ParseException {
        StringBuilder sb = new StringBuilder();
        while (Character.isAlphabetic(ch)) {
            sb.append(take());
        }

        String s = sb.toString();
        char lastChar = s.charAt(s.length() - 1);
        if (lastChar != 'x' && lastChar != 'y' && lastChar != 'z') {
            throw parseError("Unknown variable");
        }
        return s;
    }


    protected ParseException parseError(final String message) {
        return new ParseException(message);
    }


    protected boolean contain(List<Character> list) {
        return list.contains(ch);
    }


    protected void checkValid() throws ParseException {
        if (!isAlpha() && !between('0', '9') && !contain(operations) && !contain(parenthesis) &&
                !boolTest("area") && !boolTest("perimeter")) {
            throw parseError("bad symbol: " + ch);
        }
    }


    protected ParseException argumentProblem(int argumentPlace, final boolean inBracket) {
        String message = "No " + intToPlace.get(argumentPlace % 3 + 1) + " argument";
        return inBracket ? new ParseException(message + "'") : new ParseException(message);
    }

    protected boolean isOpenPar() {
        return ch == '(' || ch == '[' || ch == '{';
    }


}
