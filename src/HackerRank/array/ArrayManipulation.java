package HackerRank.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulate(int n, int[][] queries) {

        //create an empty arr of 1 element - indexList
        int[] valList = new int[n + 1];

        int idx1 = 0;
        int idx2 = 0;
        int val = 0;
        for (int i = 0; i < queries.length; i++) {
            idx1 = queries[i][0];
            idx2 = queries[i][1];
            val = queries[i][2];
            valList[idx1] = valList[idx1] + val;
            valList[idx2] = valList[idx2] + val;
        }

        Integer maxVal = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (valList[i] > maxVal) {
                maxVal = valList[i];
            }
        }
        return maxVal;
    }


    public static void main(String[] args) throws IOException {

        int[][] arr = new int[2][3];
        arr[0][0] = 1;
        arr[0][1] = 5;
        arr[0][2] = 3;

        arr[1][0] = 4;
        arr[1][1] = 8;
        arr[1][2] = 7;

        arrayManipulate(10, arr);


    }
}
