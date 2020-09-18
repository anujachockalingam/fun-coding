/**
 * @author c59785a
 * Created on 2020-09-03 22:43
 * <p>
 * Insertion sort is the sorting mechanism where the sorted array is built having one item at a time. The array elements are compared with each other sequentially and then arranged simultaneously in some particular order.
 * The analogy can be understood from the style we arrange a deck of cards.
 * This sort works on the principle of inserting an element at a particular position, hence the name Insertion Sort.
 * <p>
 * <p>
 * Worst Case Time Complexity [ Big-O ]: O(n2)
 * <p>
 * Best Case Time Complexity [Big-omega]: O(n)
 * <p>
 * Average Time Complexity [Big-theta]: O(n2)
 *
 * https://www.interviewbit.com/tutorial/insertion-sort-algorithm/
 **/
public class Insertion {


    private static void insSort(int[] arr) {
        int len = arr.length;


        //go thru unsorted parts
        for (int which = 1; which < len; which++) {
            int val = arr[which];

            int j = which -1;
            //go thru sorted parts to find the place
            //copy or move i+1 to which  -1 by 1 place & insert val in i+1
            //START FROM BACK TO MAKE BEST CASE 0(n)
            while (j >= 0 && arr[j] > val) {
                arr[j+1]=arr[j];
                j =j-1;
            }
            arr[j+1] = val;

     /*       //go thru sorted parts to find the place
            for(int i = which - 1; i >=0; i--){
                if(arr[i] < val ){
                    //copy or move i+1 to which  -1 by 1 place & insert val in i+1
                    for(int j = which -1; j >= i+1; j--){
                        arr[j+1]= arr[j];
                    }
                    //System.arraycopy(arr,i,arr,i+1,which-1);
                    //move val ti ith postion
                    arr[i+1] = val;
                    break;
                }
            }*/
            printArr(arr);

        }

    }

    public static void main(String[] args) {
        int arr[] = {2, 5, -2, 6, -3, 8, 0, -7, -9, 4};
        System.out.println("Array Before Insertion Sort");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        insSort(arr);
        System.out.println("Array After Insertion Sort");
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
