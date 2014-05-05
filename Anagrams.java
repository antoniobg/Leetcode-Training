import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


/**
 * Leetcode.com - Anagrams
 * 
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * 
 */
public class Anagrams {
    HashMap<String, HashSet<Integer>> groups = new HashMap<String, HashSet<Integer>>();
    public ArrayList<String> anagrams(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            add(strs[i], i);
        }
        ArrayList<String> result = new ArrayList<String>();
        for (HashSet<Integer> set : groups.values())
        	if (set.size() > 1)
        		for (int i: set)
        			result.add(strs[i]);
        return result;
    }
    
    private void add(String s, int index) {
    	String sorted = sortString(s);
        if (groups.containsKey(sorted))
        	groups.get(sorted).add(index);
        else {
        	HashSet<Integer> set = new HashSet<Integer>();
        	set.add(index);
        	groups.put(sorted, set);
        }
    }
    
    private String sortString(String s) {
    	if (s.isEmpty())
    		return s;
    	char[] sTemp = s.toCharArray();
    	Arrays.sort(sTemp);
    	s = String.copyValueOf(sTemp);
    	return s;
    }
    
    public static void main(String[] args) {
    	String[] input = {"tea","","eat","","tea",""};
    	AnagramsII a = new AnagramsII();
    	System.out.println(a.anagrams(input));
    }
}
