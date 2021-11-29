package lc20211129;

public class MergeList {
	public static void main(String[] args){
		ListNode root1 = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode root2 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		root1.next = node1;
		node1.next = node2;
		root2.next = node3;
		node3.next = node4;
		ListNode res = mergeTwoLists(root1,root2);
		ListNode temp = res;
		while(true){
			if(temp == null){
				break;
			}
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	
	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return list1;
        }
        if(list1 == null && list2 != null){
            return list2;
        }
        if(list2 == null && list1 != null){
            return list1;
        }
        ListNode newHead = new ListNode(0);
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode tempHead = newHead;
        while(true){
            if(temp1 == null || temp2 == null){
                break;
            }
            if(temp1.val > temp2.val){
                tempHead.next = temp2;
                temp2 = temp2.next;
            }else{
                tempHead.next = temp1;
                temp1 = temp1.next;
            }
            tempHead = tempHead.next;
        }
        if(temp1 != null){
            tempHead.next = temp1;
            temp1 = temp1.next;
        }
        if(temp2 != null){
            tempHead.next = temp2;
            temp2 = temp2.next;
        }
        return newHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
