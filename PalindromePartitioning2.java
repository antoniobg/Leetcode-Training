/**
 * 
 * Leetcode.com - Palindrome Partitioning II
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 */
public class PalindromePartitioning2 {
	
    public static int minCut(String s) {
        int len = s.length();

        int result[] = new int[len+1];
        boolean palindrome[][] = new boolean[len][len];

      for(int i = 0; i <= len; i++)
        result[i] = len-i;

      for(int i = len-1; i >= 0; i--){
        for(int j = i; j < len; j++){
          if(s.charAt(i) == s.charAt(j) && (j-i<2 || palindrome[i+1][j-1])){
            palindrome[i][j] = true;
            result[i] = Math.min(result[i],result[j+1]+1);
          }
        }
      }
      return result[0]-1;
    }
    
    public static void main(String[] args) {
    	String s = "cabba";
    	System.out.println(minCut(s));
    }
}
