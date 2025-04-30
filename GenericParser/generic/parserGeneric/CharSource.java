package expression.generic.parserGeneric;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface CharSource {
    boolean hasNext();
    char next();
    IllegalArgumentException error(String message);

    int getPose();
    void setPose(int newPose);
}
