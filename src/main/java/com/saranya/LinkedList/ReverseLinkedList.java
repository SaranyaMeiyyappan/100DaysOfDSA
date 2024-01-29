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
		if(head == null || head.next == null) {
			return head;
		}
		Node newHead = recurse(head.next);
		Node front = head.next;
		front.next = head;
		head.next = null;
		return newHead;
	}

	private static Node solutionWithFlipTheOrder(Node head) {
		Node temp = head;
		Node prev = null;
		while(temp!=null) {
			Node front = temp.next;
			temp.next = prev;
			prev = temp;
			temp = front;
		}
		return prev;
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
