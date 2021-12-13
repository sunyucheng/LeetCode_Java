package lc20211213;

public class PalindromeList {
	static ListNode left;
	public static void main(String[] args){
		ListNode head1 = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(1);
		head1.next = node1;
		node1.next = node2;
		node2.next = node3;
		System.out.println(isPalindrome(head1));
	}
	
	//��ԭ����ת����һ���µ�����Ȼ��Ƚ������������Ƿ���ͬ
    //�����������ĺ���������˼·������Ҫ��ʽ��תԭʼ����Ҳ���Ե����������
    //�����ߵݹ�ṹ����������Ҳ��ǰ������ͺ������
    //������õ��Ǻ���������˼·
    //ģ��˫ָ���ж�����Ļ���
    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        left = head;
        return traverse(left);
    }

    //����ֻ��ǰ��ͺ�������
    public static boolean traverse(ListNode right){
        //����ǵݹ���ֹ���������ȵ��Ѹû��ݵĶ���������˳��ݹ���
        if(right == null){
            return true;
        }
        boolean res = traverse(right.next);
        //���д���������Ĵ���
        res = res && (right.val == left.val);
        left = left.next;
        return res;
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
