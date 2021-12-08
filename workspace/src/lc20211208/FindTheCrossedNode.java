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
        //һ����������hashset��¼һ��������������н�㣬Ȼ�����һ�����Ա�
        //�������������ķѿռ䣬�ȽϺõķ�ʽ��������ָ��
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        //�������������������һ����temp1��temp2��Ϊnull��ʱ����ȣ�����һ�����������ཻ�����
        while(temp1 != temp2){
            if(temp1 == null){
                temp1 = headB;
                //����temp1��temp2�����ƶ�һ����Ҫ�ŵ�else���棬��Ϊ��ͷ����Ҫ�ƶ�һ��
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
