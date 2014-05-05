import java.util.ArrayList;
import java.util.Arrays;

/**
 * Leetcode.com - Combination Sum
 * 
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak). 
 * 
 * The solution set must not contain duplicate combinations. 
 * 
 * For example, 
 * given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] [2, 2, 3]
 * 
 */
public class CombinationSum {

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		Arrays.sort(candidates);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		combinationRec(candidates, target, result, new ArrayList<Integer>());
		return result;
	}

	private void combinationRec(int[] candidates, int target,
			ArrayList<ArrayList<Integer>> result, ArrayList<Integer> partial) {
		if (target == 0) {
			result.add((ArrayList<Integer>) partial.clone());
			return;
		}
		if (target < 0) {
			return;
		}
		for (int i = 0; i < candidates.length; i++) {
			partial.add(candidates[i]);
			combinationRec(
					Arrays.copyOfRange(candidates, i, candidates.length),
					target - candidates[i], result, partial);
			partial.remove(partial.size() - 1);
		}
		return;
	}

	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] candidates = { 1, 3, 6, 7 };
		int target = 7;
		System.out.println(cs.combinationSum(candidates, target));
	}
}
