package main.java.com.saranya.binaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * Given a Binary Tree, find Right view of it. Right view of a Binary Tree is set of nodes visible when tree is viewed from right side.
 * Right view of following tree is 1 3 7 8.
 *
 *         1
 *      /     \
 *     2        3
 *   /   \     / \
 *  4     5   6   7
 *   \
 *    8
 *
 */
public class RightViewBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.right = new Node(8);
		List<Integer> result = new ArrayList<>();
		System.out.println(rightView(root,0,result));
	}

	private static String rightView(Node root, int currentDepth, List<Integer> result) {
		if(root == null) {
			return null;
		}
		if(currentDepth==result.size()) {
			result.add(root.data);
		}
		rightView(root.right, currentDepth+1, result);
		rightView(root.left, currentDepth+1, result);
		return result.stream().map(String::valueOf).collect(Collectors.joining(","));
	}

}
