package lc20211210;

public class ReversePartOfList {
	static ListNode mid = null;
	public static void main(String[] args){
		ListNode head1 = new ListNode(3);
		ListNode node1 = new ListNode(5);
		head1.next = node1;
		ListNode res = reverseBetween(head1,1,2);
		ListNode temp = res;
		while(true){
			if(temp == null){
				break;
			}
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	
	//�⻹������ͨ�ķ�ת�������Ƿ�ת�����һ����
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // if(left == 1 || head.next == null ){
        //     return head;
        // }
        //���ҵ���Ҫ��ת���������е�ͷ���
        //��node��¼temp��ǰһ�����
        //����newHead�������㣬��ֹ��Ҫ��ת�������ͷ��ʼ��ʱ�򣬻���ֿ�ָ���쳣
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode temp = newHead;
        ListNode node = null;
         for(int i = 0 ; i < left; i++){
            if(i == left - 1){
                node = temp;
            }
            temp = temp.next;
        }
        //��ʱtemp����λ�Ӿ�����Ҫ��ת������ͷ
        ListNode res = reverseN(temp, right - left + 1);
        //System.out.println(node.val);
        node.next = res;
        return newHead.next;
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
