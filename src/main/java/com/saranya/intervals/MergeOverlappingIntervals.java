package main.java.com.saranya.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * Given a collection of Intervals, the task is to merge all of the overlapping Intervals.
 * 
 * Example 1:
 * 
 * Input: 
 * Intervals = {{1,3},{2,4},{6,8},{9,10}} 
 * Output: {{1, 4}, {6, 8}, {9, 10}} 
 * Explanation: 
 * Given intervals: [1,3],[2,4] [6,8],[9,10], 
 * we have only two overlapping intervals here,[1,3] and [2,4]. Therefore we will merge these two and return [1,4], [6,8], [9,10].
 *
 */
public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
		List<List<Integer>> overlappedIntervals = mergeIntervals(arr);
		System.out.println(overlappedIntervals.toString());
	}

	private static List<List<Integer>> mergeIntervals(int[][] arr) {
		Arrays.sort(arr, Comparator.comparingInt(a->a[0]));
		List<List<Integer>> mergedIntervals = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			if(mergedIntervals.isEmpty() || arr[i][0] > mergedIntervals.get(mergedIntervals.size()-1).get(1)) {
				mergedIntervals.add(Arrays.asList(arr[i][0],arr[i][1]));
			} else {
				mergedIntervals.get(mergedIntervals.size()-1).set(1, 
						Math.max(mergedIntervals.get(mergedIntervals.size()-1).get(1), arr[i][1]));
			}
		}
		return mergedIntervals;
	}

}
