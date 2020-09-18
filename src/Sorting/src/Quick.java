/**
 * @author c59785a
 * Created on 2020-09-03 22:46
 *
 * Quicksort is one of the most efficient sorting algorithms, and this makes of it one of the most used as well.
 * The first thing to do is to select a pivot number, this number will separate the data, on its left are the numbers smaller than it and the greater numbers on the right.
 * With this, we got the whole sequence partitioned.
 *
 * best O(nlog n)
 * best O(nlog n)
 * worst O(n2)
 *
 * Space Complexity logn
 * The space complexity is calculated based on the space used in the recursion stack.
 * https://www.interviewbit.com/tutorial/quicksort-algorithm/
 **/
public class Quick {

    private static int[] quickSort(int[] arr) {

        if(arr.length <2 ){
            return arr;
        }

        int pivotIdx = arr.length/2;
        int pivot = arr[pivotIdx];

        //count elements less thn pivot
        int leftCount = 0;

        for (int i =0; i < arr.length; i++){
            if(arr[i] < pivot)
                leftCount++;
        }

        //create new arrays

        int[] left = new int[leftCount];
        int[] right = new int[arr.length-leftCount-1];

        int l =0;
        int r =0;

        for (int i =0; i < arr.length; i++){
            if(arr[i] < pivot){
                continue;
            } else if(arr[i] < pivot){
                left[l] = arr[i];
                l++;
            }else{
                right[r] = arr[i];
                r++;
            }
        }

        //continue quick sort of parts

        quickSort(left);
        quickSort(right);


        //put them togther in a sorted way
        //0 to leftCount -1 , pivot and right

        System.arraycopy(left, 0, arr, 0, left.length);
        arr[left.length] = pivot;
        System.arraycopy(right, 0, arr,left.length+1 , right.length);
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
        System.out.println("Array Before Quick Sort");

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        quickSort(arr);
        System.out.println("Array After Qucik Sort");

        printArr(arr);
    }



    private static void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
