package HackerRank.Search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinTimeRequired {
    //https://www.hackerrank.com/challenges/minimum-time-required/forum/comments/576047

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        long dayNum = binSearch(machines, goal);
        return dayNum;
    }

    private static long binSearch(long[] machines, long goal) {
        long minDays = 0;
        long maxDays = machines[machines.length - 1] * goal;
        long result = -1;
        while (minDays < maxDays) {
            long midDays = (maxDays + minDays) / 2;
            //check? how many items in mid days
            long units = checkNumItem(midDays, machines);
            if (units < goal) {
                minDays = midDays + 1;
            } else {
                maxDays = midDays;
                result = midDays;
            }
        }
        return result;
    }

    private static long checkNumItem(long days, long[] machines) {
        long sum = 0;
        for (long machine : machines) {
            sum += Math.floor(days / machine);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        long[] machines = new long[] {4,5,6};
        long goal = 12;

        long ans = minTime(machines, goal);

    }
}

