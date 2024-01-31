package main.java.com.saranya.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] nums = {100, 200, 1, 2, 3, 4};
		System.out.println(bruteForceSolution(nums));
		System.out.println(optimalSolution1(nums));
		System.out.println(optimalSolution2(nums));
	}

	private static int optimalSolution2(int[] nums) {
		int longestSequence = 1;
		HashSet<Integer> hashSet = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
		for(Integer i : hashSet) {
			if(!hashSet.contains(i-1)) {
				int count = 1;
				int x = i;
				while(hashSet.contains(x+1)) {
					x = x+1;
					count = count+1;
				}
				longestSequence = Math.max(count, longestSequence);
			}
		}
		return longestSequence;
	}

	private static int optimalSolution1(int[] nums) {
		int longestSequence = 1;
		int count = 0;
		int lastSmaller = Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			if(nums[i]-1 == lastSmaller) {
				count+=1;
				lastSmaller = nums[i];
			} else if(nums[i] != lastSmaller) {
				lastSmaller = nums[i];
				count = 1;
			}
		}
		longestSequence = Math.max(count, longestSequence);
		return longestSequence;
	}

	private static int bruteForceSolution(int[] nums) {
		int longestSequence = 1;
		for(int i=0; i<nums.length; i++) {
			int count = 1;
			int x = nums[i];
			while(linearSearch(nums, x+1)) {
				count+=1;
				x+=1;
			}
			longestSequence = Math.max(longestSequence, count);
		}
		return longestSequence;
	}

	private static boolean linearSearch(int[] nums, int x) {
		for(int i=0; i<nums.length; i++) {
			if(nums[i]==x) {
				return true;
			}
		}
		return false;
	}

}
