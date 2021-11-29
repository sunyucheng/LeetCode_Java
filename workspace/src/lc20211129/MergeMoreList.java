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
	
	//这里lists里面存入的，其实是链表里的头结点
    public static ListNode mergeKLists(ListNode[] lists) {
        //这里输入的是由数组构成的链表的数组集合，输出的是虚拟头结点
        //首先进行一个特判
        if(lists == null || lists.length == 0){
             return null;
        }
        //定义一个虚拟头结点
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        //定义一个优先队列（定义最小堆，输出的就是序列中的最小元素，原来的pq是最大堆）
        //刚刚的o2-o1是最大堆了，现在o1-o2才是最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1,o2)->(o1.val-o2.val));
        //pq.add()是先将头结点加入优先队列pq中
        //pq.poll()是让元素出队列
        //pq.isEmpty()是判断优先队列pq是否为空
        //将k个链表的头结点加入到最小堆
        for(ListNode head : lists){
            if(head != null){
                pq.add(head);
            }
        }
        while(!pq.isEmpty()){
            //让最小的元素一个个蹦出来
            ListNode node= pq.poll();
            temp.next = node;
            temp = temp.next;
            //当头结点加入到队列中，就将属于该头结点的下一个元素加入到队列中
            if(node.next != null){
                pq.add(node.next);
            }   
        }
        return newHead.next;
    }
}
