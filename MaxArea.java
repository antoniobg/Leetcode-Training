
/**
 * Leetcode.com - Container With Most Water
 * 
 * 
 * Given n non-negative integers a1, a2, ..., an, where each 
 * represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * 
 * Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water.
 * 
 * Note: You may not slant the container. *
 */
public class MaxArea {
    private int max = 0;
    public int maxAreaIt(int[] height) {
    	max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int area = h * (j - i);
                max = Math.max(area, max);
            }
        }
        return max;
    }
    public int maxArea(int[] height) {
    	max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if (height[i] > height[j])
            	j--;
            else
            	i++;
        }
        return max;
    }
    
    
    public static void main(String[] args){
    	int[] n = { 1, 5, 3, 7, 3 };
    	MaxArea m = new MaxArea();
    	System.out.println(m.maxArea(n));
    }
}
