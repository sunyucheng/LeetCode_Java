package lc20211117;

public class SumOfList {
	public static void main(String[] args){
		//构造一棵树，root为根节点，该树的先序遍历为123456
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		root.left = node1;
		root.right = node4;
		node1.left = node2;
		node1.right = node3;
		node4.right = node5;
		flatten(root);
		//定义临时变量进行链表的遍历
		TreeNode temp = root;
		while(true){
			if(temp == null){
				break;
			}
			System.out.println(temp.val);
			temp = temp.right;
		}
	}
	
	public static void flatten(TreeNode root){
		//递归退出的条件
		if(root == null){
			return;
		}
		//采用的是树的后序遍历，是自底而上的操作
		flatten(root.left);
		flatten(root.right);
		//当前root节点所要做的事情是将其左子树放到他的右子树的位置，然后将原来的右子树拼接到左子树的下面
		//首先记录已经变成为链表的左子树和右子树（因为是后序遍历，所以当前的左右子树已经是链表了）
		TreeNode left = root.left;
		TreeNode right = root.right;
		//然后将左子树放到root节点的右子树的位置
		root.right = left;
		root.left = null;
		//最后将原来的右子树链接到现在的链表的最下面
		//先定义一个遍历树的辅助指针
		TreeNode temp = root;
		while(true){
			if(temp.right == null){
				break;
			}
			temp = temp.right;
		}
		temp.right = right;
	}
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
