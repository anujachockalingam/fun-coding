package HackerRank.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.IntStream;

public class CharacterRepeat {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
   /*     char[] c=s.toCharArray();
        Integer countA=0;
        for(int i=0;i<n;i++){
            if(c[i%s.length()] == 'a'){
                countA++;
            }
        }

    return countA;*/

        long countA = 0;

        //base cases
        if(!s.contains("a")) return 0;

        //logic
        for (int i = 0; i < s.length(); i++) {
            if (s.toCharArray()[i] == 'a') {
                countA++;
            }
        }

        countA = countA * (n / (s.length()));

        for (int i = 0; i < n % (s.length()); i++) {
            if (s.toCharArray()[i] == 'a') {
                countA++;
            }
        }
        return countA;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
