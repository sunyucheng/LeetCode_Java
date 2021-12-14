package lc20211214;

public class PalindromeList02 {
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
	
	public static boolean isPalindrome(ListNode head) {
        //��ͨ������ָ���ҵ�������е�,slow�����ҵ����е�
        ListNode slow = head;
        ListNode fast = head;
        while(true){
            if(fast == null || fast.next == null){
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //��ʱ����������Ϊż����ʱ��slow�����ǶԵģ����ǵ�������Ϊ������ʱ��slow��Ҫ�����ƶ�һ��ָ�룬����������Ϊ������ʱ��fastָ�벻�ǿ�
        if(fast != null){
            slow = slow.next;
        }
        //Ȼ�������ʽ��һ�����������е�������������бȽ�
        ListNode left = head;
        ListNode right = reverse(slow);
        while(true){
            if(right == null){
                break;
            }
            if(right.val != left.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    //������ת�Ĵ���(����������ĺ�벿�ַ�ת)
    public static ListNode reverse(ListNode head){
        ListNode pre = null, cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
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
