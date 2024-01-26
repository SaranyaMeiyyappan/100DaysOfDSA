package main.java.com.saranya.dynamicProgramming;

/**
 * 
 * Given a triangle array, return the minimum path sum to reach from top to bottom.
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, 
 * you may move to either index i or index i + 1 on the next row.
 * 
 * Example 1:
 *
 * Input:
 * n = 4
 * triangle = [[2],
               [3,4],
               [6,5,7],
               [4,1,8,3]]
 * Output: 11
 * Explanation:
     			2
   				3 4
  				6 5 7
 				4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11.
 *
 */
public class TriangleMinPathSum {

	public static void main(String[] args) {
		int[][] triangle = {{2},
							{3,4},
							{6,5,7},
							{4,1,8,3}};
		
		System.out.println(minimumPathSum(triangle, triangle.length));
	}

	/**
	 * 
	 * We are going to use bottom-up dynamic programming approach
	 * 
	 */
	private static int minimumPathSum(int[][] triangle, int n) {
		//create two array to store the intermediate results;
		int[] front = triangle[n-1]; //last row of triangle is a base case for this DP. So, assign it completely to this array.
		int[] current = new int[n]; //this array is to store the intermediate results once started processing the triangle array.
		
        // Starting from the second to last row, calculate the minimum path sum for each element
		// last row is already assigned to front array. compare the direct and diagonal values between n-2 row in triangle array with front array
		for(int i=n-2; i>=0; i--) {
			for(int j=0; j<triangle[i].length; j++) {
				//calculate the two possible path - direct and diagonal and Store the minimum of the two paths in the cur array
				/**
				 * Also Instead of calculating the sum of paths separately and taking the minimum value, we write as 
				 * current[j] = triangle[i][j] + Math.min(front[j], front[j+1]);
				 */
				int direct = triangle[i][j] + front[j];
				int diagonal = triangle[i][j] + front[j+1];
				current[j] = Math.min(direct, diagonal);
			}
			// Update the front array with the values from the cur array for manipulating the next row
			front = current.clone();
		}
		
		// The result is stored at the top of the front array
		return front[0];
	}

}
