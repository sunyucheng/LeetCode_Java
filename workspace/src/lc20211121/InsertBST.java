package lc20211121;

import java.util.*;

public class InsertBST {
	public static void main(String[] args){
		TreeNode root = new TreeNode(4);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(3);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		TreeNode res = insertIntoBST(root,5);
		//先序遍历打印新树
		print(root);
	}
	
	//打印树的节点值
	public static void print(TreeNode root){
		if(root == null){
			return;
		}
		System.out.println(root.val);
		print(root.left);
		print(root.right);
	}
	
	//对于Bst树中元素的插入，应该是先找到要插入的位置，然后再插入
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            //插入元素
            return new TreeNode(val);
        }
        if(root.val >= val){
            //第一个.left指的是root的左结点要连接的情况，
            //第二个.left指的是递归root左节点现有的，知道为null的时候，创建新的结点，连接到他的左子树
            root.left = insertIntoBST(root.left, val);
        }else{
            root.right = insertIntoBST(root.right, val);
        }
        //最后返回插入元素之后的根节点
        return root;
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
