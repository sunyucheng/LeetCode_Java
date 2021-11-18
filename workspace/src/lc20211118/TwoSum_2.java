package lc20211118;

public class TwoSum_2 {
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
		while(temp1 != null || temp2 != null){
			int a = temp1 == null ? 0 : temp1.val;
			int b = temp2 == null ? 0 : temp2.val;
			//���������ֵ�ͱ�־λ�ĺ�
			int resval = a + b + flag;
			//������һλ�ı�־λ
			flag = resval / 10;
			//���������ӵ�restemp����
			restemp.next = new ListNode(resval % 10);
			if(temp1 != null){
				temp1 = temp1.next;
			}
			if(temp2 != null){
				temp2 = temp2.next;
			}
			restemp = restemp.next;
		}
		//������һ�α�־λΪ1�Ļ�˵���ж����һλ��λ
		if(flag == 1){
			restemp.next = new ListNode(1);
		}
		return res.next;
	}
}
