package main.java.com.saranya.binaryTrees;


/**
 * 
 * Given a matrix mat[][] of size N x M, where every row and column is sorted in
 * increasing order, and a number X is given. The task is to find whether
 * element X is present in the matrix or not.
 * 
 * 
 * Example 1:
 * 
 * Input: N = 3, M = 3 mat[][] = 3 30 38
 * 								 44 52 54
 * 								 57 60 69 
 * X = 62 
 * Output: 0
 * Explanation: 62 is not present in the matrix, so output is 0
 * 
 * Example 2:
 * 
 * Input: N = 1, M = 6 mat[][] = 18 21 27 38 55 67 
 * X = 55 
 * Output: 1 
 * Explanation:
 * 55 is present in the matrix at 5th cell.
 *
 * 
 */
public class SearchInSortedMatrix {

	public static void main(String[] args) {
		int N = 3, M = 3;
	    int mat[][] = {{3, 30, 38}, 
				       {44, 52, 54}, 
				       {57, 60, 69}};
		int X = 57;
		
		optimalSearchApproach(N, M, mat, X);
		binarySearchApproach(N, M, mat, X);
	}

	private static boolean binarySearchApproach(int n, int m, int[][] mat, int x) {
		if(mat.length==0) return false;
		int low = 0, high = (n*m)-1;
		
		while(low <= high) {
			int midIndex = low + (high-low) / 2;
			int midElement = mat[midIndex/mat[0].length][midIndex%mat[0].length];
			if(midElement == x) {
				System.out.println("In Binary Search Approach, the value "+x+" is found at "+midIndex/mat[0].length+","+midIndex%mat[0].length);
				return true;
			}
			if(midElement > x) { //52 >57
				high = midIndex-1;
			} else {
				low = midIndex+1;
			}
		}
		return false;
	}

	private static boolean optimalSearchApproach(int n, int m, int[][] mat, int x) {
		int i=0, j=m-1;
		while(i<n && j>=0) {
			if(mat[i][j] == x) {
				System.out.println("In Optimal Search Approach, the value "+x+" is found at "+i+","+j);
				return true;
			}
			if(mat[i][j]>x) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}

}
