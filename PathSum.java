import java.util.ArrayList;


/**
 * Leetcode.com - Path Sum II
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * For example: 
 * Given the below binary tree and sum = 22, 
 *       5 
 *      / \ 
 *     4   8 
 *    /   / \ 
 *   11  13  4 
 *  / \     / \ 
 * 7   2   5   1 
 * 
 * return 
 * [ 
 * 	[5, 4, 11, 2], 
 * 	[5, 8,  4, 5] 
 * ]
 * 
 * 
 */
public class PathSum {

    private ArrayList<ArrayList<Integer>> paths;
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        paths = new ArrayList<ArrayList<Integer>>();
        dfs(root, sum, new ArrayList<Integer>());
        return paths;
    }
    
    private void dfs(TreeNode node, int sum, ArrayList<Integer> partial) {
    	if (node == null)
    		return;
    	
    	if (isLeaf(node)) {
    		if ((sum - node.val) == 0) {
    			partial.add(node.val);
    			paths.add(new ArrayList<Integer>(partial));
    			partial.remove(partial.size()-1);
    		}
    		return;
    	}
    	
    	sum -= node.val;
    	partial.add(node.val);
    	dfs(node.left, sum, partial);
    	dfs(node.right, sum, partial);
    	partial.remove(partial.size() - 1);
    }
    
    private boolean isLeaf(TreeNode n) {
    	return (n.left == null && n.right == null);
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(5);
    	TreeNode n1 = new TreeNode(4);
    	TreeNode n2 = new TreeNode(8);
    	TreeNode n3 = new TreeNode(11);
    	TreeNode n4 = new TreeNode(13);
    	TreeNode n5 = new TreeNode(4);
    	TreeNode n6 = new TreeNode(7);
    	TreeNode n7 = new TreeNode(2);
    	TreeNode n8 = new TreeNode(5);
    	TreeNode n9 = new TreeNode(1);
    	root.left = n1;
    	root.right = n2;
    	n1.left = n3;
    	n2.left = n4;
    	n2.right = n5;
    	n3.left = n6;
    	n3.right = n7;
    	n5.left = n8;
    	n5.right = n9;
    	PathSum p = new PathSum();
    	System.out.println(p.pathSum(root, 22));

    }

    static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) {
    		val = x;
    	}
    	public String toString() {
    		return "Valor: " + val + "\nLeft: " + left.val + "\nRight: " +right.val;
    	}
    }
    
}
