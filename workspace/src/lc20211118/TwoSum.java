package lc20211118;

public class TwoSum {
	public static void main(String[] args){
		//������������2-4-3,5-6-4
		ListNode root1 = new ListNode(2);
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(3);
		ListNode root2 = new ListNode(5);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(4);
		root1.next = node1;
		node1.next = node2;
		root2.next = node3;
		node3.next = node4;
		//������������ĺ�
		ListNode res = addTwoNumbers(root1, root2);
		//�����ƶ�ָ�룬����������
		ListNode temp = res;
		while(true){
			if(temp == null){
				break;
			}
			//��ӡ������
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//����һ���ռ䶨���Ž���Ľ��
		ListNode res = new ListNode();
		//�����ǰ����,���������ƶ�ָ�����������ƶ�ָ��
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		ListNode restemp = res;
		//����һ����־λ����־λ��ʼֵΪ0����Ϊ��һλ�����н�λ
		int flag = 0;
		while(true){
			//ѭ���˳�������
			if(temp1 == null || temp2 == null){
				break;
			}
			//���������ֵ�ͱ�־λ�ĺ�
			int resval = temp1.val + temp2.val + flag;
			//������һλ�ı�־λ
			flag = resval / 10;
			//���������ӵ�restemp����
			restemp.next = new ListNode(resval % 10);
			temp1 = temp1.next;
			temp2 = temp2.next;
			restemp = restemp.next;
		}
		return res.next;
		
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
