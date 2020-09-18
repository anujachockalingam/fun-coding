package HackerRank.Search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://www.youtube.com/watch?v=u_ft5jCDZXk&feature=youtu.be
//https://www.hackerrank.com/challenges/maximum-subarray-sum/forum/comments/800618

public class MaxSubArrMod {

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {
        //kaden method does not work here.
        long currMod = 0;
        long max = 0;
        TreeSet<Long> prefix = new TreeSet<>();
        for (int i = 0; i < a.length; i++) {
            currMod = (currMod + a[i]) % m;
            max = Math.max(currMod, max);
            Long minHigh = prefix.higher(currMod);
            if (minHigh != null) {
                max = Math.max(max, (currMod - minHigh + m) % m);
            }
            prefix.add(currMod);
        }
        return max;
    }

}

