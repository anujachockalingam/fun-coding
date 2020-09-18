package HackerRank.Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author c59785a
 * Created on 2020-09-17 21:00
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 **/


class StockSpan {
    // method to calculate stock span values

    /*
    Time Complexity: O(n). It seems more than O(n) at first look. If we take a closer look, we can observe that every element of the
    array is added and removed from the stack at most once.
    So there are total 2n operations at most. Assuming that a stack operation takes O(1) time, we can say that the time complexity is O(n).

    Auxiliary Space: O(n) in worst case when all elements are sorted in decreasing order.

    Another approach: (without using stack)
     */
    static void calculateSpan1(int price[], int n, int S[]) {
        // Create a stack and push index of first element
        // to it
        Stack<Integer> st = new Stack<>();
        st.push(0);

        // Span value of first element is always 1
        S[0] = 1;

        // Calculate span values for rest of the elements
        for (int i = 1; i < n; i++) {

            // Pop elements from stack while stack is not
            // empty and top of stack is smaller than
            // price[i]
            while (!st.empty() && price[st.peek()] <= price[i])
                st.pop();

            // If stack becomes empty, then price[i] is
            // greater than all elements on left of it, i.e.,
            // price[0], price[1], ..price[i-1]. Else price[i]
            // is greater than elements after top of stack
            S[i] = (st.empty()) ? (i + 1) : (i - st.peek());

            // Push this element to stack
            st.push(i);
        }
    }

    /*
    A Simple but inefficient method
Traverse the input price array. For every element being visited,
traverse elements on left of it and increment the span value of it while elements on the left side are smaller.


     */
    static void calculateSpan2(int price[], int n, int S[]) {
        // Span value of first day is always 1
        S[0] = 1;

        // Calculate span value of remaining days by linearly checking
        // previous days
        for (int i = 1; i < n; i++) {
            S[i] = 1; // Initialize span value

            // Traverse left while the next element on left is smaller
            // than price[i]
            for (int j = i - 1; (j >= 0) && (price[i] >= price[j]); j--)
                S[i]++;
        }
    }

    // A utility function to print elements of array
    static void printArray(int arr[]) {
        System.out.print(Arrays.toString(arr));
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        // [1, 1, 2, 4, 5, 1]
        int price[] = {10, 4, 5, 90, 120, 80};
        int n = price.length;
        int S[] = new int[n];

        // Fill the span values in array S[]
        calculateSpan1(price, n, S);
        calculateSpan2(price, n, S);
        // print the calculated span values
        printArray(S);
    }
}
// This code is contributed by Sumit Ghosh