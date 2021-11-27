package lc20211127;

public class ManBinaryTree_CountOfNodes {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		System.out.println(countNodes(root));
	}
	
	//注意这道题的难点在于是完全二叉树，不是普通的二叉树
    public static int countNodes(TreeNode root) {
        //首先统计左右子树的高度，判断是否是一个满二叉树
        //然后这是一个特判
        if(root == null){
            return 0;
        }
        TreeNode temp1 = root;
        TreeNode temp2 = root;
        int left = 0;
        int right = 0;
        while(temp1 != null){
            temp1 = temp1.left;
            left++;
        }
        while(temp2 != null){
            temp2 = temp2.right;
            right++;
        }
        if(left == right){
            //因为Math函数返回的都是double类型的，所以要转换为int类型的
            return (int)Math.pow(2, left) - 1;
        }else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
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
