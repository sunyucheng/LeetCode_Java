package lc20211217;

public class PalindromeList03 {
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
	
	//���ÿ���˫ָ���ҵ�������е㣬�Ż��ռ临�Ӷ�
    public static boolean isPalindrome(ListNode head) {
        //�����Ҫ�ָ�ԭ�������״��ʱ�����Ҫ����������������������Ȼ���п�ָ������
        if(head == null){
            return true;
        }
        if(head.next == null){
            return true;
        }
        boolean flag = true;
        //����ͨ������ָ���ҵ�������е�
        //�ȶ������ָ��
        //p.q����������ڻָ�ԭ��������ṹ��ָ��
        ListNode p = null;
        ListNode slow = head;
        ListNode fast = head;
        //������Ϊ������ʱ�򣬿�ָ���ߵ��յ�ʱ����ָ���ߵ�������������е㣬������Ϊż����ʱ�򣬿�ָ���ߵ��յ��ʱ����ָ���ߵ����е����һ��
        while(true){
            if(fast == null || fast.next == null){
                p = slow;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            p = p.next;
            slow = slow.next;
        }
        ListNode res = reverse(slow);  //q
        ListNode temp1 = head;
        ListNode temp2 = res;
        while(true){
            if(temp1 == null || temp2 == null){
                break;
            }
            if(temp1.val != temp2.val){
                flag = false;
                break;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        p.next = res;
        return flag;
    }

    //���������Ҫ�õ���ת������
    public static ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        //�����µ�����ͷ���
        ListNode newHead = new ListNode(0);
        //�����ƶ�ָ��
        ListNode temp = head;
        //������һ��ָ��
        ListNode next = null;
        while(temp != null){
            next = temp.next;
            temp.next = newHead.next;
            newHead.next = temp;
            //ԭ���Ƿ�ת����ĺ�������д���ˣ���Ϊtemp.next�Ѿ�����ָ�룬���Բ�Ӧ��дtemp.next��Ӧ��дnext
            temp = next;
        }
        //�ı���ԭ����˳��֮���ٻָ�ԭ�����˳��
        return newHead.next;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { 
    	 val = x; 
     }
}
