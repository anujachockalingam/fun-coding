package HackerRank.Tree;

/**
 * @author c59785a
 * Created on 2020-09-17 21:19
 **/


import java.util.*;
import java.io.*;

class Height {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static int height(Node root) {
        // Write your code here.
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        } else {
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }

    public static int heightNotRecur(Node root) {
        Queue<Integer> levelQ = new ArrayDeque<Integer>();
        Queue<Node> valQ = new ArrayDeque<Node>();

        valQ.add(root);
        levelQ.add(0);
        Integer currLevel = 0;
        Node curr = null;
        // Write your code here.
       while(!valQ.isEmpty()){
           curr =  valQ.remove();
           currLevel = levelQ.remove();
           if(curr.left != null){
               valQ.add(curr.left);
               levelQ.add(currLevel+1);
           }
           if(curr.right != null){
               valQ.add(curr.right);
               levelQ.add(currLevel+1);
           }
       }
       return currLevel;

    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }


}