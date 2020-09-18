package HackerRank.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockStr {

    // Complete the isValid function below.
    static String isValid(String s) {
        int[] charArr = new int[26];
        int offset = (int) 'a';
        for (char c : s.toCharArray()) {
            charArr[(int) c - offset]++;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            int cnt = charArr[i];
            if (cnt != 0) { //appears atleast once
                int c = countMap.getOrDefault(cnt, 0) + 1;
                countMap.put(cnt, c);
            }
        }
        ArrayList<Integer> key = new ArrayList<>(countMap.keySet());
        ArrayList<Integer> val = new ArrayList<>(countMap.values());
        if (key.size() <= 2) {
            //if ther r more keys one of them shld be only 1ce and the key diff shld be 1
            if (key.size() == 2) {
                if (Math.abs(key.get(0) - key.get(1)) == 1 && (val.get(0) == 1 || val.get(1) == 1)) {
                    return "YES";

                } else if (Math.abs(key.get(0) - key.get(1)) != 1 && (key.get(0) == 1 &&  val.get(0) == 1)|| (key.get(1) == 1 && val.get(1) == 1)) {
                    return "YES";
                } else {
                    return "NO";
                }
            }
            //1
            return "YES";
        }
        //more cnts
        return "NO";
    }

    public static void main(String[] args) throws IOException {

        System.out.println(isValid("aaaaabc"));

    }
}
