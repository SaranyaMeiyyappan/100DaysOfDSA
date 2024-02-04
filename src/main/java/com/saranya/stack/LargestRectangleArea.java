package main.java.com.saranya.stack;

import java.util.Stack;

public class LargestRectangleArea {

	public static void main(String[] args) {
		int[] heights = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(heights));
	}

	private static int maxArea(int[] heights) {
		int maxArea = 0;
        Stack<Integer> s = new Stack();
        s.push(0);
        for(int i=1; i<=heights.length; i++){
            int currentHeight = (i==heights.length)?-1:heights[i];
            while(!s.empty() && currentHeight <= heights[s.peek()]){
                int height = heights[s.pop()];
                int width = s.isEmpty()? i: i-s.peek()-1;
                maxArea = Math.max(maxArea, height*width);
            }
            s.push(i);
        }
        return maxArea;
    }

}
