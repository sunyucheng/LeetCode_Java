package lc20211209;

public class DiGuiReverseList {
	public static void main(String[] args){
		ListNode head1 = new ListNode(1);
		ListNode node1 = new ListNode(9);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(3);
		head1.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode res = reverseList(head1);
		ListNode temp = res;
		while(true){
			if(temp == null){
				break;
			}
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	
	//递归版反转链表
    //对于递归算法，最重要的就是明确递归函数的定义
	//不要跳到递归栈里面，要明确递归函数的定义
    public static ListNode reverseList(ListNode head) {
        //当最后结点只有一个结点的时候，链表的反转也是自己
        if(head == null || head.next == null){
            return head;
        }
        //reverseList的意义就是以head.next为起点，返回的是反转之后的链表的头结点
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
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
