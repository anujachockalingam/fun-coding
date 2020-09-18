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

public class altChars {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

        char prev = '\n';
        int count = 0;
        for (Character c : s.toCharArray()) {
            if (c.equals(prev)) {
                //remove
                count++;
            }
            prev = c;

        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int result = alternatingCharacters("BBBBB");

    }
}
