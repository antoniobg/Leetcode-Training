/**
 * Leetcode.com - Regular Expression Matching
 * 
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. 
 * '*' Matches zero or more of the preceding
 * element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: 
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples: 
 * isMatch("aa","a")       → false 
 * isMatch("aa","aa")      → true
 * isMatch("aaa","aa")     → false 
 * isMatch("aa", "a*")     → true 
 * isMatch("aa", ".*") 	   → true 
 * isMatch("ab", ".*")     → true 
 * isMatch("aab", "c*a*b") → true
 */
public class SimpleRegex {

    public static boolean isMatch(String s, String p) {
        if (p.isEmpty() || s.isEmpty()) {
            return s.isEmpty() && p.isEmpty();
        }
        // next char is not '*': must match current character
        if (p.length() == 1 || p.charAt(1) != '*') {
        	if (s.isEmpty())
        		return false;
            return ((p.charAt(0) == s.charAt(0)) || 
            (p.charAt(0) == '.')) && 
            isMatch(s.substring(1), p.substring(1));
        }
        // next char is '*'
       while ((s.length() > 0 && p.charAt(0) == s.charAt(0)) || 
            (p.charAt(0) == '.' && !s.isEmpty())) {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            s = s.substring(1);
        }
        return isMatch(s, p.substring(2));
    }
    
    public static void main(String[] args) {
    	String s1 = "aaabcba";
    	String s2 = "abcba";
    	String s3 = "aabxba";
    	String s4 = "ab";
    	String p = ".*c";
    	System.out.println(isMatch(s1,p));
    	System.out.println(isMatch(s2,p));
    	System.out.println(isMatch(s3,p));
    	System.out.println(isMatch(s4,p));

    }
}