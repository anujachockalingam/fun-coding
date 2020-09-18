/**
 * @author c59785a
 * Created on 2020-09-03 22:46
 *
 *
Merge sort is one of the most efficient sorting algorithms.
It works on the principle of Divide and Conquer.
Merge sort repeatedly breaks down a list into several sublists until each sublist consists of a single element and
merging those sublists in a manner that results into a sorted list.

 Best case nlogn

 Avg case n logn n

  ---> Worst case  nlogn not n2

 space complexity worst is o(n)



 **/
public class Merge {

    private static int[] mergeSort(int[] arr) {

        if(arr.length < 2)
            return arr;

        int mid = arr.length/2;

        int[] left = new int[mid];
        int[] right = new int[arr.length-mid];

        System.arraycopy(arr,0,left,0,left.length);
        System.arraycopy(arr,mid,right,0,right.length);

        mergeSort(left);
        mergeSort(right);

        return merge(arr,left,right);

    }

    private static int[] merge(int[] arr, int[] left, int[] right) {
        int lidx = 0;
        int ridx = 0;
        int idx  = 0;

        //copy elements from left and right to arr
        while(lidx < left.length && ridx < right.length){

            if(left[lidx] < right[ridx]){
                arr[idx++] = left[lidx++];
            }else {
                arr[idx++] = right[ridx++];
            }
        }
        while(lidx < left.length){
            arr[idx++] = left[lidx++];
        }

        while(ridx < right.length) {
            arr[idx++] = right[ridx++];
        }
        return arr;
    }


    public static void main(String[] args) {
        int arr[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
        System.out.println("Array Before Merge Sort");

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        mergeSort(arr);
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
