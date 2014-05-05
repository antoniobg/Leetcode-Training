import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode.com - Palindrome Partitioning
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * [
 * 	["aa","b"],
 * 	["a","a","b"]
 * ]
 *
 */
public class PalindromePartitioning {
	
    public static  ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
        int length=s.length();
        if(length==0) 
        	return list; 
        part(s, 0, new ArrayList<String>(), list);
        return list; 
    }
    
    static void part(String s, int start, ArrayList<String> subList, ArrayList<ArrayList<String>> list)
    {
        if(start == s.length()) 
        {
            list.add(new ArrayList<String> (subList) ); 
            return ;
        }
        
        for(int i=start+1; i<= s.length(); i++)
        {
            if(palindrome(s, start, i-1))
            {
                subList.add(s.substring(start, i));
                part(s, i , subList, list);
                subList.remove(subList.size()-1);
            }
        }
    }
    
    static boolean palindrome(String s, int i, int j)
    {
        while(i < j)
        {
            if(s.charAt(i)!= s.charAt(j)) return false; 
            i++; 
            j--; 
        }
        return true; 
    }
    
    public static void main(String[] args) {
    	String s = "aabbacc";
    	List<ArrayList<String>> lista = partition(s);	
    	System.out.println("[");
    	for (ArrayList<String> subl : lista) {
    		System.out.print("  { ");
    		for (String st: subl)
    			System.out.print(st + ", ");
    		System.out.println(" }");
    	}
    	System.out.println("]");

    }
}
