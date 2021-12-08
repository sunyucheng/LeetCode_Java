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
        //ʹ��hashset,hashset���治��װ����Integer��Ӧ��װ����ListNode�����ǶԵģ�װ����Integer�Ļ��Ͳ����ˣ��ҵľͲ�һ�����ཻ���
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
                //�����ҵ���Ӧ��break����while-true����ѭ�����棬�ҵ���Ӧ��break
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
