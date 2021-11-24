package lc20211123;

import java.util.*;

public class DifferentBSTII {
	public static void main(String[] args){
		//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树,并将不同组合的根结点存入res
		List<TreeNode> res = new ArrayList<>();
		res = generateTrees(3);
		for(TreeNode tree : res){
			System.out.println(tree.val);
		}
	}
	
	public static List<TreeNode> generateTrees(int n) {    
        //n = 0的情况，是给你一个整数0，那么就没有这个二叉树，则返回的是空的List
        //List中放的是根结点就好了
        if(n == 0){
            return new ArrayList<TreeNode>();
        }
        return help(1, n);
    }

    public static List<TreeNode> help(int left, int right){
        //这里的res不能作为全局变量
        List<TreeNode> res = new ArrayList<>();
        //left > right是一个空区间，但是空区间对应着空结点null，空结点也是一种情况
        if(left > right){
            res.add(null);
            return res;
        }
        //这是在遍历根结点：1.穷举root的所有可能
        for(int i = left; i <= right; i++){
         //2.递归构造出左右子树的所有合法BST,即枚举除了结点外的其他区间,存放到集合里
            List<TreeNode> lefttree = help(left , i - 1);
            List<TreeNode> righttree = help(i + 1, right);
            //3.为root结点穷举所有的左右子树的组合
            for(TreeNode l : lefttree){
                for(TreeNode r : righttree){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
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


