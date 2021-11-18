package lc20211118;

public class TwoSum_2 {
	public static void main(String[] args){
		//构建两个链表2-4-3,5-6-4
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
		//计算两个链表的和
		ListNode res = addTwoNumbers(root1, root2);
		//定义移动指针，来遍历链表
		ListNode temp = res;
		while(true){
			if(temp == null){
				break;
			}
			//打印输出结果
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//开辟一个空间定义存放结果的结点
		ListNode res = new ListNode();
		//链表从前向后加,定义两个移动指针和新链表的移动指针
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		ListNode restemp = res;
		//定义一个标志位，标志位初始值为0，因为第一位不会有进位
		int flag = 0;
		while(temp1 != null || temp2 != null){
			int a = temp1 == null ? 0 : temp1.val;
			int b = temp2 == null ? 0 : temp2.val;
			//计算链表的值和标志位的和
			int resval = a + b + flag;
			//计算下一位的标志位
			flag = resval / 10;
			//将余数链接到restemp后面
			restemp.next = new ListNode(resval % 10);
			if(temp1 != null){
				temp1 = temp1.next;
			}
			if(temp2 != null){
				temp2 = temp2.next;
			}
			restemp = restemp.next;
		}
		//如果最后一次标志位为1的话说明有多余的一位进位
		if(flag == 1){
			restemp.next = new ListNode(1);
		}
		return res.next;
	}
}
