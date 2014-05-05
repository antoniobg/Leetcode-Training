
/**
 * Leetcode.com - Rotate Image
 * 
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up
 * Could you do this in-place?
 *
 */
public class Rotate {
    public static void rotate(int[][] matrix) {
    	int n = matrix.length;
        for (int i = 0; i < n / 2 +1; i++) {
        	for (int j = i; j < n - i -1; j++) {
	        	int aux = matrix[i][j];
	        	matrix[i][j] = matrix[n-j-1][i];
	        	matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
	        	matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
	        	matrix[j][n-i-1] = aux;
	        }
        }
    }
    
    public static void main(String[] args) {
    	int[][] matrix = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    	print(matrix);
    	System.out.println("\n");
    	rotate(matrix);
    	print(matrix);
    }
    
    public static void print(int[][] matrix) {
    	for(int i = 0; i < matrix.length; i++) {
    		System.out.print("[ ");
    		for (int j = 0; j < matrix.length; j++) {
    			if (matrix[i][j] / 10 == 0)
        			System.out.print("0" + matrix[i][j]);
    			else 
    				System.out.print(matrix[i][j]);
    			System.out.print(" ");
    		}
    		System.out.println("]");
    	}
    }
}
