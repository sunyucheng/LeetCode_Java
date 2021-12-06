package lc20211202;

public class DeleteMthNode {
	//����д���ˣ�����������������һ�������������ĳ��ȣ�Ȼ���ҵ���Ҫɾ����ǰһ������λ�ã�Ȼ�����ɾ�����ɣ�
	//����������ͷ��㣬���Է��õ�����㹹�ɵ������ָ���쳣��Ҳ���Է���ɾ�������ͷ���
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
	
	//ɾ������ĵ�����n����㣬�������ҵ����������n������ǰһ����㣬Ȼ���ٽ���ɾ��
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //�ȹ�������ͷ��㣬��ֹɾ����һ����ʱ��ɾ����
        ListNode newHead = new ListNode(0);
        //������ͷ�����µ������ͷ����������
        newHead.next = head;
        //����һ����ʱ���
        ListNode temp = newHead;
        //ɾ�����ǵ����ڼ��������������ڼ�����������Ҫ��ͳ�Ƴ�����ĳ���
        int count = 0;
        while(true){
            if(temp == null){
                break;
            }
            count ++;
            temp = temp.next;
        }
        //�����ƶ�ָ�����
        temp = newHead;
        //ѭ���ҵ���n������ǰһ�����
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
