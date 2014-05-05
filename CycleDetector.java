import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode.com - Linked List Cycle II
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 *
 */
public class CycleDetector {
	
	// Using extra space
    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode node = head;
        while(node != null) {
            if (visited.contains(node))
                return node;
        	visited.add(node);
            node = node.next;
        }
        return null;
    }
    
    // Follow up question. NO extra space
    // Iterate through the list with two different speeds. If there's a cycle, there
    // would be one moment in which the fastes iterator reach the slowest.
    public static ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return null;
        ListNode n1 = head.next;
        ListNode n2 = head.next.next;
        while(n2.next.next != null) {
            if (n1.equals(n2)) {
                ListNode n = head;
                while (!n.equals(n1)) {
                    n1 = n1.next;
                    n = n.next;
                }
                return n;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        return null;
    }
    
    static class ListNode {
    	int val;
    	ListNode next;
    	
    	ListNode(int v) {
    		val = v;
    		next = null;
    	}
    	
    	ListNode(int v, ListNode n) {
    		val = v;
    		next = n;
    	}
    	public String toString() {
    		return String.valueOf(val);
    	}
    }
    
    public static void main(String[] args) {
    	ListNode n4 = new ListNode(-4);
    	ListNode n3 = new ListNode(0, n4);
    	ListNode n2 = new ListNode(2, n3);
    	ListNode n1 = new ListNode(3, n2);
    	n4.next = n1;
    	
    	System.out.println(detectCycle(n1));
    	System.out.println(detectCycle2(n1));

    }
}
