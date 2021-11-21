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
		//���������ӡ����
		print(root);
	}
	
	//��ӡ���Ľڵ�ֵ
	public static void print(TreeNode root){
		if(root == null){
			return;
		}
		System.out.println(root.val);
		print(root.left);
		print(root.right);
	}
	
	//����Bst����Ԫ�صĲ��룬Ӧ�������ҵ�Ҫ�����λ�ã�Ȼ���ٲ���
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            //����Ԫ��
            return new TreeNode(val);
        }
        if(root.val >= val){
            //��һ��.leftָ����root������Ҫ���ӵ������
            //�ڶ���.leftָ���ǵݹ�root��ڵ����еģ�֪��Ϊnull��ʱ�򣬴����µĽ�㣬���ӵ�����������
            root.left = insertIntoBST(root.left, val);
        }else{
            root.right = insertIntoBST(root.right, val);
        }
        //��󷵻ز���Ԫ��֮��ĸ��ڵ�
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
