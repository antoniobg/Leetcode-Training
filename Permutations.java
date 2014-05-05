import java.util.ArrayList;


/**
 * 
 * Leetcode.com - Permutations
 * 
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *
 */
public class Permutations {
	
	private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	private boolean[] visited;
	
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
    	visited = new boolean[num.length];
    	permuteRec(num, new ArrayList<Integer>());
    	return result;
    }
    
    private void permuteRec(int[] num, ArrayList<Integer> partial) {
    	if (partial.size() == num.length) {
    		result.add(new ArrayList<Integer>(partial));
    		return;
    	}
    	for (int i = 0; i < num.length; i++) {
    		if(visited[i])
    			continue;
    		visited[i] = true;
    		partial.add(num[i]);
    		permuteRec(num, partial);
    		partial.remove(partial.size() -1);
    		visited[i] = false;
    	}
    }
    
    public static void main(String[] args) {
    	Permutations p = new Permutations();
    	int[] n = {1, 2, 3};
    	System.out.println(p.permute(n));
    }
}
