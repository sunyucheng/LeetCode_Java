package lc20211129;

import java.util.PriorityQueue;

public class MergeMoreList {
	public static void main(String[] args){
		ListNode root1 = new ListNode(1);
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(5);
		ListNode root2 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode root3 = new ListNode(2);
		ListNode node5 = new ListNode(6);
		root1.next = node1;
		node1.next = node2;
		root2.next = node3;
		node3.next = node4;
		root3.next = node5;
		ListNode[] lists = new ListNode[3];
		lists[0] = root1;
		lists[1] = root2;
		lists[2] = root3;
		ListNode res = mergeKLists(lists);
		ListNode temp = res;
		while(true){
			if(temp == null){
				break;
			}
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	
	//����lists�������ģ���ʵ���������ͷ���
    public static ListNode mergeKLists(ListNode[] lists) {
        //����������������鹹�ɵ���������鼯�ϣ������������ͷ���
        //���Ƚ���һ������
        if(lists == null || lists.length == 0){
             return null;
        }
        //����һ������ͷ���
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        //����һ�����ȶ��У�������С�ѣ�����ľ��������е���СԪ�أ�ԭ����pq�����ѣ�
        //�ոյ�o2-o1�������ˣ�����o1-o2������С��
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1,o2)->(o1.val-o2.val));
        //pq.add()���Ƚ�ͷ���������ȶ���pq��
        //pq.poll()����Ԫ�س�����
        //pq.isEmpty()���ж����ȶ���pq�Ƿ�Ϊ��
        //��k�������ͷ�����뵽��С��
        for(ListNode head : lists){
            if(head != null){
                pq.add(head);
            }
        }
        while(!pq.isEmpty()){
            //����С��Ԫ��һ�����ĳ���
            ListNode node= pq.poll();
            temp.next = node;
            temp = temp.next;
            //��ͷ�����뵽�����У��ͽ����ڸ�ͷ������һ��Ԫ�ؼ��뵽������
            if(node.next != null){
                pq.add(node.next);
            }   
        }
        return newHead.next;
    }
}
