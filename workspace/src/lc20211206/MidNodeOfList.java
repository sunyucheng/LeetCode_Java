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
        //���ⳣ��ķ�ʽ�ǣ��ҵ������м����ڵ��±�ֵ����������Ҫ������������
        //���Ա����Ƽ�ʹ�ÿ���ָ��ķ�ʽ
        //����ָ���ߵ���ĩβ����ĩβ����һ���ڵ�������ָ�����ڽ������м���
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            //��������[1,2,3,4,5,6]û��ȥ����Ϊ��ɾ����������ż������ʱ�򣬿�ָ��ͻ��ߵ����һ��������һ��nullֵ��������Ҫ���ж�fast�Ƿ�Ϊ�գ�����fast.next�ͻᱨ��ָ���쳣��
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
