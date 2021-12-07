package lc20211207;

public class FindCycleNodeInList {
	 public static void main(String[] args){
			ListNode head = new ListNode(3);
			ListNode node1 = new ListNode(2);
			ListNode node2 = new ListNode(0);
			ListNode node3 = new ListNode(-4);
			head.next = node1;
			node1.next = node2;
			node2.next = node3;
			node3.next = node1;
			System.out.println(detectCycle(head).val);
	 }
	
	 public static ListNode detectCycle(ListNode head) {
	        //�������ǰ��һ�������������Ƿ��л��Ļ���������
	        //�����󻷽�����ڿ���ָ��������ʱ������ָ�����㿪ʼ����ָ��������㿪ʼ������ͬ���ٶ��ƶ�����һ����������ǻ���㣨���֤��Ҫ�ᣩ
	        ListNode fast = head;
	        ListNode slow = head;
	        ListNode res = null;
	        while(true){
	            if(fast == null || fast.next == null){
	                break;
	            }
	            fast = fast.next.next;
	            slow = slow.next;
	            if(fast == slow){
	                slow = head;
	                //����һ��ʼ��ʱ��������ѭ���ˣ����Ծͻᵼ��ֻ����һ����Ҫ�жϣ�Ȼ���жϲ�������һֱ���������if��������
	                while(true){
	                //�л�������µĶ�������
	                if(fast == slow){
	                    res = fast;
	                    break;
	                }
	                fast = fast.next;
	                slow = slow.next;
	                }
	                //һֱ����ʱ�����Ƶ�ԭ�������ѭ����û������
	                //������Ϊ��һ��������ʱ��û��break
	                //��Ϊbreakֻ��������ǰѭ�������Եڶ���whileѭ����û��break
	                break;
	            }
	        }
	        return res;
	}
}
