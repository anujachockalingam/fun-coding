package HackerRank.Tree;

class LCA {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        if (root == null) {
            return root;
        }

        while (true) {
            if (root.data > v1 && root.data > v2) {
                root = root.left;
            } else if (root.data < v1 && root.data < v2) {
                root = root.right;
            } else {
                return root;
            }
        }
    }

    static Node lcaRec(Node root,int v1,int v2)
    {
        //Decide if you have to call rekursively
        //Samller than both
        if(root.data < v1 && root.data < v2){
            return lcaRec(root.right,v1,v2);
        }
        //Bigger than both
        if(root.data > v1 && root.data > v2){
            return lcaRec(root.left,v1,v2);
        }

        //Else solution already found
        return root;
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