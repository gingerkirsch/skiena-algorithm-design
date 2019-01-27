package chapter1;

public class Ops {

    // Write a function to perform integer division without using either the / or * operators. Find a fast way to do it.
    public static int div(int n, int m) throws IllegalArgumentException {
        if (m == 0) throw new IllegalArgumentException("Division by zero");
        if (n == 0) return 0;
        if (m > n) return 0;
        return 1 + div(n-m,m);
    }

    public static int mod(int n, int m) throws IllegalArgumentException {
        if (m == 0) throw new IllegalArgumentException("Division by zero");
        if (n == 0) return 0;
        if (n < m) return n;
        return mod(n-m,m);
    }
}
