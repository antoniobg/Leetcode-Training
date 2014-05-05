import java.util.ArrayList;

/**
 * Leetcode.com - Binary Tree Inorder Traversal
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 *    
 * return [1,3,2].
 *
 */
public class InorderTraversal {
	
	// Recursive solution
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		inorder(root, result);
		return result;
	}

	private void inorder(TreeNode node, ArrayList<Integer> result) {
		if (node == null)
			return;
		inorder(node.left, result);
		result.add(node.val);
		inorder(node.right, result);
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}