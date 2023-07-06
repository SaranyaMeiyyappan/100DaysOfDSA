package main.java.com.saranya.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayDuplicateCheck {

	public static void main(String[] args) {
		int[] nums = {1,2,3,1};
		System.out.println(containsDuplicate(nums));
		System.out.println(containsDuplicateHashMap(nums));
	}

    private static boolean containsDuplicateHashMap(int[] nums) {
    	Map<Integer,Integer> myMap =new HashMap<>();
        boolean returnObj = false;
    	for (int i = 0; i < nums.length; i++) {
    		int count = 1;
    		if(myMap.containsKey(nums[i])) {
    			count = myMap.get(nums[i])+1;
    			myMap.put(nums[i], count);
    			returnObj = true;
    			break;
    		} else 
    		{
    			myMap.put(nums[i], count);
    			returnObj = false;
    		}
    	}
        return returnObj;
	}

	public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }
}
