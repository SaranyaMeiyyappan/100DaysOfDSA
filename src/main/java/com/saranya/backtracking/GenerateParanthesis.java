package main.java.com.saranya.backtracking;

public class GenerateParanthesis {

	public static void main(String[] args) {
		int n = 3;
		char[] str = new char[2*n]; 
		printParanthesis(n, str);
	}

	private static void printParanthesis(int n, char[] str) {
		if(n>0) {
			recursivelyPrintParanthesis(str, 0, n, 0, 0 );
		}
	}

	private static void recursivelyPrintParanthesis(char[] str, int pos, int n, int open, int close) {
		if(close == n) {
			for(int i=0; i<str.length; i++)
				System.out.print(str[i]);			
			System.out.println();
			return;
		} else {
			if(open > close) {
				str[pos] = '}';
				recursivelyPrintParanthesis(str, pos+1, n, open, close+1);
			} 
			if(open < n) {
				str[pos] = '{';
				recursivelyPrintParanthesis(str, pos+1, n, open+1, close);
			}
		}
	}
	
}
