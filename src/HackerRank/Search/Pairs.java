package HackerRank.Search;

import java.util.HashSet;
import java.util.Set;

/**
 * @author c59785a
 * Created on 2020-09-16 16:23
 * //https://www.youtube.com/watch?v=Xct9C86nsdo
 *
 **/


public class Pairs {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {

        Set<Integer> l = new HashSet<>();
        int numPairs = 0;
        for (int i = 0; i < arr.length; i++) {
            l.add(arr[i]);
        }

        for (Integer i : l) {

            if (l.contains(i + k)) {
                numPairs++;
            }

        }
        return numPairs;

    }
}
