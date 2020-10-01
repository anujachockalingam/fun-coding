package HackerRank.string;

/**
 * @author c59785a
 * Created on 2020-09-24 19:55
 * basis in backtracking.
 *
 * Below are the permutations of string ABC.
 * ABC ACB BAC BCA CBA CAB
 *
 *
 * fix positions of first chars and then swap pthers
 * https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 *
 **/
public class Permutations {

     static void permutate(String str){

        permutate(str,0, str.length()-1);

    }

    private static void permutate(String str, int s, int e) {

        if(s==e){
            System.out.println(str);
        }else{
            for(int i=s; i<=e;i++){
                str=swap(str,i,s);
                permutate(str,s+1,e);
                str=swap(str,i,s);
            }
        }

    }

    private static String swap(String str, int i, int s) {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i]=arr[s];
        arr[s]=temp;
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        String str = "ABC";
        int n = str.length();
        permutate(str);
    }

}
