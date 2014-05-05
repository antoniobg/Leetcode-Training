
/**
 * 
 * Leetcode.com - Unique Paths
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * [img]http://4.bp.blogspot.com/_UElib2WLeDE/TNJf8VtC2VI/AAAAAAAACXU/UyUa-9LKp4E/s400/robot_maze.png
 * 
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 */
public class UniquePaths {
	private int[][] matrix;
	private int m, n;
	
    public int uniquePaths(int m, int n) {
    	this.m = m;
    	this.n = n;
    	matrix = new int[n][m];
        findPaths(n-1, m-1);
        return matrix[0][0];
    }
    
    private void findPaths(int x, int y) {
    	for (int i = x; i >= 0; i--) {
    		for (int j = y; j >= 0; j--) {
    	    	if (i == n-1 && j == m-1)
    	    		matrix[x][y] = 1;
    	    	else {
	    			int add = 0;
	    			if (j+1 < m)
	    				add += matrix[i][j+1];
	    			if (i+1 < n)
	    				add += matrix[i+1][j];
	    			matrix[i][j] = add;
    	    	}
    		}
    	}
    	
    }
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < n; i++) {
    		sb.append("[ ");
    		for(int j = 0; j < m; j++){
    			sb.append(matrix[i][j]).append(" ");
    		}
    		sb.append("]\n");
    	}
    	return sb.toString();
    			
    }
    
    public static void main(String[] args) {
    	UniquePaths p = new UniquePaths();
    	System.out.println(p.uniquePaths(6, 6));
    }
}
