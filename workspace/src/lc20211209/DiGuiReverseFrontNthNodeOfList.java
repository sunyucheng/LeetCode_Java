package lc20211209;

public class DiGuiReverseFrontNthNodeOfList {
	//定义后继结点
	static ListNode mid = null;
	public static void main(String[] args){
		ListNode head1 = new ListNode(1);
		ListNode node1 = new ListNode(9);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(3);
		head1.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode res = reverseN(head1,2);
		ListNode temp = res;
		while(true){
			if(temp == null){
				break;
			}
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	
	//反转以head为起点的n个结点，返回新的头结点
	public static ListNode reverseN(ListNode head, int n){
		//这道题的关键就是一个是把mid找到，另一个就是怎么把head连到mid上面
		if(n == 1){
			//n == 1时候的head.next即为mid
			mid = head.next;
			//但是返回的是head.next的前一个结点，这是需要返回的头结点
			return head;
		}
		//链表反转的部分
		//反转前n个结点，其实只要反转n-1次
		ListNode last = reverseN(head.next, n - 1);
		//这是链表反转的部分
		head.next.next = head;
		//链接上未反转的部分
		head.next = mid;
		return last;
	}
}
