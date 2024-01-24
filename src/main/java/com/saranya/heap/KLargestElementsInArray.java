package main.java.com.saranya.heap
  
import java.util.PriorityQueue;

/**
 * 
 * Given an array of N positive integers, print k largest elements from the array.
 * 
 * Example 1:
 * 
 * Input: N = 5, k = 2 arr[] = {12,5,787,1,23} 
 * Output: 787 23 
 * Explanation: First largest element in the array is 787 and the second largest is 23. 
 * 
 * Example 2:
 * 
 * Input: N = 7, k = 3 arr[] = {1,23,12,9,30,2,50} 
 * Output: 50 30 23 Explanation: Three Largest element in the array are 50, 30 and 23.
 *
 */
public class KLargestElementsInArray {

	public static void main(String[] args) {
		 int[] arr = { 1, 23, 12, 9, 30, 2, 50 };
		 int k = 3;
		 kLargestMinHeap(arr, k);
		 kLargestBinarySearch(arr, k);
		 kLargestQuickSort(arr, 0, arr.length-1, arr.length - k);
	}

	private static void kLargestQuickSort(int[] arr, int low, int high, int k) {
		int KthLargest = quickSelect(arr, 0, arr.length-1, k);
		for(int i: arr) {
			if(i>=KthLargest) {
				System.out.println(i);
			}
		}
	}

	private static int quickSelect(int[] arr, int low, int high, int k) {
		int pivotIndex = quickSortPartition(arr, low, high);
		if(pivotIndex == k) {
			return arr[pivotIndex]; 
		} else if(k > pivotIndex) {
			return quickSelect(arr, pivotIndex+1, high, k);
		} else {
			return quickSelect(arr, low, pivotIndex-1, k);
		}
	}

	private static int quickSortPartition(int[] arr, int low, int high) {
		int pivotElement = arr[high];
		int i = low-1;
		for(int j=low; j<high; j++) {
			if(pivotElement > arr[j]) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, high);
		return (i+1);
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	private static void kLargestBinarySearch(int[] arr, int k) {
		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;
		
		//Find the minimum and maximum elements in the array
		for(int i:arr) {
			low = Math.min(low, i);
			high = Math.max(high, i);
		}
		
		//Perform binary search on elements between low and high
		while(low <= high) {
			int mid = low+(high-low) / 2;
			int count = 0;
			
			//count the number of greater than the mid
			for (int i: arr) {
				if( i > mid) {
					count++;
				}
			}
			
			//If there are K elements greater than mid, search the right half
			if(count >= k) {
				low = mid+1;
			} else { //otherwise, search the left half
				high = mid-1;
			}
		}
		
		int KthLargestElement = high;
		for (int i : arr) {
			if(i>=KthLargestElement) {
				System.out.println(" "+i);
			}
		}
	}
	
	private static void kLargestMinHeap(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<arr.length; ++i) {
			pq.add(arr[i]);
			
			if(pq.size() > k) {
				pq.poll();
			}
		}
		
		while(!pq.isEmpty()) {
			System.out.println(pq.peek() + " ");
			pq.poll();
		}
		System.out.println();
	}

}
