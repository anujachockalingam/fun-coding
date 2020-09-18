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

public class FrequencyQueries {

    //https://www.youtube.com/watch?v=CM6VqY6W5cw

    // Complete the freqQuery function below.
    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {

        List<Integer> counts = new ArrayList<>();
        Map<Integer, Integer> vFreqMap = new HashMap<>();
        for (List<Integer> q : queries) {
            Integer m =0;
            if(q.get(0) == 1){
                //add
                if(vFreqMap.containsKey(q.get(1))){
                    m = vFreqMap.getOrDefault(q.get(1), 0);
                    m = m + 1;
                    vFreqMap.put(q.get(1), m);
                }else{
                    vFreqMap.put(q.get(1), 1);
                }
            } else if (q.get(0) == 2){
                //remove
                if(vFreqMap.containsKey(q.get(1))){
                    m = vFreqMap.getOrDefault(q.get(1), 0);
                    m = m -1;
                    if (m > 0) {
                        vFreqMap.put(q.get(1), m);
                    } else {
                        vFreqMap.remove(q.get(1));
                    }
                }
            }else if (q.get(0) == 3){
                if(queries.size() < q.get(1)){
                    System.out.println(0);
                    counts.add(0);
                } else if (vFreqMap.values().contains(q.get(1))) {
                    System.out.println(1);
                    counts.add(1);
                } else {
                    System.out.println(0);
                    counts.add(0);
                }
            }
        }


        return counts;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
