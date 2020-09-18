package HackerRank.string;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * @author c59785a
 * Created on 2020-09-09 22:21
 **/
public class commonChild {
    //https://www.youtube.com/watch?v=ItRZRx8kvwY
    //https://www.youtube.com/watch?v=ItRZRx8kvwY

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        int count1 = 0;
        int count2 = 0;

        int right = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = right; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    count1++;
                    right = j + 1;
                    break;
                }

            }
        }
        int left = 0;
        for (int i = 0; i < s2.length(); i++) {
            for (int j = left; j < s1.length(); j++) {
                if (s2.charAt(i) == s1.charAt(j)) {
                    count2++;
                    left = j + 1;
                    break;
                }
            }
        }
        return Math.max(count1, count2);
    }


    public static void main(String[] args) {
        System.out.println(commonChild("SHINCHAN", "NOHARAAA"));

    }
}
