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
        //������õ��ǿ���ָ�룬��ָ��ǰ��һ������ָ��ǰ������������ָ������ߵ��˿գ�˵���޻�������ָ��������ָ��������˵���л�
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        while(true){
            if(fast == null || fast.next == null){
                break;
            }
            //fast��������slow��һ��һ�������ж���ȵ�ǰ��ģ���Ȼ��Ϊ����ͬ���ͻ�һֱ�����
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                flag = true;
                break;
            }
        }
        return flag;
        //��֪��һ��ʼΪʲô���ˣ�������Ϊif(slow == fast)����û��break�������л����������Զ��������whileѭ��
    }
}

class ListNode{
	//����ֵ
	int val;
	//�������һ�����
	ListNode next;
	//��Ĺ�����
	ListNode(int x){
		val = x;
		next = null;
	}
}