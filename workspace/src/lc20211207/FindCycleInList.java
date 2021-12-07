package lc20211207;

public class FindCycleInList {
	public static void main(String[] args){
		ListNode head = new ListNode(3);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(0);
		ListNode node3 = new ListNode(-4);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node1;
		System.out.println(hasCycle(head));
	}
	
	public static boolean hasCycle(ListNode head) {
        //本题采用的是快慢指针，慢指针前进一步，快指针前进两步，若快指针最后走到了空，说明无环，若快指针最后和慢指针相遇，说明有环
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        while(true){
            if(fast == null || fast.next == null){
                break;
            }
            //fast走两步和slow走一步一定是在判断相等的前面的，不然因为他们同起点就会一直相等了
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                flag = true;
                break;
            }
        }
        return flag;
        //我知道一开始为什么错了，就是因为if(slow == fast)这里没有break，这样有环的链表就永远不会跳出while循环
    }
}

class ListNode{
	//链表值
	int val;
	//链表的下一个结点
	ListNode next;
	//类的构造器
	ListNode(int x){
		val = x;
		next = null;
	}
}