package lc20211217;

public class PalindromeList03 {
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
	
	//采用快慢双指针找到链表的中点，优化空间复杂度
    public static boolean isPalindrome(ListNode head) {
        //如果想要恢复原链表的形状的时候就需要加上这两个附加条件，不然会有空指针的情况
        if(head == null){
            return true;
        }
        if(head.next == null){
            return true;
        }
        boolean flag = true;
        //首先通过快慢指针找到链表的中点
        //先定义快慢指针
        //p.q俩结点是用于恢复原来的链表结构的指针
        ListNode p = null;
        ListNode slow = head;
        ListNode fast = head;
        //当链表为奇数的时候，快指针走到终点时，慢指针走到了整个链表的中点，当链表为偶数的时候，快指针走到终点的时候，慢指针走到了中点的下一个
        while(true){
            if(fast == null || fast.next == null){
                p = slow;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            p = p.next;
            slow = slow.next;
        }
        ListNode res = reverse(slow);  //q
        ListNode temp1 = head;
        ListNode temp2 = res;
        while(true){
            if(temp1 == null || temp2 == null){
                break;
            }
            if(temp1.val != temp2.val){
                flag = false;
                break;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        p.next = res;
        return flag;
    }

    //这个方法需要用到反转链表函数
    public static ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        //创建新的虚拟头结点
        ListNode newHead = new ListNode(0);
        //创建移动指针
        ListNode temp = head;
        //创建下一个指针
        ListNode next = null;
        while(temp != null){
            next = temp.next;
            temp.next = newHead.next;
            newHead.next = temp;
            //原来是反转链表的函数这里写错了，因为temp.next已经改了指针，所以不应该写temp.next，应该写next
            temp = next;
        }
        //改变了原链表顺序之后再恢复原链表的顺序
        return newHead.next;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { 
    	 val = x; 
     }
}
