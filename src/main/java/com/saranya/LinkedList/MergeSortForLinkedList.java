package main.java.com.saranya.LinkedList;

/**
 * 
 * Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort. Note: If the length of linked list is
 * odd, then the extra node should go in the first list while splitting.
 * 
 * Example 1:
 * 
 * Input: N = 5 value[] = {3,5,2,4,1} 
 * Output: 1 2 3 4 5 
 * Explanation: After sorting the given linked list, the resultant matrix will be 1->2->3->4->5.
 *
 */
public class MergeSortForLinkedList {

	public static void main(String[] args) {
		// Constructing the following linked list.
        // 4 --> 3 --> 2 --> 5 --> 1 --> null
        Node head = new Node(4);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);
        
        System.out.println("List before sorting - ");
        System.out.println(head.toString());
        
        head = mergeSort(head);
        System.out.println("List after sorting - ");
        System.out.println(head.toString());
	}

	// Function to sort the list.
	private static Node mergeSort(Node head) {
		// Base condition to check if the head itself is null or the list consists of only a single node.
		if(head == null || head.next==null) {
			return head;
		}
		
		// Finding the middle node of the list.
		Node mid = findMiddle(head);
		
		// Finding the next node of the middle node.
		Node midToNext = mid.next;
		
		// Breaking the list into two halves.
		mid.next = null;
		
		// Recurring for the left and the right halves obtained.
		Node leftHead = mergeSort(head);
		Node rightHead = mergeSort(midToNext);
		
		// Merging the already sorted left and right part of the linked list.
		Node sortedHead = mergSortedLL(leftHead, rightHead);
		
		// Returning the sorted List.
		return sortedHead;
	}

    // Function to find the middle node of the linked list.
	private static Node findMiddle(Node head) {
		// Base condition.
		if(head == null) {
			return head;
		}
		
		 // Slow and fast pointers to iterate over the list.
        // Fast pointer will take 2 steps at a time while slow pointer will take 1 step at a time.
		Node fast = head, slow = head;
		
		// Iterating while we have reached last or second last node of the list.
		while(fast.next!= null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		// Node pointed by the slow pointer is the middle node of the list.
		return slow;
	}
	
	// Function to merge two already sorted lists.
	private static Node mergSortedLL(Node leftHead, Node rightHead) {
		
		// Base cases to check if either of the list provided is empty.
		if(leftHead == null) {
			return leftHead;
		}
		if(rightHead == null) {
			return rightHead;
		}
		
		// Dummy node to hold the answer.
		Node dummy = new Node(-1);
		
		// Declaring another variable 'node' to iterate further
		Node node = dummy;
		
		// Iterating while both pointers are not null
		while(leftHead != null && rightHead != null) {
			// If left's val is smaller than or equal to right's val.
			if(leftHead.data <= rightHead.data) {
				node.next = leftHead; // Assign left to node's next.
				leftHead = leftHead.next;  // Move left to its next node.
			} else { // Otherwise left's val is greater than right's val. 
				node.next = rightHead; // Assign right to node's next. 
				rightHead = rightHead.next; // Assign right to node's next. 
			}
			node = node.next;  // Moving node to its next node.
		}
		while(leftHead != null) {  // Iterating while left is not null.
			node.next = leftHead; // Assign left to node's next.
			leftHead = leftHead.next; // Move left to its next node.
			node = node.next; // Moving node to its next node.
		}
		while(rightHead != null) {  // Iterating while right is not null.
			node.next = rightHead; // Assign right to node's next. 
			rightHead = rightHead.next; // Assign right to node's next. 
			node = node.next; // Moving node to its next node.
		}
		return dummy.next; // Returning dummy's next as our answer.
	}

}
