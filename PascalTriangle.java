import java.util.ArrayList;

/**
 * Leetcode.com - Pascal's Triangle
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [ 
 *     [1], 
 *    [1,1], 
 *   [1,2,1], 
 *  [1,3,3,1], 
 * [1,4,6,4,1]
 * ]
 * 
 */
public class PascalTriangle {
	
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if (numRows < 1)
			return result;
		
		ArrayList<Integer> lastRow = new ArrayList<Integer>();
		lastRow.add(1);
		result.add(new ArrayList<Integer>(lastRow));
		
		if (numRows == 1)
			return result;

		lastRow.add(1);
		result.add(new ArrayList<Integer>(lastRow));
		
		if (numRows == 2)
			return result;

		for (int i = 2; i < numRows; i++) {
			ArrayList<Integer> row = generateRow(lastRow);
			result.add(row);
			lastRow = row;
		}
		
		return result;
	}

	private ArrayList<Integer> generateRow(ArrayList<Integer> lastRow) {
		ArrayList<Integer> newRow = new ArrayList<Integer>();
		newRow.add(1);
		
		for (int i = 0; i < lastRow.size() - 1; i++) 
			newRow.add(lastRow.get(i) + lastRow.get(i + 1));
		
		newRow.add(1);
		return newRow;
	}

	public static void main(String[] args) {
		PascalTriangle p = new PascalTriangle();
		System.out.println(p.generate(2));
	}
}
