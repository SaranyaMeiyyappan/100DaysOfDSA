package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCodeEasy {

	public static void main(String[] args) {
		System.out.println(isPalindrome(121321));
		//System.out.println(romanToInt("LVIII"));
		System.out.println("------------------------");
		//kFrequentIntegers();
	}

	private static int[] kFrequentIntegers() {
		int nums[] = {1,1,1,2,2,3};
		int k = 2;
        Map<Integer, Integer> count = new HashMap<>();
        for(Integer i: nums){
            if(count.containsKey(i)){
                count.put(i, count.get(i)+1);
            } else {
                count.put(i, 1);
            }
        }
        List<Integer> al = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if(entry.getValue() >= k){
            	al.add(entry.getKey());
            }
        
        }
        int countArray[] = al.stream().mapToInt(i->i).toArray();
        return countArray;
	}

	private static String romanToInt(String string) {
		String convertedInt = null;
		
		return convertedInt;
	}

	private static boolean isPalindrome(int input) {
		String s = String.valueOf(input);
		int i=0, j=s.length()-1;
		while(i<j) {
			System.out.println(" i<j "+String.valueOf(i<j));
			System.out.println("i value "+s.charAt(i));
			System.out.println(" j value "+s.charAt(j));
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			} else {
				i++;
				j--;
			}
			System.out.println(" i "+i);
			System.out.println(" j "+j);
		}
		return true;
	}

}
