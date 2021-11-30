package lc20211130;

public class FindKthNode {
	public static void main(String[] args){
		ListNode root1 = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		root1.next = node1;
		node1.next = node2;
		System.out.println(kthToLast(root1, 2));
	}
	
	public static int kthToLast(ListNode head, int k) {
        //ͨ������˫ָ��
        //������Ŀ��˵��֤k����Ч�ģ����ԾͲ���Ҫ����k�Ƿ�Խ��Ľ���
        if(head == null){
            return -1;
        }
        ListNode temp1 = head;
        //����Ӧ���Ǵ�1��ʼ���㣬��Ϊ��k���Ǵ�1����ģ�������k���൱�ھ�Ҫ�ƶ�k-1����λ
        for(int i = 1; i < k; i++){
            temp1 = temp1.next;
        }
        ListNode temp2 = head;
        while(true){
            if(temp1.next == null){
                break;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp2.val;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
