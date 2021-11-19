package lc20211119;

public class VerifyBST {
	static boolean flag = true;
	public static void main(String[] args){
		TreeNode root = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(3);
		root.left = node1;
		root.right = node2;
		flag = isValidBST(root);
		System.out.println(flag);
	}

	//这里用的是反向判断法，
	public static boolean isValidBST(TreeNode root) {
	    //这是特殊值判断
	    if(root == null){
	        return false;
	    }
	    flag = help(root, null, null);
	        return flag;
	}

	//用于递归的函数,采用的是中序遍历
	//限定以root为根的子树节点必须满足max.val > root.val > min.val,因为bst树的左右子树也必须是
	public static boolean help(TreeNode root, TreeNode min, TreeNode max){
	    //递归退出的条件
	    if(root == null){
	        return true;
	    }
	    //限定遍历左子树的时候的最大值是root.val
	    help(root.left, min, root);
	    if(min != null && root.val <= min.val){
	        flag = false;
	    }
	    if(max != null && root.val >= max.val){
	        flag = false;
	    }
	    //限定遍历右子树的时候的最小值是root.val
	    help(root.right, root, max);
	    return flag;
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


