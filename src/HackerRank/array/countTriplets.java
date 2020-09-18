package HackerRank.array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class countTriplets {

    //https://www.youtube.com/watch?v=tBFZMaWP0W8

    static long countTriplets(List<Long> arr, long r) {
        long count = 0;
        Long c = 0L;

        Map<Long, Long> rMap = new HashMap<>();
        Map<Long, Long> lMap = new HashMap<>();
        for (Long i : arr) {
            rMap.put(i, rMap.getOrDefault(i, 0L) + 1);
        }

        for (Long i : arr) {
            //decrement r Map , Inc L Map
            rMap.put(i, rMap.get(i) - 1);

            if (lMap.containsKey(i / r) && i % r == 0 && rMap.containsKey(i * r)) {
                count = count + (lMap.get(i / r) * rMap.get(i * r));
            }

            lMap.put(i, lMap.getOrDefault(i, 0L) + 1);

        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
