/**
 * 
 * Leetcode.com - Sum Root to Leaf Numbers
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *     1
 *    / \
 *   2   3
 *   The root-to-leaf path 1->2 represents the number 12.
 *   The root-to-leaf path 1->3 represents the number 13.
 *   Return the sum = 12 + 13 = 25.
 *
 */
public class SumRootToLeaf {    
	public static int sumNumbers(TreeNode root) {
        return sumRec(root, 0);
    }
    
    private static int sumRec(TreeNode node, int sum) {
    	if (node == null)
    		return 0;
    	sum = sum * 10 + node.val;
    	if (isLeaf(node)) 
        	return sum;
    	else
    		return sumRec(node.left, sum) + sumRec(node.right, sum);
    }
    public static boolean isLeaf(TreeNode n){
    	return (n.left == null) && (n.right == null);
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
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(0);
    	TreeNode l = new TreeNode(4);
    	TreeNode r = new TreeNode(3);
    	TreeNode ll = new TreeNode(7);
    	TreeNode rr = new TreeNode(6);
    	TreeNode lll = new TreeNode(4);
    	TreeNode rrr = new TreeNode(4);
    	TreeNode llll = new TreeNode(2);
    	TreeNode lllr = new TreeNode(1);
    	TreeNode rrrr = new TreeNode(7);
    	root.left = l;
    	root.right = r;
    	l.left = ll;
    	r.right = rr;
    	ll.left = lll;
    	rr.right = rrr;
    	lll.left = llll;
    	lll.right = lllr;
    	rrr.right = rrrr;
       	System.out.println(sumNumbers(root));
    }
}
