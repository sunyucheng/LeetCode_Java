package lc20211208;
import java.util.*;
public class FindTheCrossedNode2 {
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
        //使用hashset,hashset里面不能装的是Integer，应该装的是ListNode，才是对的，装的是Integer的话就不对了，找的就不一定是相交结点
        HashSet<ListNode> hashset = new HashSet<>();
        ListNode temp1 = headA;
        ListNode res = null;
        while(true){
            if(temp1 == null){
                break;
            }
            hashset.add(temp1);
            temp1 = temp1.next;
        }
        ListNode temp2 = headB;
        while(true){
            if(hashset.contains(temp2)){
                res = temp2;
                //这里找到就应该break，在while-true的死循环里面，找到就应该break
                break;
            }
            if(temp2 == null){
                break;
            }
            temp2 = temp2.next;
        }
        return res == null ? null : res;
    }
}
