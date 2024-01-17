package main.java.com.saranya.binaryTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement - Given a binary tree, and two values v1 and v2, find the lowest common ancestor of nodes with their values as v1 and v2.

 * Where the lowest common ancestor of two nodes (Node1 and Node2) is the deepest node of which Node1 and Node2 are descendants. 
 * Note that here we consider that a node is the descendant of itself also.
 * 
 * 
 *          Making the following tree
                     1
          	    	/ \
         	       /   \
         	  	  2     3
             	 / \     \
                /   \     \
               4     5     6
               \         / \
                \       /   \
                 7     8     9
 *
 *
 * LCA of 4 and 5 is 2
 * LCA of 7 and 4 is 4
 * LCA of 5 and 8 is 1
 * LCA of 5 and 10 is -1 //Invalid Input
 * 
 * Explanation for (4,5)
 * ------------------------
 * Find the path from the root node to the node with value 4. path1 = [1→2→4]
 * Find the path from the root node to the node with value 5. path2 = [1→2→5]
 * Now, we traverse both the lists till the path is the same (the value of nodes in the path is the same in both lists). 
 * Therefore at the 2nd index (0-based), we found a mismatch, and hence we will return the value just before the 2nd index. i.e. 2.
 * 
 */
public class LowestCommonAncestorBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		root.left.left.right = new Node(7);
	    root.right.right.left = new Node(8);
        root.right.right.right = new Node(9);
        
        System.out.println("LCA of 4 and 5 is " +
		                LCA (root, 4, 5));
        System.out.println("");
		System.out.println("LCA of 7 and 4 is " +
		                LCA (root, 7, 4));
		System.out.println("");
		System.out.println("LCA of 5 and 8 is " +
		                LCA (root, 5, 8));
		System.out.println("");
		// Passing the wrong input
		System.out.println("LCA of 5 and 10 is " +
		                LCA (root, 5, 10));
	}

	// Helper function to find the LCA
	private static int LCA(Node root, int n1, int n2) {
		List<Integer> path1 = new ArrayList<>();
		List<Integer> path2 = new ArrayList<>();
		
        // Using a function to find the path from root to n1 or n2.
		if(!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
			return -1;
		}
		int i;
		// Now iterate over the path list found.
		for(i=0; i<path1.size() && i<path2.size(); i++) {
			if(path1.get(i)!=path2.get(i)) {
				break;
			}
		}
        // Return the node encountered just before the mismatch
		return path1.get(i-1);
	}

	// Function to find the path from the root node to the target node. 
	private static boolean findPath(Node root, int val, List<Integer> path) {
		
		// Returning false if we encounter a null node.
		if(root == null) {
			return false;
		}
		path.add(root.data); //add the root.data to the list "path"
		
		// Returning true, if we encounter the target node.
		if(root.data==val) {
			System.out.println("The path between 1"+","+val+" is");
			System.out.println(Arrays.toString(path.toArray()));
			return true;
		}
		
        // Iterate the subtree of root recursively and return true if we find the target node in any of the subtree.
		if(findPath(root.left, val, path) || findPath(root.right, val, path)) {
			return true;
		}
		
		// Backtrack by removing the last element of the path list. Because of we found the value, it will get it added in the list at line number 86.
		path.remove(path.size()-1);
		
		// Returning false if nothing worked out.
		return false;
	}

}
