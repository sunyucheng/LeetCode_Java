package lc20211202;

public class DeleteMthNode {
	//终于写对了，遍历了两次链表，第一次用于求出链表的长度，然后找到需要删除的前一个结点的位置，然后进行删除即可，
	//利用了虚拟头结点，可以放置单个结点构成的链表空指针异常，也可以方便删除链表的头结点
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode res = removeNthFromEnd(head,2);
		ListNode temp = res;
		while(true){
			if(temp == null){
				break;
			}
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	
	//删除链表的倒数第n个结点，首先是找到这个倒数第n个结点的前一个结点，然后再进行删除
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //先构建虚拟头结点，防止删除第一个的时候删不掉
        ListNode newHead = new ListNode(0);
        //将虚拟头结点和新的链表的头结点进行连接
        newHead.next = head;
        //定义一个临时结点
        ListNode temp = newHead;
        //删除的是倒数第几个，不是正数第几个，所以需要先统计出链表的长度
        int count = 0;
        while(true){
            if(temp == null){
                break;
            }
            count ++;
            temp = temp.next;
        }
        //再让移动指针回来
        temp = newHead;
        //循环找到第n个结点的前一个结点
        for(int i = 0; i < count- n - 1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return newHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
