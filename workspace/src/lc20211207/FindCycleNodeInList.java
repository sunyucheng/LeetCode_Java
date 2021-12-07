package lc20211207;

public class FindCycleNodeInList {
	 public static void main(String[] args){
			ListNode head = new ListNode(3);
			ListNode node1 = new ListNode(2);
			ListNode node2 = new ListNode(0);
			ListNode node3 = new ListNode(-4);
			head.next = node1;
			node1.next = node2;
			node2.next = node3;
			node3.next = node1;
			System.out.println(detectCycle(head).val);
	 }
	
	 public static ListNode detectCycle(ListNode head) {
	        //这道题在前面一道题求链表中是否含有环的基础上做的
	        //这里求环结点是在快慢指针相遇的时候，让慢指针从起点开始，快指针从相遇点开始，以相同的速度移动，下一个相遇点就是环结点（这个证明要会）
	        ListNode fast = head;
	        ListNode slow = head;
	        ListNode res = null;
	        while(true){
	            if(fast == null || fast.next == null){
	                break;
	            }
	            fast = fast.next.next;
	            slow = slow.next;
	            if(fast == slow){
	                slow = head;
	                //这里一开始的时候忘记用循环了，所以就会导致只走了一步就要判断，然后判断不出来就一直卡在了这个if条件里面
	                while(true){
	                //有环的情况下的二次相遇
	                if(fast == slow){
	                    res = fast;
	                    break;
	                }
	                fast = fast.next;
	                slow = slow.next;
	                }
	                //一直超出时间限制的原因就是在循环里没跳出来
	                //就是因为第一次相遇的时候没有break
	                //因为break只能跳出当前循环，所以第二层while循环并没有break
	                break;
	            }
	        }
	        return res;
	}
}
