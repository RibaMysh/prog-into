package expression.generic.spaces;

public interface Space<N extends Number>{
    N add(N x, N y);
    N subtract(N x, N y);
    N multiply(N x, N y);
    N divide(N x, N y);
    N negate(N x);
    N intToType(int x);
    N area(N x, N y);
    N perimeter(N x, N y);
}
