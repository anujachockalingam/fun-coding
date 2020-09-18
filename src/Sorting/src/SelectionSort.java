import java.util.stream.StreamSupport;

/**
 * @author c59785a
 * Created on 2020-09-03 22:45
 **/
public class SelectionSort {
    /*

The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order)
from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.

 * Time Complexity
 * Best o(n2)
 * Ave O(n2)
 * Worst O(n2)
 *
 * Space Complexity
 * O(1)

     */

    private static void selectionSortSort(int[] arr) {
        int minVal = Integer.MIN_VALUE;
        int minValIdx = -1;
        int len = arr.length;

        //go thru right part and find least element
        for (int i = 0; i < len; i++){
            minVal = arr[i];
            minValIdx = i;
            for(int j =i +1; j <len; j++){
                if(arr[j] < minVal){
                    minVal = arr[j];
                    minValIdx = j;
                }
            }
            //swap with i
            if(i != minValIdx){
                int temp = arr[i];
                arr[i] = arr[minValIdx];
                arr[minValIdx] = temp;
            }
            printArr(arr);
            System.out.println("\n");

        }

    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
        System.out.println("Array Before SelectionSort Sort");

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        selectionSortSort(arr);
        System.out.println("Array After SelectionSort Sort");

        printArr(arr);
    }

    private static void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
