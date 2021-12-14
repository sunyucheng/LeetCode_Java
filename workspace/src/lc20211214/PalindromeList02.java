package lc20211214;

public class PalindromeList02 {
	public static void main(String[] args){
		ListNode head1 = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(1);
		head1.next = node1;
		node1.next = node2;
		node2.next = node3;
		System.out.println(isPalindrome(head1));
	}
	
	public static boolean isPalindrome(ListNode head) {
        //先通过快慢指针找到链表的中点,slow就是找到的中点
        ListNode slow = head;
        ListNode fast = head;
        while(true){
            if(fast == null || fast.next == null){
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //此时，当链表长度为偶数的时候，slow正好是对的，但是当链表长度为奇数的时候，slow需要向下移动一个指针，而当链表长度为奇数的时候，fast指针不是空
        if(fast != null){
            slow = slow.next;
        }
        //然后就是隐式将一个回文链表中的两个子链表进行比较
        ListNode left = head;
        ListNode right = reverse(slow);
        while(true){
            if(right == null){
                break;
            }
            if(right.val != left.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    //将链表反转的代码(将回文链表的后半部分反转)
    public static ListNode reverse(ListNode head){
        ListNode pre = null, cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {
   	 
    }
    ListNode(int val) { 
   	 this.val = val;
    }
    ListNode(int val, ListNode next) { 
   	 this.val = val; this.next = next; 
    }
}
