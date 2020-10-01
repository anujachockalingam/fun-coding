package HackerRank.Misc;

/**
 * @author c59785a
 * Created on 2020-09-30 20:29
 **/
public class MaxXor {


    static final int INT_SIZE = 32;

    // A Trie Node
    static class TrieNode {
        int value;  // Only used in leaf nodes
        TrieNode[] arr = new TrieNode[2];

        public TrieNode() {
            value = 0;
            arr[0] = null;
            arr[1] = null;
        }

        public String toString() {
            return "{ value: " + this.value + " " + arr.toString() + "}";
        }
    }

    static TrieNode root;

    static void insert(int pre_xor) {
        TrieNode temp = root;

        for (int i = INT_SIZE - 1; i >= 0; i--) {
            int val = (pre_xor & (1 << i)) >= 1 ? 1 : 0;

            if (temp.arr[val] == null)
                temp.arr[val] = new TrieNode();

            temp = temp.arr[val];
        }
        temp.value = pre_xor;
    }

    static int query(int pre_xor) {
        TrieNode temp = root;
        for (int i = INT_SIZE - 1; i >= 0; i--) {
            int val = (pre_xor & (1 << i)) >= 1 ? 1 : 0;

            if (temp.arr[val] != null)
                temp = temp.arr[val];

            else if (temp.arr[1 - val] != null)
                temp = temp.arr[1 - val];
        }
        return (~pre_xor) ^ (temp.value);
    }

    // Complete the maxXor function below.
    static int[] maxXor(int[] arr, int[] queries) {
        int[] result = new int[queries.length];

        root = new TrieNode();
        insert(0);
        int pre_xor = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        for (int j = 0; j < queries.length; j++) {
            pre_xor = ~queries[j];
            //max= Math.max(max, query(pre_xor));
            result[j] = query(pre_xor);
        }
        return result;
    }
}


/*
int a = 4;
int b = 7;
System.out.println(a & b); // prints 4
//meaning in an 32 bit system
// 00000000 00000000 00000000 00000100
// 00000000 00000000 00000000 00000111
// ===================================
// 00000000 00000000 00000000 00000100
 */