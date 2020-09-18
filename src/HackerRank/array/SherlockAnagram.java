package HackerRank.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAnagram {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        Map<String, Integer> strMap = new HashMap<>();
        Integer len = s.length();
        String subStr = "";
        String revsubStr = "";
        Integer count = 0;
        //substr Len, length
        for (int i = 1; i < len; i++) {
            //slide window, index
            for (int j = 0; j + i <= len; j++) {
                subStr = s.substring(j, j + i);
                revsubStr = sorter(subStr);
                if (strMap.containsKey(revsubStr)) {
                    count = count + strMap.get(revsubStr);
                }
                strMap.put(subStr, strMap.getOrDefault(subStr, 0) +1);
            }
        }
        return count;
    }

    private static String sorter(String s) {
        char tempArray[] = s.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        // return new sorted string
        return new String(tempArray);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
