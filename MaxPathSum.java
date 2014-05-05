/**
 * Leetcode.com - Binary Tree Maximum Path Sum
 * 
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * For example: Given the below binary tree,
 * 
 *      1
 *     / \
 *    2   3 
 * 
 * Return 6.
 * 
 */
public class MaxPathSum {
	private static int max = Integer.MIN_VALUE;

	public static int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		dfs(root);
		return max;
	}

	private static int dfs(TreeNode node) {
		if (node == null)
			return 0;
		int left = Math.max(dfs(node.left), 0);
		int right = Math.max(dfs(node.right), 0);
		max = Math.max(node.val + left + right, max);

		return node.val + Math.max(left, right);
	}

	public static void main(String[] args) {
		TreeNode n = new TreeNode(-3);
		TreeNode l = new TreeNode(1);
		System.out.println(maxPathSum(n));
		System.out.println();
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		public String toString() {
			return "Value: " + val;
		}
	}
}