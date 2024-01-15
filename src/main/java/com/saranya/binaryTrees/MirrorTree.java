package main.java.com.saranya.binaryTrees;

class Node{
	
	int data;
	Node left;
	Node right;
	
	 public Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
}

class BinaryTree{
	Node root;
	
	void mirror() {
		root = mirror(root);
	}

	Node mirror(Node root) {
		if(root == null) {
			return null;
		}
		
		Node left = mirror(root.left);
		Node right = mirror(root.right);
		
		root.left = right;
		root.right = left;
		
		return root;
	}
	
	void inorder() {
		inorder(root);
	}
	
	void inorder(Node root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.println(root.data + " ");
		inorder(root.right);
	}
}

public class MirrorTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        /* print inorder traversal of the input tree */
        System.out.println(
            "Inorder traversal of the constructed tree is");
        tree.inorder();
        System.out.println("");
 
        /* convert tree to its mirror */
        tree.mirror();
 
        /* print inorder traversal of the minor tree */
        System.out.println(
            "Inorder traversal of the mirror tree is");
        tree.inorder();
	}

}
