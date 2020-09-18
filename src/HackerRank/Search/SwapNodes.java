/*
package Search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class Node {
    int right;
    int left;
    int data;
    int depth;

    Node(int left, int right, int data, int depth) {
        this.left = left;
        this.right = right;
        this.data = data;
        this.depth = depth;
    }
}

public class SwapNodes {


    */
/*
     * Complete the swapNodes function below.
     *//*

    static int[][] swapNodes(int[][] indexes, int[] queries) {

        //create tree
        Node[] tree = new Node[indexes.length];

        for (int i = 0; i < indexes.length; i++) {
            tree[i] = new Node(indexes[i][0], indexes[i][1]);
        }

        //swapnodes

        for (int j = 0; j < queries.length; j++) {
            swapLR(tree, j);
            printTree(tree);
        }

        //TODO
        return new int[1][2];
    }

    static int[] printTree(Node[] tree) {


    }

    static void swapLR(Node[] tree, int query) {
        if (query == 1) {
            //do nothing as only one node
            return;
        }

        int level = query - 2;
        int start = (int) Math.pow(2, level);
        for (int i = 0; i < start; i++) {
            int temp = tree[start + i].right;
            tree[start + i].right = tree[start + i].left;
            tree[start + i].left = temp;
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
*/
