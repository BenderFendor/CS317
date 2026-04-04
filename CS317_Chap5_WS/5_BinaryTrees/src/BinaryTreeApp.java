//TODO 1: Does the following program generate correct height values for the
//binary trees? If not, revise the getHeight() method in BinaryTree.java

//TODO 2: Add a getNumOfLeaves() to the BinaryTree class to calculate the
//		number of leaves of a binary tree.
public class BinaryTreeApp {
    public static void main(String[] args) {
        BinaryTree tree1 = createBinaryTree_1Node();
        BinaryTree tree2 = createBinaryTree_2Nodes();
    	BinaryTree tree = createBinaryTree();
        
        // get the height of the binary tree and print it
        int height1 = tree1.getHeight(tree1.root);
        System.out.println("Height of the binary tree is: " + height1);
        
     // get the height of the binary tree and print it
        int height2 = tree2.getHeight(tree2.root);
        System.out.println("Height of the binary tree is: " + height2);
        
     // get the height of the binary tree and print it
        int height = tree.getHeight(tree.root);
        System.out.println("Height of the binary tree is: " + height);
             
    }//end main()
    
    public static BinaryTree createBinaryTree_1Node() {
    	
    	BinaryTree tree = new BinaryTree();
    	tree.root = new Node(1);
    	return tree;   	
    }
    
    public static BinaryTree createBinaryTree_2Nodes() {
    	
    	BinaryTree tree = new BinaryTree();
    	tree.root = new Node(1);
    	tree.root.left = new Node(2);
    	return tree;   	
    }
    
    public static BinaryTree createBinaryTree() {
    	BinaryTree tree = new BinaryTree();
    	 
        // create a sample binary tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        return tree;
    }
    
}//end class BinaryTreeApp
