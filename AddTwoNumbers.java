/**
 * Leetcode.com - Add Two Numbers
 * 
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * Input: 
 * (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 
 * Output: 
 * 7 -> 0 -> 8
 *
 */
public class AddTwoNumbers {
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if (l2 == null && l1 == null)
    		return new ListNode(0);
    	if (l2 == null)
    		return l1;
    	if (l1 == null)
    		return l2;
    	ListNode first = new ListNode((l1.val + l2.val) % 10);
    	ListNode last = first;
    	int carry = (l1.val + l2.val) / 10;
    	while(l1.next != null && l2.next != null) {
    		l1 = l1.next;
    		l2 = l2.next;
    		int total = l1.val + l2.val;
    		int n = (total + carry) % 10;
    		ListNode current = new ListNode(n);
    		carry = (total + carry) / 10;
    		last.next = current;
    		last = current;
    	}
    	sumLeft(l1, l2, last, carry);
    	
    	
    	return first;
    }
    
    public void sumLeft(ListNode l1, ListNode l2, ListNode last, int carry) {
    	ListNode left = null;
    	if (l1.next == null && l2.next == null) {
    		if (carry != 0)
    			last.next = new ListNode(carry);
    		return;
    	}
    	if (l1.next != null)
    		left = l1;
    	if (l2.next != null)
    		left = l2;
    	while (left.next != null) {
    		left = left.next;
    		ListNode current;
    		if (carry == 0)
    			current = new ListNode(left.val);
    		else {
        		int n = (left.val + carry) % 10;
        		current = new ListNode(n);
        		carry = (left.val + carry) / 10;
    		}
    		last.next = current;
    		last = current;
    	}		
    	if (carry != 0)
    		last.next = new ListNode(carry);
    }
    
    
    public static void main(String[] args) {
    	ListNode n1 = new ListNode(2);
    	ListNode n2 = new ListNode(4);
    	ListNode n3 = new ListNode(3);
    	n1.next= n2;
    	n2.next = n3;
    	
    	ListNode m1 = new ListNode(5);
    	ListNode m2 = new ListNode(6);
    	ListNode m3 = new ListNode(4);
    	m1.next = m2;
    	m2.next = m3;
    	
    	AddTwoNumbers a = new AddTwoNumbers();
    	ListNode result = a.addTwoNumbers(n1,  m1);
		System.out.print("Input: ");
		printList(n1);
		System.out.print(" + ");
		printList(m1);
		System.out.print("\nOutput: ");
		printList(result);

    }
    
    public static void printList(ListNode n) {
    	System.out.print("( ");
    	while(n != null) {
    		System.out.print(n.val);
    		if (n.next != null)
    			System.out.print(" -> ");
    		n = n.next;
    	}
    	System.out.print(" )");
    }
	 static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
			 val = x;
			 next = null;
		 }
		 
		 public String toString() {
			 return String.valueOf(val);
		 }
	 }
	 
}
