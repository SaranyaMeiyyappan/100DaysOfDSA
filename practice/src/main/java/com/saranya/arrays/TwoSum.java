package main.java.com.saranya.arrays;

public class TwoSum {

	public static void main(String[] args) {
		TwoSum();
	}

	/*
	 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.

	 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

	 * The tests are generated such that there is exactly one solution. You may not use the same element twice.

	 * Your solution must use only constant extra space.
	 * 
	 */
	private static void TwoSum() {
		int[] numbers = {2,7,11,15};
		int target = 9;
		solutionTwoSum(numbers, target);
	}

	private static int[] solutionTwoSum(int[] numbers, int target) {
		int firstPointer=0, secondPointer=numbers.length-1;
		int[] answer = new int[2];
		while(firstPointer < secondPointer) {
			if(numbers[firstPointer]+numbers[secondPointer] < target) {
				firstPointer++;
			} else if(numbers[firstPointer]+numbers[secondPointer] > target) {
				secondPointer--;
			} else {
				answer[0]=firstPointer+1;
				answer[1]=secondPointer+1;
				break;
			}
		}
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		return answer;
	}
}
