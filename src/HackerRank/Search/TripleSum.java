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

public class TripleSum {

    //https://www.youtube.com/watch?v=pVkHLciuank

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {


        a = Arrays.stream(a).distinct().toArray();
        Arrays.sort(a);
        b = Arrays.stream(b).distinct().toArray();
        Arrays.sort(b);
        c = Arrays.stream(c).distinct().toArray();
        Arrays.sort(c);

        int num = 0;
        int ai = 0;
        int ci = 0;


        for (int i : b) {
            ai = 0;
            while (a[ai] <= i && ai < a.length) {
                ai++;
            }
            ci = 0;
            while (c[ci] <= i && ci < c.length) {
                ci++;
            }
            num = num + (ai * ci);
        }
        return num;

    }


    public static void main(String[] args) throws IOException {
        int[] arra = {1,3,5};
        int[] arrb = {2,3};
        int[] arrc = {1,5,3};
        long ans = triplets(arra, arrb, arrc);
        System.out.println(ans);

    }
}
