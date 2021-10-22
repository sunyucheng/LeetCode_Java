package lc20211022;

public class ReverseList {
	 public ListNode reverseList(ListNode head) {
	        if(head == null){
	            return null;
	        }
	        if(head.next == null){
	            return head;
	        }
	        ListNode newHead = new ListNode(0);
	        ListNode temp = head;
	        ListNode next = null;
	        while(true){
	            if(temp == null){
	                break;
	            }
	            next = temp.next;
	            //β�巨��˳���ܸ��
	            temp.next = newHead.next;
	            newHead.next = temp;
	            temp = next;
	        }
	        return newHead.next;
	    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
