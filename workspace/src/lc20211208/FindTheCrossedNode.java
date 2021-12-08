package lc20211208;

public class FindTheCrossedNode {
	public static void main(String[] args){
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode node1 = new ListNode(9);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(3);
		head1.next = node1;
		node1.next = node2;
		node2.next = node4;
		head2.next = node3;
		node3.next = node4;
		System.out.println(getIntersectionNode(head1,head2).val);
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //一个方法是用hashset记录一个链表里面的所有结点，然后和另一个结点对比
        //上面这个方法会耗费空间，比较好的方式是用两个指针
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        //这里的相等有两种情况，一个是temp1和temp2都为null的时候相等，还有一个是俩链表相交的情况
        while(temp1 != temp2){
            if(temp1 == null){
                temp1 = headB;
                //这里temp1和temp2向下移动一格还是要放到else里面，因为换头不需要移动一格
            }else{
                temp1 = temp1.next;
            }
            if(temp2 == null){
                temp2 = headA;
            }else{
                temp2 = temp2.next;
            }
        }
        return temp1 == null ? null : temp1;
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
