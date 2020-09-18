package HackerRank.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class anagram {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        Map<Character, Integer> alphaMap = new HashMap<>();
        for (Character c : a.toCharArray()) {
            int x = alphaMap.getOrDefault(c, 0) + 1;
            alphaMap.put(c, x);
        }
        for (Character c : b.toCharArray()) {
            int x = alphaMap.getOrDefault(c, 0) - 1;
            alphaMap.put(c, x);
        }

        int count = 0;
        for (Character c : alphaMap.keySet()) {

            count = count + Math.abs(alphaMap.get(c));

        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
