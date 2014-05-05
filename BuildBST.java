import java.util.ArrayList;

/**
 * Leetcode.com - Convert Sorted Array to Binary Search Tree
 * 
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 */
public class BuildBST {
    public static TreeNode sortedArrayToBST(int[] num) {
        return buildBST(num, 0, num.length);
    }
    
    public static TreeNode buildBST(int[] num, int start, int end) {
        if ((end - start) < 1)
            return null;
        int pos = start + ((end - start) / 2);
        TreeNode node = new TreeNode(num[pos]);
        node.left = buildBST(num, start, pos);
        node.right = buildBST(num, pos+1, end);
        return node;
    }
    
    public static void main(String[] args) {
    	int[] input = { 1, 3, 8, 15, 16, 17 };
    	sortedArrayToBST(input);
    }
    
    static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	
    	TreeNode(int v) {
    		val = v;
    	}
    	public String toString() {
    		return "   " + val + "\n" + left + "       " + right; 
    	}
    }
}
