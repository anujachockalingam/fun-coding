

/**
 * @author c59785a
 * Created on 2020-09-03 22:24
 * Bubble sort compares adjacent elements of an array and organizes those elements. Its name comes from the fact that large numbers tend to “float” (bubble) to the top
 *
 * Time Complexity
 * Best o(n)
 * Ave O(n2)
 * Worst O(n2)
 *
 * Space Complexity
 * O(1)
 *
 **/
public class Bubble {

    private static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean swapped = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (swapped) {
                swapped = false;
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                    }
                }
                System.out.print(i + "-");
                printArr(arr);
                System.out.println("\n");
            }else
                break;

        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
        System.out.println("Array Before Bubble Sort");

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        bubbleSort(arr);
        System.out.println("Array After Bubble Sort");

        printArr(arr);
    }

    private static void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
