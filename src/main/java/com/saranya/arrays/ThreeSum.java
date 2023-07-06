package main.java.com.saranya.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum();
	}

	/*
	 * Given an integer array nums, return all the triplets [nums[i], nums[j],
	 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
	 * nums[k] == 0. Notice that the solution set must not contain duplicate
	 * triplets.
	 * 
	 * Input: nums = [-1,0,1,2,-1,-4]
	 *	Output: [[-1,-1,2],[-1,0,1]]
	 */
	private static void ThreeSum() {
		int[] nums = {-1,0,1,2,-1,-4};
		solutionThreeSum(nums);
	}

	private static void solutionThreeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			System.out.println("nums array is null or 0");
		}
		Map<Integer, Integer> map = new HashMap<>();
		Arrays.sort(nums);
		for(int i=0; i<nums.length; i++) {
			map.put(nums[i], i);
		}
		map.forEach((k,v) -> System.out.println(k +" and "+ v));
		Set<String> triplets = new HashSet<>();
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				int currentSum = nums[i]+nums[j];
				if(map.containsKey(-1 * currentSum)) {
					int k = map.get(-1 * currentSum);
					if(!triplets.contains(nums[i] +","+ nums[j] +","+ nums[k]) && k>j && k>i) {
						result.add(Arrays.asList(nums[i],nums[j],nums[k]));
						triplets.add(nums[i] +","+ nums[j] +","+ nums[k]);
					}
				}
			}
		}
		System.out.println(Arrays.toString(result.toArray()));

	}



}
