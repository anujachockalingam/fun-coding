package HackerRank.Tree;

import javax.swing.tree.TreeNode;

/**
 * @author c59785a
 * Created on 2020-09-18 09:56
 **/

/*
 * Java Program to traverse a binary tree
 * using inorder traversal without recursion.
 * In InOrder traversal first left node is visited, followed by root
 * and right node.
 *
 * input:
 *      40
 *     /\
 *    20   50
 *   / \\
 *  10  30   60
 * /   /\
 * 5  67  78
 *
 * output: 5 10 20 30 40 50 60 67 78
 */


class BinaryTree {

    /**
     * Java method to create binary tree with test data
     *
     * @return a sample binary tree for testing
     */
    public static Node create() {
        Node root = new Node(40);
        root.left = new Node(20);
        root.left.left = new Node(10);
        root.left.left.left = new Node(5);
        root.left.right = new Node(30);
        root.right = new Node(50);
        root.right.right = new Node(60);
        root.left.right.left = new Node(67);
        root.left.right.right = new Node(78);
        return root;
    }


    private static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.printf("%s ", node.data);
        inOrder(node.right);
    }

    public static void main(String[] args) throws Exception {
        // construct the binary tree given in question
        Node bt = create();
        // traversing binary tree using InOrder traversal using recursion
        System.out
                .println("printing nodes of binary tree on InOrder using recursion");
        inOrder(bt);
    }
}
