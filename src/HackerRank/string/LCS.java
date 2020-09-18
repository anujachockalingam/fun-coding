package HackerRank.string;

import java.util.Scanner;

/**
 * @author c59785a
 * Created on 2020-09-09 22:31
 * Longest Common Subsequence
 * ACEDBFD, AECDF -> ACDF
 *
 * //https://www.youtube.com/watch?v=DuikFLPt8WQ
 **/
public class LCS {


    static Integer dp[][];
    static int cache[][];

    // Method1()- recursive solution(Top- down approach)
    // time complexity - O(2^(m+n))
    // space complexity - O(m+n)
    public static int LCSM1(char[] X, char[] Y, int i, int j) {
        if (i <= 0 || j <= 0)
            return 0;
        if (X[i - 1] == Y[j - 1])
            return 1 + LCSM1(X, Y, i - 1, j - 1);
        else
            return Math.max(LCSM1(X, Y, i, j - 1), LCSM1(X, Y, i - 1, j));

    }

    // Method2()- recursive solution with memoization
    // time complexity - O(m*n)
    // space complexity - O(m*n)
    public static int LCSM2(char[] X, char[] Y, int i, int j, Integer[][] dp) {
        if (i <= 0 || j <= 0)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        if (X[i - 1] == Y[j - 1])
            return 1 + LCSM2(X, Y, i - 1, j - 1, dp);
        else
            return dp[i][j] = Math.max(LCSM2(X, Y, i, j - 1, dp), LCSM2(X, Y, i - 1, j, dp));

    }

    // Method3()- DP solution(Bottom up approach)
    // time complexity - O(m*n)
    // space complexity - O(m*n)
    public static int LCSM3(char[] X, char[] Y, int m, int n) {
        int memo[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    memo[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                else
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
            }
        }
        cache = memo;
        return memo[m][n];
    }

    // Method4()- DP solution(Bottom up approach)
    // time complexity - O(m*n)
    // space complexity - O(n)
    public static int LCSM4(char[] X, char[] Y, int m, int n) {
        int memo[] = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = memo[j];
                if (X[i - 1] == Y[j - 1]) {
                    memo[j] = prev + 1;
                } else {
                    memo[j] = Math.max(memo[j], memo[j - 1]);
                }
                prev = temp;
            }

//			display1DArray(memo, "");
        }
        return memo[n];
    }

    public static void main(String[] args) {
        String X = "harry";
        String Y = "sally";

        long m1ExecutionTime = method1(X.toCharArray(), Y.toCharArray(), X.length(), Y.length());
        long m2ExecutionTime = method2(X.toCharArray(), Y.toCharArray(), X.length(), Y.length());
        long m3ExecutionTime = method3(X.toCharArray(), Y.toCharArray(), X.length(), Y.length());
        long m4ExecutionTime = method4(X.toCharArray(), Y.toCharArray(), X.length(), Y.length());

        System.out.println("\nAlgorithms                                                    | Execution Time ");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Recursive solution                                            |" + m1ExecutionTime + " ns");
        System.out.println("Top-down with memoization solution                            |" + m2ExecutionTime + " ns");
        System.out.println("DP Bottom-up approach solution                                |" + m3ExecutionTime + " ns");
        System.out.println("DP Bottom-up approach solution (efficient solution)           |" + m4ExecutionTime + " ns");

		displayMemo(cache);

    }

    public static long method1(char[] X, char[] Y, int m, int n) {
        long startTime = 0, endTime = 0;
        startTime = System.nanoTime();
        System.out.println("Recursive solution :LCSM1()");
        System.out.println("output :" + LCSM1(X, Y, m, n));
        endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long method2(char[] X, char[] Y, int m, int n) {
        long startTime = 0, endTime = 0;
        startTime = System.nanoTime();
        dp = new Integer[m + 1][n + 1];
        System.out.println("Top-down with memoization solution :LCSM2()");
        System.out.println("output :" + LCSM2(X, Y, m, n, dp));
        endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long method3(char[] X, char[] Y, int m, int n) {
        long startTime = 0, endTime = 0;
        startTime = System.nanoTime();
        System.out.println("DP Bottom-up approach solution :LCSM3()");
        System.out.println("output :" + LCSM3(X, Y, m, n));
        endTime = System.nanoTime();
        return endTime - startTime;

    }

    public static long method4(char[] X, char[] Y, int m, int n) {
        long startTime = 0, endTime = 0;
        startTime = System.nanoTime();
        System.out.println("DP Bottom-up approach solution (best solution):LCSM4()");
        System.out.println("output :" + LCSM4(X, Y, m, n));
        endTime = System.nanoTime();
        return endTime - startTime;

    }

    private static void displayMemo(int[][] memo) {
        if (memo == null) {
            System.out.println("Table is empty");
            return;
        }
        int rowSize = memo.length;
        int colSize = memo[0].length;
        System.out.println("\nmemo table entry after using bottom-up approach:-\n");
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                System.out.print(String.format("%01d ", memo[row][col]));
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void display1DArray(int[] arr, String delimeter) {
        if (arr == null || arr.length == 0) {
            System.out.println("array is empty");
            return;
        }
        for (int row = 0; row < arr.length; row++) {
            System.out.print(String.format("%01d ", arr[row]) + delimeter);
        }
        System.out.println();
    }
}