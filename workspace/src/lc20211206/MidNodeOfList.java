package lc20211206;

public class MidNodeOfList {
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ListNode res = middleNode(head);
		System.out.println(res.val);
	}
	
	public static ListNode middleNode(ListNode head) {
        //本题常规的方式是：找到链表中间所在的下标值，这样就需要遍历两次链表
        //所以本题推荐使用快慢指针的方式
        //当快指针走到了末尾或者末尾的下一个节点就输出慢指针所在结点就是中间结点
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            //测试用例[1,2,3,4,5,6]没过去，因为当删除的链表是偶数个的时候，快指针就会走到最后一个结点的下一个null值，所以需要先判断fast是否为空，否则fast.next就会报空指针异常了
            if(fast == null || fast.next == null){
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
