package main.java.com.saranya.arrays;

import java.util.Arrays;

public class CountingBits {

	public static void main(String[] args) {
		CountingBits();
	}


	private static void CountingBits() {
		int integerInput = 8;
		solutionCountingBits(integerInput);
	}
	
	private static void solutionCountingBits(int n) {
		int outputArray[] = new int[n+1];
		for(int i=0; i<=n; i++) {
			outputArray[i] = sum(Integer.toBinaryString(i));
		}
		System.out.println(Arrays.toString(outputArray));
	}
	
	private static int sum(String binaryString) {
		int sumInt = 0;
		char[] inputArray = binaryString.toCharArray();
		for (int i=0; i<inputArray.length; i++) {
			sumInt = sumInt+Integer.parseInt(String.valueOf(inputArray[i]));
		}
		return sumInt;
	}

}
