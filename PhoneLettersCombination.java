import java.util.ArrayList;
import java.util.HashMap;

/**
 * Leetcode.com - Letter Combinations of a Phone Number
 * 
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * [img] http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png
 * 
 * Input:
 * Digit string "23" 
 * 
 * Output: 
 * ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. 
 * 
 * Note: Although the above answer is in lexicographical order,
 * your answer could be in any order you want.
 * 
 */
public class PhoneLettersCombination {
	public HashMap<Character, char[]> keyboard = new HashMap<Character, char[]>();

	public PhoneLettersCombination() {
		char[] chars0 = { ' ' };
		char[] chars2 = { 'a', 'b', 'c' };
		char[] chars3 = { 'd', 'e', 'f' };
		char[] chars4 = { 'g', 'h', 'i' };
		char[] chars5 = { 'j', 'k', 'l' };
		char[] chars6 = { 'm', 'n', 'o' };
		char[] chars7 = { 'p', 'q', 'r', 's' };
		char[] chars8 = { 't', 'u', 'v' };
		char[] chars9 = { 'w', 'x', 'y', 'z' };
		keyboard.put('0', chars0);
		keyboard.put('2', chars2);
		keyboard.put('3', chars3);
		keyboard.put('4', chars4);
		keyboard.put('5', chars5);
		keyboard.put('6', chars6);
		keyboard.put('7', chars7);
		keyboard.put('8', chars8);
		keyboard.put('9', chars9);
	}

	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		StringBuilder partial = new StringBuilder();

		combinationRec(digits, result, partial);

		return result;
	}

	private void combinationRec(String digits, ArrayList<String> result,
			StringBuilder partial) {
		if (digits.isEmpty()) {
			result.add(partial.toString());
			return;
		}
		char current = digits.charAt(0);
		for (char c : keyboard.get(current)) {
			partial.append(c);
			combinationRec(digits.substring(1), result, partial);
			partial.deleteCharAt(partial.length() - 1);
		}
	}

	public static void main(String[] args) {
		PhoneLettersCombination plc = new PhoneLettersCombination();
		System.out.println(plc.letterCombinations("23"));
	}
}
