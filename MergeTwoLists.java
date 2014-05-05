
/**
 * Leetcode.com - Merge Two Sorted Lists
 * 
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 */
public class MergeTwoLists {

	private static ListNode root;
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            root = l1;
            l1 = l1.next;
        } else {
            root = l2;
            l2 = l2.next;
        }
        ListNode node = root;
        merge(node, l1, l2);
        return root;
    }
    
    private static void merge(ListNode node, ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return;
        if (l1 == null) {
            node.next = l2;
            return;
        }
        if (l2 == null) {
            node.next = l1;
            return;
        }
        if (l1.val < l2.val) {
            node.next = l1;
            l1 = l1.next;
        } else {
            node.next = l2;
            l2 = l2.next;
        }
        node = node.next;
        merge(node, l1, l2);
    }
	
	public static void main(String[] args){
		ListNode l3 = new ListNode(6);
		ListNode l2 = new ListNode(4);
		l2.next = l3;
		ListNode l1 = new ListNode(2);
		l1.next = l2;
		
		ListNode m3 = new ListNode(5);
		ListNode m2 = new ListNode(3);
		m2.next = m3;
		ListNode m1 = new ListNode(1);
		m1.next = m2;
		System.out.println(mergeTwoLists(l1,m1));
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		public String toString() {
			return String.valueOf(val + " -> " + next);
		}
	}

}
