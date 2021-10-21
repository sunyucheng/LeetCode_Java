package lc20211021;
import java.util.*;
public class ReverseList {
	public static void main(String[] args){
		
	}
	
	 public int[] reversePrint(ListNode head) {
	    int index = 0;
	    int len = 0;
	    Deque<Integer> stack = new ArrayDeque<Integer>();
	    ListNode temp = head;
	    while(true){
	        if(temp == null){
	            break;
	        }
	        len++;
	        stack.addFirst(temp.val);
	        temp = temp.next;
	    }
	    int[] res = new int[len];
	    while(!stack.isEmpty()){
	        res[index++] = stack.removeFirst();
	    }
	    return res;
	}
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
