package main.java.com.saranya.LinkedList;

/**
 * 
 * Given a linked list of N nodes. The task is to reverse this list.
 * 
 * Example 1:
 * 
 * Input: LinkedList: 1->2->3->4->5->6 
 * Output: 6 5 4 3 2 1 
 * Explanation: After reversing the list, elements are 6->5->4->3->2->1.
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next = new Node(4);
		head.next.next.next = new Node(5);
		head.next.next.next.next = new Node(6);
		Node FlippedNode = solutionWithFlipTheOrder(head);
		System.out.println(FlippedNode.toString());
		
		Node revisedHead = solutionWithRecursive();
		System.out.println(revisedHead.toString());
	}

	private static Node solutionWithRecursive() {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next = new Node(4);
		head.next.next.next = new Node(5);
		head.next.next.next.next = new Node(6);
		Node newHead = recurse(head);
		return newHead;
	}

	private static Node recurse(Node head) {
		// Base case:
        // If the linked list is empty or has only one node, return the head as it is already reversed.
		if(head == null || head.next == null) {
			return head;
		}
		
        // Recursive step:
        // Reverse the linked list starting from the second node (head.next).
		Node newHead = recurse(head.next); 
		Node front = head.next; // Save a reference to the node following the current 'head' node.
		front.next = head; // Make the 'front' node point to the current 'head' node in the reversed order.
		head.next = null; // Break the link from the current 'head' node to the 'front' node to avoid cycles.
		return newHead; // Return the 'newHead,' which is the new head of the reversed linked list.
	}

	private static Node solutionWithFlipTheOrder(Node head) {
		Node temp = head; // Initialize'temp' at head of linked list
		Node prev = null; // Initialize pointer 'prev' to NULL, representing the previous node
		while(temp!=null) {  // Traverse the list, continue till 'temp' reaches the end (NULL)
			Node front = temp.next; // Store the next node in 'front' to preserve the reference
			temp.next = prev; // Reverse the direction of the current node's 'next' pointer to point to 'prev'
			prev = temp; // Move 'prev' to the current node for the next iteration
			temp = front; // Move 'temp' to the 'front' node advancing the traversal
		}
		return prev;   // Return the new head of the reversed linked list
	}

}

class Node {
	int data;
	Node next;
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	public Node(int data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
}
