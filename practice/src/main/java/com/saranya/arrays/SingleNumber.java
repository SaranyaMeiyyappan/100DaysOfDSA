package main.java.com.saranya.arrays;

public class SingleNumber {

	/**
	 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

		You must implement a solution with a linear runtime complexity and use only constant extra space.
	 * 
	 */
	public static void main(String[] args) {
		singleNumber();
	}

	private static void singleNumber() {
		int nums[] = {2,2,7,1,1};
		solution(nums);
	}

	private static void solution(int[] nums) {
        int ans = 0;
        for (int x: nums){
            ans ^= x;
        }
        System.out.println(ans);
	}
}
