import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/*
expenditure <=200 hence use a counting sort
 */

public class CountSort {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int count = 0;
        int len = expenditure.length;
        //if arr is smaller thn d then return 0
        if (len == d) {
            return 0;
        }

        //longer

        // counting sort arr
        int temp[] = new int[201];
        // initilize to 0

        for (int i = 0; i <= 201; i++) {
            temp[i] = 0;
        }


        for (int i = 0; i < d; i++) {
            temp[expenditure[i]]++;
        }

        int med = median(temp, d / 2 + d % 2);

        //remaining d to len-1
        for (int i = d; i < len; i++) {

            //d is even
            if (d % 2 == 0) {
                int temp_med = median(temp, d / 2 + 1);
                if (expenditure[i] >= med + temp_med)
                    count++;
            } else {
                //d is odd
                if (expenditure[i] >= med * 2)
                    count++;
            }

            temp[expenditure[i - d]]--;
            temp[expenditure[i]]++;
            med = median(temp, d / 2 + d % 2);
        }
        return count;

    }

    static private int median(int temp[], int mid) {
        int med = 0;
        int sum = 0;

        //ordered count of elements.. ount till u hit mid
        for (int i = 0; i <= 200; i++) {
            sum = sum + temp[i];
            if (sum >= mid) {
                med = i;
                break;
            }
        }
        return med;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
