package main.java.com.saranya.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a matrix of size r*c. Traverse the matrix in spiral form.
 * 
 * Example 1:
 * 
 * Input: r = 4, c = 4 matrix[][] = {{1, 2, 3, 4}, 
 *                                   {5, 6, 7, 8}, 
 *                                   {9, 10, 11,12},
 *                                   {13, 14, 15,16}} 
 * 
 * Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 * 
 * top    right 
 * {1,2,3,4},
 * {5,6,7,8}, 
 * {9,10,11,12},
 * {13,14,15,16} 
 * left      bottom
 *
 */
public class SpiralTraversalOfMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},
						  {5,6,7,8},
						  {9,10,11,12},
						  {13,14,15,16}};
		
		System.out.println(Arrays.toString(printSprial(matrix).toArray()));
	}

	private static List<Integer> printSprial(int[][] matrix) {
		List<Integer> result = new ArrayList<>(); // Define ans list to store the result.
		int n = matrix.length; //No. of rows
		int m = matrix[0].length; //No. of columns
		int top=0, left=0, right=m-1, bottom=n-1; // Initialize the pointers required for traversal on all the 4 corners.
		
		 // Loop until all elements are not traversed.
		 while (top <= bottom && left <= right) {
			
			 // For moving left to right
			for(int i=left; i<=right; i++) {
				result.add(matrix[top][i]);
			}
			top++;
			
			// For moving top to bottom. (coming down from top to bottom)
			for(int i=top; i<=bottom; i++) {
				result.add(matrix[i][right]);
			}
			right--;
			
			// For moving right to left. (from bottom right to left)
			if(top <= bottom) {
				for(int i=right; i>=left; i--) {
					result.add(matrix[bottom][i]);
				}
				bottom--;
			}
			
			// For moving bottom to top. (from bottom left to top)
			if(left<=right) {
				for(int i=bottom; i>=top; i--) {
					result.add(matrix[i][left]);
				}
				left++;
			}
			
		}
		

		return result;
	}

}
