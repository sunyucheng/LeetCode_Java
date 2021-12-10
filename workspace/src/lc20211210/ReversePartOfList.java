package lc20211210;

public class ReversePartOfList {
	static ListNode mid = null;
	public static void main(String[] args){
		ListNode head1 = new ListNode(3);
		ListNode node1 = new ListNode(5);
		head1.next = node1;
		ListNode res = reverseBetween(head1,1,2);
		ListNode temp = res;
		while(true){
			if(temp == null){
				break;
			}
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	
	//这还不是普通的反转链表，这是反转链表的一部分
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // if(left == 1 || head.next == null ){
        //     return head;
        // }
        //先找到需要反转的链表序列的头结点
        //用node记录temp的前一个结点
        //构建newHead的虚拟结点，防止需要反转的链表从头开始的时候，会出现空指针异常
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode temp = newHead;
        ListNode node = null;
         for(int i = 0 ; i < left; i++){
            if(i == left - 1){
                node = temp;
            }
            temp = temp.next;
        }
        //此时temp所在位子就是需要反转的链表头
        ListNode res = reverseN(temp, right - left + 1);
        //System.out.println(node.val);
        node.next = res;
        return newHead.next;
    }

    //反转以head为起点的n个结点，返回新的头结点
	public static ListNode reverseN(ListNode head, int n){
		//这道题的关键就是一个是把mid找到，另一个就是怎么把head连到mid上面
		if(n == 1){
			//n == 1时候的head.next即为mid
			mid = head.next;
			//但是返回的是head.next的前一个结点，这是需要返回的头结点
			return head;
		}
		//链表反转的部分
		//反转前n个结点，其实只要反转n-1次
		ListNode last = reverseN(head.next, n - 1);
		//这是链表反转的部分
		head.next.next = head;
		//链接上未反转的部分
		head.next = mid;
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
