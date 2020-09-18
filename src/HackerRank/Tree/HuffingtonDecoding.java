package HackerRank.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.*;


class HuffingtonDecoding {

/*
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;

    	https://en.wikipedia.org/wiki/Huffman_coding

*/

    void decode(String s, Node root) {

        int i = 0;
        Node node = root;
        while (i < s.length()) {
            node = root;
            while (node.left != null || node.right != null) {
                if (s.charAt(i) == '0') {
                    node = node.left;
                } else {
                    node = node.right;
                }
                i++;
            }
            System.out.print(node.data);
        }


    }
}
