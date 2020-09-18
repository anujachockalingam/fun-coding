/**
 * @author c59785a
 * Created on 2020-09-05 16:11
 **/
public class ShellSort {

    private static void shellSort(int[] arr) {
        return;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
        System.out.println("Array Before Merge Sort");

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        shellSort(arr);
        System.out.println("Array After Merge Sort");

        printArr(arr);
    }




    private static void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
