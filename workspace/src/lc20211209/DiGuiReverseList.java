package lc20211209;

public class DiGuiReverseList {
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
		ListNode res = reverseList(head1);
		ListNode temp = res;
		while(true){
			if(temp == null){
				break;
			}
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	
	//�ݹ�淴ת����
    //���ڵݹ��㷨������Ҫ�ľ�����ȷ�ݹ麯���Ķ���
	//��Ҫ�����ݹ�ջ���棬Ҫ��ȷ�ݹ麯���Ķ���
    public static ListNode reverseList(ListNode head) {
        //�������ֻ��һ������ʱ������ķ�תҲ���Լ�
        if(head == null || head.next == null){
            return head;
        }
        //reverseList�����������head.nextΪ��㣬���ص��Ƿ�ת֮��������ͷ���
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {
    	 
     }
     ListNode(int val) { 
    	 this.val = val;
     }
     ListNode(int val, ListNode next) { 
    	 this.val = val; this.next = next; 
     }
 }
