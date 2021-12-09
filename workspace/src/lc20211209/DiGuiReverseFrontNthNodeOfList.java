package lc20211209;

public class DiGuiReverseFrontNthNodeOfList {
	//�����̽��
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
	
	//��ת��headΪ����n����㣬�����µ�ͷ���
	public static ListNode reverseN(ListNode head, int n){
		//�����Ĺؼ�����һ���ǰ�mid�ҵ�����һ��������ô��head����mid����
		if(n == 1){
			//n == 1ʱ���head.next��Ϊmid
			mid = head.next;
			//���Ƿ��ص���head.next��ǰһ����㣬������Ҫ���ص�ͷ���
			return head;
		}
		//����ת�Ĳ���
		//��תǰn����㣬��ʵֻҪ��תn-1��
		ListNode last = reverseN(head.next, n - 1);
		//��������ת�Ĳ���
		head.next.next = head;
		//������δ��ת�Ĳ���
		head.next = mid;
		return last;
	}
}
