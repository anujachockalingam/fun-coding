package HackerRank.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class specialStr {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
       int count=0;
       int len = s.length();
       //
        for(int i =0; i <len; i++){
            //add for single chars
            count++;
            for(int j =i+1; j<len;j++){
                //aabaaa
                if(s.charAt(i) != s.charAt(j)){
                    //check if odd an dmiddle char
                    int halfLen = j-1-i;
                    //check i to j-1 and j+1 to 2*j-i ..
                    //j+1+j-1-i ie 2j-i
                    if(2*j-i < len && s.substring(i, j).equals(s.substring(j+1, 2*j-i+1))){
                        count++;
                        break; // as future chars cant be special
                    }else{
                        break;
                    }

                }else{
                    count++;
                }
            }
        }

       return count;
    }




    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        long result = substrCount(5, "asasd");

    }
}
