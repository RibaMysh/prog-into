package expression.parser;

public class StringCharSource implements CharSource{
    private String string;
    private int pos;

    public StringCharSource(String s){
        string = s;
    }

    @Override
    public char next() {
        return string.charAt(pos++);
    }
    @Override
    public boolean hasNext() {
        return  pos < string.length();
    }
    @Override
    public IllegalArgumentException error(String message) {
        return new IllegalArgumentException(String.format(
                "%d: %s ( rest of input: %s)",
                pos, message, string.substring(pos)
        ));
    }
}
