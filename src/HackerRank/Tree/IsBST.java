package HackerRank.Tree;

/**
 * @author c59785a
 * Created on 2020-09-18 09:31
 **/
public class IsBST {

    boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkBST(Node node, int min, int max){
        if(node == null){
            return true;
        }

        return (node.data > min && node.data < max) && checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
    }


}
