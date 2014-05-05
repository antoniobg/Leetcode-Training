import java.util.Arrays;

/**
 * Leetcode.com - Longest Common Prefix
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 */
public class LCP {
	
	public static String findLCP(String[] input) {
		if (input.length == 0)
			return "";
		String result = input[0];
		for (int i = 1; i < input.length; i++) {
			result = lcp(result, input[i]);
			if (result == "")
				break;
		}
		return result;
	}
	
	private static String lcp(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        for (int end = Math.min(sLen, tLen); end > 0; end--) {
            if (s.substring(0, end).equals(t.substring(0, end)))
                return s.substring(0, end);
        }
        return "";
	}

	public static void main(String[] args) {
		String[] input = {"hangar", "haga", "halo", "hacha", "haya", "hazard"};
		Arrays.sort(input);
		for (String s : input) {
			System.out.println(s);
		}
		System.out.println(findLCP(input));
	}
}
