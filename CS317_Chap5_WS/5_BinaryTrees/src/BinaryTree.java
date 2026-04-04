// Node class
class Node {
        int value;
        Node left, right;
 
        public Node(int value) {
            this.value = value;
            left = right = null;
        }
}//end of class Node

//BinaryTree class
public class BinaryTree {
    Node root;

    /**
     * getHeight(): get the height of the binary tree rooted at node
     * @param node
     * @return height of the tree rooted at node.
     * 		Note that the height of an empty tree and a one-node tree are both 0.
     */
    public int getHeight(Node node) {
        if (node == null) { //empty tree
            return 0;
        } 
        else if (node.left == null && node.right == null) {//one-node tree)
        	return 0;
        }
        else {
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
 
            // return the maximum height between the left and right subtrees
            return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
        }
    }//end getHeight()
    

}//end of BinaryTree class
