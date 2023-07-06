package main.java.com.saranya.dynamicProgramming;

import java.util.Arrays;

public class ClimbStair {

	public static void main(String[] args) {
		//ClimbStair();
	}

	/* Climbing Stairs 
	 * Input: n = 3
		Output: 3
		Explanation: There are three ways to climb to the top.
		1. 1 step + 1 step + 1 step
		2. 1 step + 2 steps
		3. 2 steps + 1 step
	 * 
	 * */
	private static void ClimbStair() {
		int numberOfSteps = 4;
		solution(numberOfSteps);
	}

	private static void solution(int n) {
		int fof1 = 1;
		int fof2 = 2;
		if(n < 3) {
			System.out.println("Number of Steps to climb "+n+ " is "+n);
		} else {
			for (int i=3; i<=n; i++) { // for (i=3)   // for (i=4)     // for (i=5)
				int currentValue = fof1+fof2; // 3   // 4				// 7
				fof2 = fof1; // step2 = 1				// step2 = 3	// step2 = 4
				fof1 = currentValue; // step1 = 3		// step1 = 4	// step1 = 7
			}
			System.out.println("Number of Steps to climb "+n+ " is "+fof1);
		}
	}

}
