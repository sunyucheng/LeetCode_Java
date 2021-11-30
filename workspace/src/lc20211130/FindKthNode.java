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
        //通过链表双指针
        //这里题目中说保证k是有效的，所以就不需要进行k是否越界的矫正
        if(head == null){
            return -1;
        }
        ListNode temp1 = head;
        //这里应该是从1开始计算，因为第k个是从1计算的，倒数第k个相当于就要移动k-1个单位
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
