package lc20211122;

public class DifferentBST {
	public static void main(String[] args){
		//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
		numTrees(5);
	}
	
	//二叉树算法的关键就是在于明确根结点需要做什么
    public static int numTrees(int n) {
        return count(1,n);
    }

    //闭区间l到h的数字能组成count(l,h)种bst
    //讲1-n看做是树的中序遍历
    public static int count(int l, int h){
        //空结点也算一种情况
        if(l > h){
            return 1;
        }
        int res = 0;
        //遍历每一个根节点
        for(int i = l; i <= h; i++){
            //计算左子树的情况
            int left = count(l, i - 1);
            //计算右子树的情况
            int right = count(i+1, h);
            res += left * right;
        }
        return res;
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
