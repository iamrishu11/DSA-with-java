/*
Memoization is an optimization technique used in dynamic programming to avoid redundant calculations by storing previously computed results.
This is especially useful in problems with overlapping subproblems, like the Fibonacci sequence or the Knapsack problem.
*/

import java.util.HashMap;

public class Fibonacci {
    private HashMap<Integer, Long> memo;

    public Fibonacci() {
        memo = new HashMap<>();
    }

    public long fib(int n) {
        // Base cases
        if (n <= 1) return n;

        // Check if the value is already computed
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Compute the value and store it in the memoization map
        long result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int n = 50; // Example input
        System.out.println("Fibonacci of " + n + " is: " + fibonacci.fib(n));
    }
}
