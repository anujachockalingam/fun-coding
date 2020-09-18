package HackerRank.array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.IntStream;

public class RansomeNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> mCountMap = createMap(magazine);
        Map<String, Integer> nCountMap = createMap(note);

        Boolean broke = false;

        for (String w : nCountMap.keySet()) {
            if (nCountMap.get(w) > mCountMap.getOrDefault(w, 0)) {
                broke = true;
                break;
            }
        }

        if (broke) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }


    }


    private static Map<String, Integer> createMap(String[] x) {
        Map<String, Integer> mCountMap = new HashMap<>();

        for (String m : x) {
            Integer c = mCountMap.getOrDefault(m,0);
            mCountMap.put(m, ++c);
        }
        return mCountMap;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
