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
	
	//把原链表反转存入一个新的链表，然后比较这两个链表是否相同
    //借助二叉树的后续遍历的思路，不需要显式反转原始链表也可以倒叙遍历链表
    //链表兼具递归结构，所以链表也有前序遍历和后序遍历
    //本题采用的是后续遍历的思路
    //模拟双指针判断链表的回文
    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        left = head;
        return traverse(left);
    }

    //链表只有前序和后续遍历
    public static boolean traverse(ListNode right){
        //这就是递归终止的条件，等到把该回溯的都回溯完就退出递归了
        if(right == null){
            return true;
        }
        boolean res = traverse(right.next);
        //这边写后续遍历的代码
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
