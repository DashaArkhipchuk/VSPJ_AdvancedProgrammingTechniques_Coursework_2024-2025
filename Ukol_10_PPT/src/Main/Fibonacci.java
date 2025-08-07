package Main;

/**
 * The Fibonacci class provides methods to calculate Fibonacci numbers
 * using different approaches: non-recursive, recursive, and dynamic programming.
 */
public class Fibonacci {

    // Table to store computed Fibonacci values for dynamic programming
    private int[] table;

    /**
     * Calculates the n-th Fibonacci number using an iterative (non-recursive) approach.
     *
     * @param n the index of the Fibonacci number
     * @return the n-th Fibonacci number
     */
    public int calcNonRecursively(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    /**
     * Calculates the n-th Fibonacci number using recursion.
     *
     * @param n the index of the Fibonacci number
     * @return the n-th Fibonacci number
     */
    public int calcRecursively(int n) {
        if (n <= 1) {
            return n;
        }
        return calcRecursively(n - 1) + calcRecursively(n - 2);
    }

    /**
     * Initializes the table used for dynamic programming.
     * Prepares space for Fibonacci numbers up to index 999.
     */
    public void Init() {
        table = new int[1000];
        table[0] = 0;
        table[1] = 1;
    }

    /**
     * Calculates the n-th Fibonacci number using dynamic programming.
     * If the table is not initialized, it initializes it first.
     *
     * @param n the index of the Fibonacci number
     * @return the n-th Fibonacci number
     */
    public int calcRecursivelyTable(int n) {
        if (table == null) {
            Init();
        }

        if (n <= 1) {
            return table[n];
        }

        // Fill the table up to index n
        for (int i = 2; i <= n; i++) {
            if (table[i] == 0) {
                table[i] = table[i - 1] + table[i - 2];
            }
        }
        return table[n];
    }

    /**
     * Prints the current contents of the Fibonacci table.
     * Useful for debugging.
     */
    public void printTable() {
        if (table != null) {
            for (int i = 0; i < table.length; i++) {
                if (table[i] != 0) {
                    System.out.print(table[i] + " ");
                }
            }
            System.out.println();
        }
    }
}