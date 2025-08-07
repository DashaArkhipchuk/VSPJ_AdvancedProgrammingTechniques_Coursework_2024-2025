package main;

/**
 * Class for comparing integers and strings
 */
public class ZpracovaniMoje {
    /**
     * Compares two integers
     * @param a first integer
     * @param b second integer
     * @return -1 if a < b, 0 if a == b, 1 if a > b
     */
    public static int comp(int a, int b) {
        return Integer.compare(a,b);
    }

    /**
     * Compares two strings lexicographically
     * @param a the first string
     * @param b the second string
     * @return a negative number if a < b, 0 if a == b, a positive number if a > b
     */
    public static int comp(String a, String b)
    {
        return a.compareTo(b);
    }
}
