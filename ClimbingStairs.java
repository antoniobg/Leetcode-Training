import java.util.ArrayList;

/**
 * Leetcode.com - Climbing Stairs
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 * 
 */
public class ClimbingStairs {
    private static ArrayList<Integer> fibonacci = new ArrayList<Integer>();
    public int climbStairs(int n) {
        if (n == 0)
            return 0;
        init();
        return fib(n);
    }
    
    private void init() {
         if (fibonacci == null)
            fibonacci = new ArrayList<Integer>();
        fibonacci.add(1);
        fibonacci.add(1);
    }
    
    private int fib(int left) {
        if (fibonacci.size() < left + 1)
            fibonacci.add(fib(left-1) + fib(left-2));
        return fibonacci.get(left);
    }
    
    
    public static void main(String[] args) {
    	ClimbingStairs c = new ClimbingStairs();
    	System.out.println(c.climbStairs(2));
    }
}
